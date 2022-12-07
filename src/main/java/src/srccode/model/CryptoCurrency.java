package src.srccode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CryptoCurrency.TABLE_NAME)
public class CryptoCurrency {
    public static final String TABLE_NAME = "crypto_currency";

    @Id
    @Column(name = ID)
    public String id;
    private static final String ID = "uuid";

    @Column(name = CRYPTO_CURRENCY)
    public String cryptoCurrency;
    private static final String CRYPTO_CURRENCY = "crypto_currency_iso";

    @Column(name = PRICE)
    public String price;
    private static final String PRICE = "price";

    @Column(name = CURRENCY)
    public String currency;
    private static final String CURRENCY = "currency";

}
