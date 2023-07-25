package com.example.clustereddataservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.clustereddataservice.entity.FxDeal;
import com.example.clustereddataservice.exception.DealValidationException;
import com.example.clustereddataservice.exception.DuplicateDealException;
import com.example.clustereddataservice.service.FxDealService;

@RestController
public class FxDealController {
	private static final Logger logger = LoggerFactory.getLogger(FxDealController.class);
	@Autowired
	private FxDealService fxDealService;

	@PostMapping("/fxdeals")
	public ResponseEntity<String> saveFxDeal(@RequestBody FxDeal fxDeal) {
		try {
			fxDealService.saveFxDeal(fxDeal);
			return ResponseEntity.ok("FX deal saved successfully.");
		} catch (DealValidationException | DuplicateDealException ex) {
			logger.error("Error while saving FX deal: {}", ex.getMessage());
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception ex) {
			logger.error("Unexpected error while saving FX deal: {}", ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
		}
	}
}
