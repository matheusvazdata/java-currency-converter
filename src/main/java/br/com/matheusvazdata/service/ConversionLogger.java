package br.com.matheusvazdata.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionLogger {
    private final List<String> history = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void log(double usd, String currency, double converted) {
        String entry = String.format("[%s] %.2f USD = %.2f %s",
                LocalDateTime.now().format(formatter), usd, converted, currency);
        history.add(entry);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Nenhuma conversão registrada ainda.");
            return;
        }

        System.out.println("\n=== Histórico de Conversões ===");
        history.forEach(System.out::println);
    }
}