package com.acks.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acks.model.Shop;
import com.acks.reposetry.shoprepositeroy;

@Service
public class shopservice {
	
	@Autowired
	private shoprepositeroy shoprepositeroy;
	
	public Shop saveshop( Shop shop)
	{
		
		Shop s = shoprepositeroy.save(shop);
		return s;
		
		
	}
	
	public Optional<Shop> getdata(int shopid)
	{
		Optional<Shop> findById = shoprepositeroy.findById(shopid);
		return findById;
		
	}
	public List<Shop> getAlldata(Shop shop)
	{
	 List<Shop> findAll = shoprepositeroy.findAll();
		return findAll;
		
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		 shoprepositeroy.deleteById(id);
		
	}
	
	public Shop findbyname(String shopname)
	{
		Shop findByNameshopname = shoprepositeroy.findByshopname(shopname);
		return findByNameshopname;
		
	}
	
	public Shop findbynameandshopid(String shopname,int shopid)
	{
		Shop findByShopnameAndShopid = shoprepositeroy.findByShopnameAndShopid(shopname, shopid);
		return findByShopnameAndShopid;
		
	}

	
	


}
