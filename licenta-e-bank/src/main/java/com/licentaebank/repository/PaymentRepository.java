package com.licentaebank.repository;

import com.licentaebank.models.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    @Modifying
    @Query(value = "INSERT INTO payments(account_id, beneficiary, iban, amount, status, reason_code, details) VALUES" +
            "(:account_id, :beneficiary,:iban, :amount, :status, :reason_code, :details)", nativeQuery = true)
    @Transactional
    void makePayment(@Param("account_id")int account_id,
                     @Param("beneficiary")String beneficiary,
                     @Param("iban")String iban,
                     @Param("amount")double amount,
                     @Param("status")String status,
                     @Param("reason_code")String reason_code,
                     @Param("details")String details);
}