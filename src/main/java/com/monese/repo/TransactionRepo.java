package com.monese.repo;


import com.monese.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, Long> {

    @Query("FROM com.monese.Entity.TransactionEntity WHERE fromAcctNum = :id OR toAcctNum = :id")
    List<TransactionEntity> findByAccountId(String id);

}
