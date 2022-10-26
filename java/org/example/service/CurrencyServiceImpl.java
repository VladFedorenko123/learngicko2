package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Currency;
import org.example.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private final CurrencyRepository currencyRepository;

    @Override
    public void createOrUpdateCryptoCurrencyPrice(String cryptoCurrency, String price) {
        currencyRepository.findByCryptoCurrency(cryptoCurrency).ifPresentOrElse(
                currency -> {
                    currencyRepository.updateDataOfCryptoCurrency(price, currency.getCryptoCurrency());
                },
                () -> {
                    Currency currencyBuilder = Currency.builder()
                            .cryptoCurrency(cryptoCurrency)
                            .price(price)
                            .build();
                    currencyRepository.save(currencyBuilder);
                });
    }

    @Override
    public void convertCryptoCurrency(String cryptoCurrency, double quantityCryptoCurrency) {
        var cryptoCurrencyPrice = currencyRepository.findByCryptoCurrency(cryptoCurrency).orElseThrow().getPrice();
        System.out.println(quantityCryptoCurrency + " " + cryptoCurrency + " = " + Double.parseDouble(cryptoCurrencyPrice) * quantityCryptoCurrency);
    }
}