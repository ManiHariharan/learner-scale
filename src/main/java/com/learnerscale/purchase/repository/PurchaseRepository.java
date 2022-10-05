package com.learnerscale.purchase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnerscale.purchase.model.PurchaseModel;

public interface PurchaseRepository extends JpaRepository<PurchaseModel, Long> {

	List<PurchaseModel> findAllByUserId(Long userId);

}
