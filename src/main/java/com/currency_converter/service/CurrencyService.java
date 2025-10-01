package com.currency_converter.service;

import com.currency_converter.model.ConversionResponse;

public interface CurrencyService {
    ConversionResponse convertCurrency(String from, String to, double amount);

}
