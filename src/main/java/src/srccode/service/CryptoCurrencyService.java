package src.srccode.service;

import src.srccode.model.CryptoCurrency;
import src.srccode.model.CryptoCurrencyDto;

import java.util.List;

public interface CryptoCurrencyService {
    void saveOrUpdateCryptoCurrency(List<CryptoCurrency> cryptoCurrencyList);
    void convertCryptoCurrency(CryptoCurrencyDto cryptoCurrencyDto);
}
