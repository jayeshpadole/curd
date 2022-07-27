package com.acks.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acks.model.Shop;

@Repository
public interface shoprepositeroy extends JpaRepository<Shop, Integer>  {
	
	public Shop findByshopname(String  shopname);
	
	public Shop findByShopnameAndShopid(String shopname,int shopid);
	

}
