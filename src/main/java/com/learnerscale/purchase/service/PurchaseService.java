package com.learnerscale.purchase.service;

import java.util.List;

import com.learnerscale.purchase.model.PurchaseModel;

public interface PurchaseService {

	PurchaseModel savePurchase(PurchaseModel purchase);

	List<PurchaseModel> findAllPurchasesOfUser(Long userId);

}
