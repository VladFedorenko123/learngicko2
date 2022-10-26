package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Currency;
import org.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {
    @Autowired
    private final CurrencyService currencyService;

    @PostMapping("{currency}")
    public void saveCurrency(@RequestBody Currency currency) {
        currencyService.createOrUpdateCryptoCurrencyPrice(currency.getCryptoCurrency(), currency.getPrice());
    }

    @PostMapping("{convert}")
    public void getCryptoCurrency(@RequestBody Currency currency) {
        currencyService.convertCryptoCurrency(currency.getCryptoCurrency(), currency.getQuantityCryptoCurrency());
    }
}