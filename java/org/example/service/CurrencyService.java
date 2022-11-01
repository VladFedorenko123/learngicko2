package org.example.service;

import org.example.model.Currency;

import java.util.List;

public interface CurrencyService {
    void createOrUpdateCryptoCurrencyPrice(List<Currency> currency);

    void convertCryptoCurrency(String cryptoCurrency, double quantityCryptoCurrency);
}