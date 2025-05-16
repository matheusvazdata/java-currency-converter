package br.com.matheusvazdata.ui;

import br.com.matheusvazdata.service.ConversionLogger;
import br.com.matheusvazdata.service.CurrencyConverter;

import java.util.Scanner;

public class UserInterface {
    private final CurrencyConverter converter;
    private final ConversionLogger logger;

    public UserInterface(CurrencyConverter converter, ConversionLogger logger) {
        this.converter = converter;
        this.logger = logger;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("0")) {
                System.out.println("Encerrando o programa. Até mais!");
                break;
            } else if (choice.equals("H")) {
                logger.showHistory();
                continue;
            }

            String currency = converter.mapChoiceToCurrency(choice);

            if (currency == null) {
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.print("Digite o valor em USD: ");
            double usdAmount = scanner.nextDouble();
            scanner.nextLine(); // consumir o \n

            double converted = converter.convertFromUSD(currency, usdAmount);
            System.out.printf("%.2f USD = %.2f %s%n", usdAmount, converted, currency);

            logger.log(usdAmount, currency, converted);
        }
    }

    private void printMenu() {
        System.out.println("\n=== Conversor de Moedas ===");
        System.out.println("1 - ARS");
        System.out.println("2 - BOB");
        System.out.println("3 - BRL");
        System.out.println("4 - CLP");
        System.out.println("5 - COP");
        System.out.println("6 - USD");
        System.out.println("7 - EUR");
        System.out.println("8 - JPY");
        System.out.println("9 - GBP");
        System.out.println("0 - Sair");
        System.out.println("H - Ver Histórico de Conversões");
        System.out.print("Escolha a moeda: ");
    }
}