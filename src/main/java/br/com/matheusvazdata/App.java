package br.com.matheusvazdata;

import br.com.matheusvazdata.api.ApiClient;
import br.com.matheusvazdata.model.ExchangeRates;
import br.com.matheusvazdata.service.ConversionLogger;
import br.com.matheusvazdata.service.CurrencyConverter;
import br.com.matheusvazdata.ui.UserInterface;

public class App {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        ExchangeRates rates = apiClient.getLatestRates();

        CurrencyConverter converter = new CurrencyConverter(rates);
        ConversionLogger logger = new ConversionLogger();

        UserInterface ui = new UserInterface(converter, logger);
        ui.start();
    }
}