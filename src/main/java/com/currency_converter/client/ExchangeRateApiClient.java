package com.currency_converter.client;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class ExchangeRateApiClient {
    private final WebClient webClient;

    public ExchangeRateApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.exchangerate.host")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .build();
    }

    public Map getConversion(String from, String to, double amount) {
        return webClient.get()
                .uri("/convert?from={from}&to={to}&amount={amount}", from, to, amount)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
