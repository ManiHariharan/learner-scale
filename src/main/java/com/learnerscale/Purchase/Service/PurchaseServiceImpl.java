package com.learnerscale.Purchase.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnerscale.Purchase.Repository.PurchaseRepository;
import com.learnerscale.Purchase.model.PurchaseModel;

@Service
public class PurchaseServiceImpl implements PurchaseService
 {
	 @Autowired
	    private PurchaseRepository purchaseRepository;

	 
	 @Override
	    public PurchaseModel savePurchase(PurchaseModel purchase)
	    {
	        purchase.setPurchaseTime(LocalDateTime.now());

	        return purchaseRepository.save(purchase);
	    }
	   @Override 
	    public List<PurchaseModel> findAllPurchasesOfUser(Long userId)
	    {
	        return purchaseRepository.findAllByUserId(userId);
	    }

}
