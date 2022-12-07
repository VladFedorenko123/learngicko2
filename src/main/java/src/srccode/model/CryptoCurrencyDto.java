package src.srccode.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CryptoCurrencyDto {
    private List<String> cryptoCurrencyList;
    private String currency;
}
