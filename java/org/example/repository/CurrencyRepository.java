package org.example.repository;

import org.example.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {
    Optional<Currency> findByCryptoCurrency(String cryptoCurrency);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO crypto_currency VALUES (:uuid, :cryptoCurrency, :price) ON CONFLICT (crypto_currency) DO UPDATE SET price = :price", nativeQuery = true)
    void insertOrUpdate(@Param("uuid") String uuid, @Param("cryptoCurrency") String cryptoCurrency, @Param("price") String price);

    @Transactional
    @Modifying
    @Query(value = "UPDATE crypto_currency set price = :quantity WHERE crypto_currency = :currency", nativeQuery = true)
    void updateQuantity(@Param("quantity") String price, @Param("currency") String cryptoCurrency);

}
