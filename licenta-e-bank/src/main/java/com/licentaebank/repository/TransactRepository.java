package com.licentaebank.repository;

import com.licentaebank.models.Transact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactRepository extends CrudRepository<Transact, Integer> {

    @Modifying
    @Query(value = "INSERT INTO transaction_history(account_id, transaction_type, amount, source, status, reason_code) VALUES(:account_id, :transact_type, :amount, :source, :status, :reason_code)", nativeQuery = true)
    @Transactional
    void logTransaction(@Param("account_id")int account_id,
                        @Param("transact_type")String transact_type,
                        @Param("amount")double amount,
                        @Param("source")String source,
                        @Param("status")String status,
                        @Param("reason_code")String reason_code);

    @Modifying
    @Query(value = "INSERT INTO transaction_history(account_id, transaction_type, amount, source, status, reason_code) VALUES(:account_id, :transact_type, :amount, :source, :status, :reason_code)", nativeQuery = true)
    @Transactional
    void logTransactionStringAmount(@Param("account_id")int account_id,
                                    @Param("transact_type")String transact_type,
                                    @Param("amount")String amount,
                                    @Param("source")String source,
                                    @Param("status")String status,
                                    @Param("reason_code")String reason_code);

}

