package com.example.model;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.exception.ExternalApiException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExchangeRateResponse {
	private String base_code;
	private Map<String, Double> conversion_rates;
	private String exchangeRateApiUrl;

	public String getBase_code() {
		return base_code;
	}

	public Map<String, Double> getConversion_rates() {
		return conversion_rates;
	}

	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}

	public void setConversion_rates(Map<String, Double> conversion_rates) {
		this.conversion_rates = conversion_rates;
	}
	
	public ExchangeRateResponse getExchangeRates(String base) {
	    
		String url = exchangeRateApiUrl + base;
	    try {
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

	        // Log response
	        System.out.println("API Response: " + response.getBody());

	        if (response.getStatusCode().is2xxSuccessful()) {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(response.getBody(), ExchangeRateResponse.class);
	        } else {
	            throw new ExternalApiException("Failed to fetch exchange rates. API Response: " + response.getBody());
	        }
	    } catch (Exception e) {
	        throw new ExternalApiException("Failed to fetch exchange rates: " + e.getMessage());
	    }
	}

}
