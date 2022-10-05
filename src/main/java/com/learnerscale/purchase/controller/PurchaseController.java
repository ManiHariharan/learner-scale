package com.learnerscale.purchase.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnerscale.purchase.model.PurchaseModel;
import com.learnerscale.purchase.service.PurchaseService;

@RestController
@RequestMapping("api/purchase") // Common Prefix for all these endPoints
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	/**
	 * SAVE using POST Mapping
	 */
	@PostMapping("/save1")
	public ResponseEntity<PurchaseModel> savePurchase1(@RequestBody PurchaseModel purchase) {
		return savePurchaseData(purchase);
	}

	/**
	 * SAVE using GET Mapping
	 */
	@GetMapping("/save2")
	public ResponseEntity<PurchaseModel> savePurchase2(@RequestBody PurchaseModel purchase) {
		return savePurchaseData(purchase);
	}

	/**
	 * SAVE using PathVariable
	 * 
	 * Example : http://127.0.0.1:4444/api/purchase/save/103/503/ABCD3/553
	 * 
	 * TESTED
	 */
	@GetMapping("/save3/{userId}/{courseId}/{title}/{price}")
	public ResponseEntity<PurchaseModel> savePurchase3(@PathVariable Long userId, @PathVariable Long courseId,
			@PathVariable String title, @PathVariable Double price) {

		PurchaseModel purchase = formPurchaseModel(userId, courseId, title, price);
		return savePurchaseData(purchase);
	}

	/**
	 * SAVE using RequestParam
	 * 
	 * Example :
	 * http://127.0.0.1:4444/api/purchase/save4?userId=104&courseId=504&title=ABCD4&price=554
	 * 
	 * TESTED
	 */
	@GetMapping("/save4")
	public ResponseEntity<PurchaseModel> savePurchase4(@RequestParam Long userId, @RequestParam Long courseId,
			@RequestParam String title, @RequestParam Double price) {

		PurchaseModel purchase = formPurchaseModel(userId, courseId, title, price);
		return savePurchaseData(purchase);
	}

	/**
	 * SAVE using RequestParam with name attribute
	 * 
	 * Example :
	 * http://127.0.0.1:4444/api/purchase/save5?user_id=105&course_id=505&title=ABCD5&price=555
	 * 
	 * TESTED
	 */
	@GetMapping("/save5")
	public ResponseEntity<PurchaseModel> savePurchase5(@RequestParam(name = "user_id") Long userId,
			@RequestParam(name = "course_id") Long courseId, @RequestParam String title, @RequestParam Double price) {

		PurchaseModel purchase = formPurchaseModel(userId, courseId, title, price);
		return savePurchaseData(purchase);
	}

	/**
	 * SAVE using RequestParam with name and default attribute
	 * 
	 * Example - 1: with [price]
	 * http://127.0.0.1:4444/api/purchase/save6?user_id=106&course_id=506&title=ABCD6&price=556
	 * 
	 * Example - 2: without [price]
	 * http://127.0.0.1:4444/api/purchase/save6?user_id=106&course_id=506&title=ABCD6
	 * 
	 * Example - 3: without [title] - ERROR
	 * http://127.0.0.1:4444/api/purchase/save6?user_id=106&course_id=506
	 * 
	 * TESTED
	 */
	@GetMapping("/save6")
	public ResponseEntity<PurchaseModel> savePurchase6(@RequestParam(name = "user_id") Long userId,
			@RequestParam(name = "course_id") Long courseId, @RequestParam String title,
			@RequestParam(defaultValue = "500.00") Double price) {

		PurchaseModel purchase = formPurchaseModel(userId, courseId, title, price);
		return savePurchaseData(purchase);
	}

	/**
	 * Common Method to form PurchaseModel input
	 */
	private PurchaseModel formPurchaseModel(Long userId, Long courseId, String title, Double price) {
		PurchaseModel purchase = new PurchaseModel();
		purchase.setUserId(userId);
		purchase.setCourseId(courseId);
		purchase.setTitle(title);
		purchase.setPrice(price);
		purchase.setPurchaseTime(LocalDateTime.now());
		return purchase;
	}

	private ResponseEntity<PurchaseModel> savePurchaseData(PurchaseModel purchase) {
		return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
	}

	private ResponseEntity<List<PurchaseModel>> getPurchaseData(Long userId) {
		List<PurchaseModel> purchaseList = purchaseService.findAllPurchasesOfUser(userId);
		return new ResponseEntity<>(purchaseList, HttpStatus.CREATED);
	}

	/**
	 * GET using PathVariable
	 * 
	 * Example : http://127.0.0.1:4444/api/purchase/get1/104
	 * 
	 * TESTED
	 */
	@GetMapping("/get1/{userId}")
	public ResponseEntity<List<PurchaseModel>> getPurchase1(@PathVariable Long userId) {
		List<PurchaseModel> purchaseList = purchaseService.findAllPurchasesOfUser(userId);
		return new ResponseEntity<>(purchaseList, HttpStatus.CREATED);
	}

	/**
	 * GET using RequestParam
	 * 
	 * Example : http://127.0.0.1:4444/api/purchase/get2?userId=105
	 * 
	 * TESTED
	 */
	@GetMapping("/get2")
	public ResponseEntity<List<PurchaseModel>> getPurchase2(@RequestParam Long userId) {
		return getPurchaseData(userId);
	}

	/**
	 * GET using RequestParam
	 * 
	 * Example : http://127.0.0.1:4444/api/purchase/get3?user_id=105
	 * 
	 * TESTED
	 * 
	 * ERROR Test : http://127.0.0.1:4444/api/purchase/get3?userId=105
	 */
	@GetMapping("/get3")
	public ResponseEntity<List<PurchaseModel>> getPurchase3(@RequestParam(name = "user_id") Long userId) {
		return getPurchaseData(userId);
	}
}
