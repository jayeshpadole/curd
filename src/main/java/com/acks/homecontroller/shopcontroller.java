package com.acks.homecontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acks.model.Shop;
import com.acks.sevice.shopservice;

@RestController
@ControllerAdvice
public class shopcontroller {

	@Autowired
	private shopservice shopservice;

	@RequestMapping("/shop")
	public String shop() {
		return "test";

	}

	@PostMapping("/save")
	public ResponseEntity<Shop> saveshop(@Valid  @RequestBody Shop shop) {
		try
		{
		 Shop s = this.shopservice.saveshop(shop);
			return ResponseEntity.status(HttpStatus.CREATED).body(s);
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<Optional<Shop>> show(@PathVariable int id) {
		
		try
		{
			Optional<Shop> getdata = this.shopservice.getdata(id);
			if(getdata.get().getShopid() ==id) {
				return  ResponseEntity.status(HttpStatus.OK).body(getdata);
		}
		
		}		
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return null;
		
		

		}
	
		
	@PutMapping("/update")
	public Shop updateshop(@RequestBody Shop shop) {
		Shop s = shopservice.saveshop(shop);
		return s;

	}

	@GetMapping("/showall")
	public List<Shop> showall(@RequestBody Shop shop) {
		List<Shop> alldata = shopservice.getAlldata(shop);
		return alldata;

	}

	@DeleteMapping("/delete/{id}")
	public String deleteshop(@PathVariable int id) {
		try {
	 Shop s = shopservice.getdata(id).get();
		if (s != null) {
			shopservice.delete(id);
			return "deleted";
		}
		else{
			return "no present";
		}
		}
       catch (Exception e) {
		// TODO: handle exception
    	   return "no present";
	
	}
		
		
	}
	@RequestMapping("/name/{shopname}")
	public Shop findbyname(@PathVariable  String shopname)
	{
		Shop findbyname = shopservice.findbyname(shopname);
		return findbyname;
		
	}
	@RequestMapping("/name/{shopname}/{shopid}")
	public Shop findbynameandid(@PathVariable  String shopname, @PathVariable int shopid)
	{
	Shop findbynameandshopid = shopservice.findbynameandshopid(shopname, shopid);
		return findbynameandshopid;
		
	}
	
}
