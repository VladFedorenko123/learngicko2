package org.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class CurrencyDto {
    public static final String TABLE_NAME = "crypto_currency";

    @Column(name = CRYPTO_CURRENCY)
    public String cryptoCurrency;
    public static final String CRYPTO_CURRENCY = "crypto_currency";

    @Column(name = QUANTITY_CRYPTO_CURRENCY)
    public Double quantityCryptoCurrency;
    public static final String QUANTITY_CRYPTO_CURRENCY = "quantity_crypto_currency";
}
