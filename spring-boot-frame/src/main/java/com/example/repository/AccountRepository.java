package com.example.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByUsername(String username);
    Account findAccountByUsernameLike(String str);
    @Query("update Account set password = ?2 where id = ?1")
    @Modifying
    @Transactional
    int updatePasswordById(int id,String newPassword);
}
