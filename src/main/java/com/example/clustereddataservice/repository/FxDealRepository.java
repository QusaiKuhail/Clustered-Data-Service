package com.example.clustereddataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clustereddataservice.entity.FxDeal;

@Repository
public interface FxDealRepository extends JpaRepository<FxDeal, Long> {
    boolean existsByDealUniqueId(String dealUniqueId);

}
