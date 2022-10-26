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
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Optional<Currency> findByCryptoCurrency(String cryptoCurrency);

    @Transactional
    @Modifying
    @Query(value = "UPDATE crypto_currency set price = :newPrice WHERE crypto_currency = :currency", nativeQuery = true)
    void updateDataOfCryptoCurrency(@Param("newPrice") String price, @Param("currency") String cryptoCurrency);
}
