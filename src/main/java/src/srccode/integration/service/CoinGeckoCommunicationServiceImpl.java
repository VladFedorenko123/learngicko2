package src.srccode.integration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import src.srccode.integration.uri.CoinGeckoUriBuilder;
import src.srccode.model.CryptoCurrencyDto;

import java.net.URI;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class CoinGeckoCommunicationServiceImpl implements CoinGeckoCommunicationService {
    private final CoinGeckoUriBuilder coinGeckoUriBuilder;
    private final RestTemplate restTemplate;

    @Override
    public void sendCryptoCurrencyList(CryptoCurrencyDto cryptoCurrencyDto) {
        URI uri = coinGeckoUriBuilder.getSaveOrUpdateCryptoCurrency();
        HttpEntity<CryptoCurrencyDto> httpEntity = new HttpEntity<>(cryptoCurrencyDto);
        try {
            restTemplate.exchange(uri, POST, httpEntity, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
