package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Currency;
import org.example.model.CurrencyDto;
import org.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class Controller {
    @Autowired
    private final CurrencyService currencyService;

    @PostMapping
    public void saveCurrency(@RequestBody List<Currency> currency) {
        currencyService.createOrUpdateCryptoCurrencyPrice(currency);
    }

    @PostMapping("{convert}")
    public void getCryptoCurrency(@RequestBody CurrencyDto currency) {
        currencyService.convertCryptoCurrency(currency.getCryptoCurrency(), currency.getQuantityCryptoCurrency());
    }
}