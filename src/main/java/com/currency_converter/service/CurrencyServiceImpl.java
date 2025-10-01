package com.currency_converter.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency_converter.client.ExchangeRateApiClient;
import com.currency_converter.model.ConversionResponse;

import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private ExchangeRateApiClient apiClient;

    @Override
    public ConversionResponse convertCurrency(String from, String to, double amount) {
        Map response = apiClient.getConversion(from, to, amount);

        ConversionResponse result = new ConversionResponse();
        result.setFrom(from);
        result.setTo(to);
        result.setAmount(amount);

        if (response != null) {
            Object rateObj = response.get("info") != null ? ((Map) response.get("info")).get("rate") : null;
            Object resultObj = response.get("result");

            if (rateObj instanceof Number) {
                result.setRate(((Number) rateObj).doubleValue());
            }
            if (resultObj instanceof Number) {
                result.setConvertedAmount(((Number) resultObj).doubleValue());
            }
        }

        return result;
    }

}
