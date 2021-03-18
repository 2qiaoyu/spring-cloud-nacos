package com.joham.nacos.repository;

import com.joham.nacos.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joham
 */
public interface AccountDAO extends JpaRepository<Account, Long> {

    Account findByUserId(String userId);

}
