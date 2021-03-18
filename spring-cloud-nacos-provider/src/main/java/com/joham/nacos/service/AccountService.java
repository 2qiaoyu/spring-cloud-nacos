package com.joham.nacos.service;

import com.joham.nacos.entity.Account;
import com.joham.nacos.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author joham
 */
@Service
public class AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountDAO accountDAO;

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        if ("1111".equals(userId)) {
            throw new RuntimeException("异常:模拟业务异常:Storage branch exception");
        }
        Account account = accountDAO.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountDAO.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
