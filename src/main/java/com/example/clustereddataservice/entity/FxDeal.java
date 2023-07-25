package com.example.clustereddataservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fx_deals")
public class FxDeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "deal_unique_id", unique = true, nullable = false)
	private String dealUniqueId;

	@Column(name = "from_currency_iso_code", nullable = false)
	private String fromCurrencyIsoCode;

	@Column(name = "to_currency_iso_code", nullable = false)
	private String toCurrencyIsoCode;

	@Column(name = "deal_timestamp", nullable = false)
	private LocalDateTime dealTimestamp;

	@Column(name = "deal_amount", nullable = false)
	private double dealAmount;

	public FxDeal() {
	}

	public FxDeal(Long id, String dealUniqueId, String fromCurrencyIsoCode, String toCurrencyIsoCode,
			LocalDateTime dealTimestamp, double dealAmount) {
		this.id = id;
		this.dealUniqueId = dealUniqueId;
		this.fromCurrencyIsoCode = fromCurrencyIsoCode;
		this.toCurrencyIsoCode = toCurrencyIsoCode;
		this.dealTimestamp = dealTimestamp;
		this.dealAmount = dealAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealUniqueId() {
		return dealUniqueId;
	}

	public void setDealUniqueId(String dealUniqueId) {
		this.dealUniqueId = dealUniqueId;
	}

	public String getFromCurrencyIsoCode() {
		return fromCurrencyIsoCode;
	}

	public void setFromCurrencyIsoCode(String fromCurrencyIsoCode) {
		this.fromCurrencyIsoCode = fromCurrencyIsoCode;
	}

	public String getToCurrencyIsoCode() {
		return toCurrencyIsoCode;
	}

	public void setToCurrencyIsoCode(String toCurrencyIsoCode) {
		this.toCurrencyIsoCode = toCurrencyIsoCode;
	}

	public LocalDateTime getDealTimestamp() {
		return dealTimestamp;
	}

	public void setDealTimestamp(LocalDateTime dealTimestamp) {
		this.dealTimestamp = dealTimestamp;
	}

	public double getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(double dealAmount) {
		this.dealAmount = dealAmount;
	}

}
