package src.srccode.integration.service;

import src.srccode.model.CryptoCurrencyDto;

public interface CoinGeckoCommunicationService {
    void sendCryptoCurrencyList(CryptoCurrencyDto cryptoCurrencyDto);
}
