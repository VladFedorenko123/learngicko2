package org.example.service;

import org.example.model.Currency;

public interface CurrencyService {
    void createOrUpdateCryptoCurrencyPrice(String currency, String price);

    void convertCryptoCurrency(String cryptoCurrency, double quantityCryptoCurrency);
}