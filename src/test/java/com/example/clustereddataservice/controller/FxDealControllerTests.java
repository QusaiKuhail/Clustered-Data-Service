package com.example.clustereddataservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.clustereddataservice.service.FxDealService;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
public class FxDealControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FxDealService fxDealService;

	@Test
	public void testSaveFxDeal_Success() throws Exception {
		mockMvc.perform(post("/fxdeals").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + "  \"dealUniqueId\": \"DEAL-2023-001\",\n" + "  \"fromCurrencyIsoCode\": \"USD\",\n"
						+ "  \"toCurrencyIsoCode\": \"EUR\",\n" + "  \"dealTimestamp\": \"2023-07-25T12:34:56Z\",\n"
						+ "  \"dealAmount\": 1000.50\n" + "}"))
				.andExpect(status().isOk()).andExpect(content().string("FX deal saved successfully."));
		verify(fxDealService, times(1)).saveFxDeal(any());
	}

	@Test
	public void testSaveFxDeal_ValidationFailed() throws Exception {
		mockMvc.perform(post("/fxdeals").contentType(MediaType.APPLICATION_JSON)
				.content(("{\n" + "  \"fromCurrencyIsoCode\": \"USD\",\n" + "}"))).andExpect(status().isBadRequest());
		verify(fxDealService, never()).saveFxDeal(any());
	}

}
