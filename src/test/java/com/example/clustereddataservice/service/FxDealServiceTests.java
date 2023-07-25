package com.example.clustereddataservice.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.clustereddataservice.entity.FxDeal;
import com.example.clustereddataservice.exception.DealValidationException;
import com.example.clustereddataservice.exception.DuplicateDealException;
import com.example.clustereddataservice.repository.FxDealRepository;

@SpringBootTest
public class FxDealServiceTests {

	@Mock
	private FxDealRepository fxDealRepository;

	@InjectMocks
	private FxDealService fxDealService;

	@Test
	public void testSaveFxDeal_Success() {
		FxDeal fxDeal = new FxDeal();
		fxDeal.setDealUniqueId("DEAL-2023-001");
		fxDeal.setFromCurrencyIsoCode("USD");
		fxDeal.setToCurrencyIsoCode("EUR");
		fxDeal.setDealTimestamp(LocalDateTime.now());
		fxDeal.setDealAmount(1000.50);
		when(fxDealRepository.save(any())).thenReturn(fxDeal);
		fxDealService.saveFxDeal(fxDeal);
		verify(fxDealRepository, times(1)).save(any());

	}

	@Test
	public void testSaveFxDeal_ValidationFailed() {
		FxDeal fxDeal = new FxDeal();
		fxDeal.setDealUniqueId("DEAL-2023-002");
		fxDeal.setToCurrencyIsoCode("EUR");
		fxDeal.setDealTimestamp(LocalDateTime.now());
		fxDeal.setDealAmount(1000.50);
		assertThrows(DealValidationException.class, () -> fxDealService.saveFxDeal(fxDeal));
		verify(fxDealRepository, never()).save(any());
	}

	@Test
	public void testSaveFxDeal_DuplicateDeal() {
		FxDeal existingDeal = new FxDeal();
		existingDeal.setDealUniqueId("DEAL-2023-003");
		existingDeal.setFromCurrencyIsoCode("USD");
		existingDeal.setToCurrencyIsoCode("EUR");
		existingDeal.setDealTimestamp(LocalDateTime.now());
		existingDeal.setDealAmount(1000.50);
		when(fxDealRepository.existsByDealUniqueId(eq("DEAL-2023-003"))).thenReturn(true);
		assertThrows(DuplicateDealException.class, () -> fxDealService.saveFxDeal(existingDeal));
		verify(fxDealRepository, never()).save(any());
	}

}
