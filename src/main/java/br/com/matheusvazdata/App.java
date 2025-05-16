package br.com.matheusvazdata;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class App {

    private static final String API_KEY = "141549ff0019a17a3462b582";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static final OkHttpClient client = new OkHttpClient();
    private static JsonObject taxas;
    private static final List<String> historico = new ArrayList<>();

    private static final Map<Integer, String> MOEDAS = Map.ofEntries(
            Map.entry(1, "ARS"),
            Map.entry(2, "BOB"),
            Map.entry(3, "BRL"),
            Map.entry(4, "CLP"),
            Map.entry(5, "COP"),
            Map.entry(6, "USD"),
            Map.entry(7, "EUR"),
            Map.entry(8, "JPY"),
            Map.entry(9, "GBP")
    );

    public static void main(String[] args) {
        taxas = obterTaxasDeCambio();
        if (taxas != null) {
            executarMenu();
        } else {
            System.out.println("Falha ao obter as taxas. Encerrando.");
        }
        encerrarOkHttp();
    }

    private static JsonObject obterTaxasDeCambio() {
        Request request = new Request.Builder().url(BASE_URL).build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonData = response.body().string();
                JsonObject jsonObject = new Gson().fromJson(jsonData, JsonObject.class);
                return jsonObject.getAsJsonObject("conversion_rates");
            } else {
                System.out.println("Falha ao obter taxas. Código HTTP: " + response.code());
            }
        } catch (IOException e) {
            System.out.println("Erro de requisição: " + e.getMessage());
        }
        return null;
    }

    private static void executarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            exibirMenu();
            String opcao = scanner.nextLine().toUpperCase();
            if (opcao.equals("0")) {
                System.out.println("Encerrando o programa. Até mais!");
                break;
            } else if (opcao.equals("H")) {
                exibirHistorico();
            } else {
                try {
                    int numeroOpcao = Integer.parseInt(opcao);
                    if (MOEDAS.containsKey(numeroOpcao)) {
                        processarConversao(scanner, MOEDAS.get(numeroOpcao));
                    } else {
                        System.out.println("Opção inválida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Conversor de Moedas ===");
        MOEDAS.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println("0 - Sair");
        System.out.println("H - Ver Histórico de Conversões");
        System.out.print("Opção: ");
    }

    private static void processarConversao(Scanner scanner, String moedaDestino) {
        System.out.print("Digite o valor em USD a ser convertido: ");
        try {
            double valorUsd = Double.parseDouble(scanner.nextLine());
            double taxa = taxas.get(moedaDestino).getAsDouble();
            double resultado = valorUsd * taxa;
            String log = String.format("[%s] %.2f USD = %.2f %s",
                    LocalDateTime.now(), valorUsd, resultado, moedaDestino);
            System.out.println(log);
            historico.add(log);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido.");
        } catch (Exception e) {
            System.out.println("Erro ao realizar conversão: " + e.getMessage());
        }
    }

    private static void exibirHistorico() {
        System.out.println("\n=== Histórico de Conversões ===");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            historico.forEach(System.out::println);
        }
    }

    private static void encerrarOkHttp() {
        client.dispatcher().executorService().shutdown();
        client.connectionPool().evictAll();
        System.out.println("Recursos do OkHttp fechados corretamente.");
    }
}