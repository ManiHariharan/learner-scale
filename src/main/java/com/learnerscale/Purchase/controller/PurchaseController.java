package com.learnerscale.Purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnerscale.Purchase.Service.PurchaseService;
import com.learnerscale.Purchase.model.PurchaseModel;

@RestController
@RequestMapping("api/purchase")//pre-path
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	@PostMapping //api/purchase
	public ResponseEntity<?> savePurchase1(@RequestBody PurchaseModel purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }
	@GetMapping("{userId}")//api/purchase/{userId}
	public ResponseEntity<?> savePurchase(@RequestBody PurchaseModel purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }
}
