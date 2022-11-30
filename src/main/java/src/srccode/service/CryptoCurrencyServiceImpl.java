package src.srccode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import src.srccode.model.CryptoCurrency;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.repository.CryptoCurrencyRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {
    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    @Override
    public void saveOrUpdateCryptoCurrency(List<CryptoCurrency> cryptoCurrencyList) {
        cryptoCurrencyList.forEach(cryptoCurrency -> cryptoCurrencyRepository.insertOrUpdate(cryptoCurrency.getUuid(), cryptoCurrency.getCryptoCurrency(), cryptoCurrency.getPrice()));
    }

    @Override
    public void convertCryptoCurrency(CryptoCurrencyDto cryptoCurrencyDto){
        var cryptoCurrencyPrice = Double.parseDouble(cryptoCurrencyRepository.findByCryptoCurrency(cryptoCurrencyDto.getCryptoCurrency())
                .orElseThrow()
                .getPrice());

        var quantityCryptoCurrency = cryptoCurrencyDto.getQuantityCryptoCurrency();

        System.out.println(quantityCryptoCurrency+ "=" + cryptoCurrencyPrice * quantityCryptoCurrency);
    }
}
