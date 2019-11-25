package com.ekart.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ekart.cart.dto.AddCartDto;
import com.ekart.cart.dto.CartDetailsDto;
import com.ekart.cart.dto.CartDto;
import com.ekart.cart.dto.ProductDto;
import com.ekart.cart.entity.Cart;
import com.ekart.cart.service.CartHystrixService;
import com.ekart.cart.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	CartHystrixService cartHystService;
	@PostMapping("/cart/{userId}/addtokart")
	public boolean addToKartOfUser(@RequestBody AddCartDto dto,@PathVariable String userId) {
		return cartService.addToKartOfUser(dto, userId);
	}
	@GetMapping("/cart/{userId}/kart")
	public CartDto getKartOfUser(@PathVariable String userId) throws InterruptedException, ExecutionException {
		List<Cart> carts=cartService.getKartOfUser(userId);
		CartDto toRet=new CartDto();
		List<CartDetailsDto> cartDetails=new ArrayList<>();
		double totalprice=0.0;
		int totaldeliverycharge=0;
		for(Cart cart:carts) {
			Future<ProductDto> futureProductDto=cartHystService.getSpecificProduct(cart.getCartId().getProduct_id());
			ProductDto productDto=futureProductDto.get();
			CartDetailsDto cartDetailsDto=new CartDetailsDto();
			cartDetailsDto.setDisplayName(productDto.getDisplayName());
			cartDetailsDto.setCategory(productDto.getCategory());
			int deliveryCharge=productDto.getDeliveryCharge();
			cartDetailsDto.setDeliveryCharge(deliveryCharge);
			double price=productDto.getPrice();
			cartDetailsDto.setPrice(price);
			int discount=productDto.getDiscount();
			totaldeliverycharge+=deliveryCharge;
			totalprice=totalprice+(price*cart.getQuantity()-((price*discount*cart.getQuantity())/100));
			cartDetailsDto.setTotal(price*cart.getQuantity()-((price*discount*cart.getQuantity())/100));
			cartDetailsDto.setQuantity(cart.getQuantity());
			cartDetailsDto.setProduct_id(cart.getCartId().getProduct_id());
			cartDetails.add(cartDetailsDto);
		}
		toRet.setCartdetails(cartDetails);
		toRet.setTotalPrice(totalprice);
		if(totalprice>1000)
			totaldeliverycharge=0;
		toRet.setTotalDeliveryCharge(totaldeliverycharge);
		toRet.setGrandTotal(totalprice+totaldeliverycharge);
		return toRet;
	}
	@PostMapping("/cart/{userId}/modifykart/update")
	public boolean updateKartOfUser(@RequestBody AddCartDto dto,@PathVariable String userId) {
		return cartService.updateKartOfUser(dto,userId);
	}
	@PostMapping("/cart/{userId}/modifykart/delete")
	public void updateKartDeleteOfUser(@RequestBody AddCartDto dto,@PathVariable String userId) {
		cartService.updateKartDeleteOfUser(dto,userId);
	}
	@GetMapping("/cart/{userId}/cartcount")
	public int getCartCountOfUser(@PathVariable String userId) {
		return cartService.getCartCountOfUser(userId);
	}
}
