package com.learnerscale.Purchase.Service;

import java.util.List;

import com.learnerscale.Purchase.model.PurchaseModel;

public interface PurchaseService {

	PurchaseModel savePurchase(PurchaseModel purchase);

	List<PurchaseModel> findAllPurchasesOfUser(Long userId);

}
