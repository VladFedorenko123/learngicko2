package src.srccode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import src.srccode.model.CryptoCurrency;
import src.srccode.model.CryptoCurrencyDto;
import src.srccode.service.CryptoCurrencyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cryptoCurrency")
public class Controller {
    private final CryptoCurrencyService cryptoCurrencyService;

    @PostMapping
    public void saveOrUpdateCryptoCurrency(@RequestBody List<CryptoCurrency> cryptoCurrencyList) {
        cryptoCurrencyService.saveOrUpdateCryptoCurrency(cryptoCurrencyList);
    }

    @PostMapping("{convert}")
    public void convertCryptoCurrency(@RequestBody CryptoCurrencyDto cryptoCurrencyDto) {
        cryptoCurrencyService.convertCryptoCurrency(cryptoCurrencyDto);
    }
}
