package src.srccode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import src.srccode.model.CryptoCurrency;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, String> {
    Optional<CryptoCurrency> findByCryptoCurrency(String cryptoCurrency);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO crypto_currency VALUES (:uuid, :cryptoCurrency, :price) ON CONFLICT (crypto_currency_iso) DO UPDATE SET price = :price", nativeQuery = true)
    void insertOrUpdate(@Param("uuid") String uuid, @Param("cryptoCurrency") String cryptoCurrencyIso, @Param("price") String price);
}
