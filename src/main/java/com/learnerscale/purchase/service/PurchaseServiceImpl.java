package com.learnerscale.purchase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnerscale.purchase.model.PurchaseModel;
import com.learnerscale.purchase.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public PurchaseModel savePurchase(PurchaseModel purchase) {
		purchase.setPurchaseTime(LocalDateTime.now());

		return purchaseRepository.save(purchase);
	}

	@Override
	public List<PurchaseModel> findAllPurchasesOfUser(Long userId) {
		return purchaseRepository.findAllByUserId(userId);
	}

}
