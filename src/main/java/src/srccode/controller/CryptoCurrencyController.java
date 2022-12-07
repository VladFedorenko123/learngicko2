package src.srccode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import src.srccode.model.CryptoCurrency;
import src.srccode.service.CryptoCurrencyService;

import java.util.List;
import java.lang.Double;

@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class CryptoCurrencyController {
    private final CryptoCurrencyService cryptoCurrencyService;

    @PostMapping("/currency")
    public void sendCryptoCurrencyList(@RequestParam String currency) {
        cryptoCurrencyService.sendCryptoCurrency(currency);
    }

    @PostMapping("/cryptoCurrencyWithPrice")
    public void getCryptoCurrencyWithPrice(@RequestBody List<CryptoCurrency> cryptoCurrencyList) {
        System.out.println(cryptoCurrencyList);
        cryptoCurrencyService.saveOrUpdateCryptoCurrency(cryptoCurrencyList);
    }

    @GetMapping("/convert")
    public void convertCryptoCurrency(@RequestParam Double quantity, @RequestParam String cryptoCurrency, @RequestParam String currency) {
        cryptoCurrencyService.convertCurrency(quantity, cryptoCurrency, currency);
    }
}
