package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Currency.TABLE_NAME)
public class Currency {
    public static final String TABLE_NAME = "crypto_currency";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID)
    public Integer id;
    public static final String ID = "id";

    @Column(name = CRYPTO_CURRENCY)
    public String cryptoCurrency;
    public static final String CRYPTO_CURRENCY = "crypto_currency";

    @Column(name = PRICE)
    public String price;
    public static final String PRICE = "price";

    @Column(name = QUANTITY_CRYPTO_CURRENCY)
    public Double quantityCryptoCurrency;
    public static final String QUANTITY_CRYPTO_CURRENCY = "quantity_crypto_currency";
}
