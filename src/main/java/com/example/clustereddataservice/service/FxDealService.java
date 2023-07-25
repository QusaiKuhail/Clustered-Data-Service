package com.example.clustereddataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clustereddataservice.entity.FxDeal;
import com.example.clustereddataservice.exception.DealValidationException;
import com.example.clustereddataservice.exception.DuplicateDealException;
import com.example.clustereddataservice.repository.FxDealRepository;

@Service
public class FxDealService {

	@Autowired
	private FxDealRepository fxDealRepository;

	public void saveFxDeal(FxDeal fxDeal) {
		// Validate the FX deal data
		if (fxDeal.getDealUniqueId() == null || fxDeal.getDealUniqueId().isEmpty()
				|| fxDeal.getFromCurrencyIsoCode() == null || fxDeal.getFromCurrencyIsoCode().isEmpty()
				|| fxDeal.getToCurrencyIsoCode() == null || fxDeal.getToCurrencyIsoCode().isEmpty()
				|| fxDeal.getDealTimestamp() == null || fxDeal.getDealAmount() <= 0) {
			throw new DealValidationException("FX deal data is not valid. Please check all required fields.");
		}

		// Check for duplicate deals
		if (fxDealRepository.existsByDealUniqueId(fxDeal.getDealUniqueId())) {
			throw new DuplicateDealException("FX deal with the same unique ID already exists.");
		}

		// If the deal is valid and not a duplicate, save it to the database using the
		// repository
		fxDealRepository.save(fxDeal);
	}

}
