package br.com.matheusvazdata.api;

import br.com.matheusvazdata.model.ExchangeRates;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/141549ff0019a17a3462b582/latest/USD";

    public ExchangeRates getLatestRates() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(API_URL).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code: " + response);

            String responseBody = response.body().string();
            Gson gson = new Gson();
            return gson.fromJson(responseBody, ExchangeRates.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch exchange rates", e);
        }
    }
}