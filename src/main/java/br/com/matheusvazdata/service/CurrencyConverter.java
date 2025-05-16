package br.com.matheusvazdata.service;

import br.com.matheusvazdata.model.ExchangeRates;

public class CurrencyConverter {
    private final ExchangeRates rates;

    public CurrencyConverter(ExchangeRates rates) {
        this.rates = rates;
    }

    public double convertFromUSD(String currencyCode, double amount) {
        double rate = rates.getRate(currencyCode);
        return amount * rate;
    }

    public String mapChoiceToCurrency(String choice) {
        return switch (choice) {
            case "1" -> "ARS";
            case "2" -> "BOB";
            case "3" -> "BRL";
            case "4" -> "CLP";
            case "5" -> "COP";
            case "6" -> "USD";
            case "7" -> "EUR";
            case "8" -> "JPY";
            case "9" -> "GBP";
            default -> null;
        };
    }
}