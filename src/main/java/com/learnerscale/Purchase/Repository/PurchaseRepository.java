package com.learnerscale.Purchase.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnerscale.Purchase.model.PurchaseModel;

public interface PurchaseRepository extends JpaRepository<PurchaseModel, Long> {
	List<PurchaseModel> findAllByUserId(Long userId);
}
