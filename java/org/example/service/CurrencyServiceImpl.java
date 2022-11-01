package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Currency;
import org.example.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private final CurrencyRepository currencyRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrUpdateCryptoCurrencyPrice(List<Currency> cryptoCurrency) {
        cryptoCurrency.forEach(currency -> currencyRepository.insertOrUpdate(currency.getUuid(), currency.getCryptoCurrency(), currency.getPrice()));
    }

    @Override
    public void convertCryptoCurrency(String cryptoCurrency, double quantityCryptoCurrency) {
        var cryptoCurrencyPrice = currencyRepository.findByCryptoCurrency(cryptoCurrency).orElseThrow().getPrice();
        System.out.println(quantityCryptoCurrency + " " + cryptoCurrency + " = " + Double.parseDouble(cryptoCurrencyPrice) * quantityCryptoCurrency);
    }
}