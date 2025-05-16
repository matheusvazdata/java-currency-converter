package br.com.matheusvazdata.model;

import java.util.Map;

public class ExchangeRates {
    private Map<String, Double> conversion_rates;

    public double getRate(String currencyCode) {
        return conversion_rates.getOrDefault(currencyCode, 1.0);
    }
}