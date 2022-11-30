package src.srccode.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CryptoCurrency.TABLE_NAME)
public class CryptoCurrency {
    public static final String TABLE_NAME = "crypto_currency";

    @Id
    @Column(name = ID)
    public String uuid;
    public static final String ID = "uuid";

    @Column(name = CRYPTO_CURRENCY)
    public String cryptoCurrency;
    public static final String CRYPTO_CURRENCY = "crypto_currency_iso";

    @Column(name = PRICE)
    public String price;
    public static final String PRICE = "price";
}
