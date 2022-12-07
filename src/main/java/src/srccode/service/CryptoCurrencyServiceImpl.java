package src.srccode.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import src.srccode.integration.service.CoinGeckoCommunicationService;
import src.srccode.model.CryptoCurrency;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.repository.CryptoCurrencyRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {
    @Value("${crypto.currency.list}")
    private final List<String> listCryptoCurrency;
    private final CoinGeckoCommunicationService coinGeckoCommunicationService;
    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    @Override
    public void sendCryptoCurrency(String currency) {
        CryptoCurrencyDto cryptoCurrencyDtoList = buildCurrency(listCryptoCurrency, currency);

        coinGeckoCommunicationService.sendCryptoCurrencyList(cryptoCurrencyDtoList);
    }

    @Override
    public void saveOrUpdateCryptoCurrency(List<CryptoCurrency> cryptoCurrencyList) {
        cryptoCurrencyList.forEach(cryptoCurrency -> cryptoCurrencyRepository.insertOrUpdate(String.valueOf(UUID.randomUUID()), cryptoCurrency.getCryptoCurrency(), cryptoCurrency.getPrice(), cryptoCurrency.getCurrency()));
    }

    @Override
    public void convertCurrency(Double quantity, String cryptoCurrency, String currency) {
        CryptoCurrencyDto cryptoCurrencyDto = buildCurrency(Collections.singletonList(cryptoCurrency), currency);

        coinGeckoCommunicationService.sendCryptoCurrencyList(cryptoCurrencyDto);

        Double price = Double.parseDouble(cryptoCurrencyRepository.findByCryptoCurrency(cryptoCurrency).orElseThrow().getPrice());

        log.info(quantity + " " + cryptoCurrency + " = " + price + " " + currency);
    }

    private CryptoCurrencyDto buildCurrency(List<String> cryptoCurrencyList, String currency) {
        return CryptoCurrencyDto.builder()
                .cryptoCurrencyList(cryptoCurrencyList)
                .currency(currency)
                .build();
    }
}
