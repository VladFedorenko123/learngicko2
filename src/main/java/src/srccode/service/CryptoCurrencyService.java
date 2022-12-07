package src.srccode.service;

import src.srccode.model.CryptoCurrency;

import java.util.List;

public interface CryptoCurrencyService {
    void sendCryptoCurrency(String currency);

    void saveOrUpdateCryptoCurrency(List<CryptoCurrency> cryptoCurrencyList);

    void convertCurrency(Double quantity, String cryptoCurrency, String currency);
}
