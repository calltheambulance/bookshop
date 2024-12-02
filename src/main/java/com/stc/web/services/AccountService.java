package com.stc.web.services;

import com.stc.web.dto.AccountDto;
import com.stc.web.models.account.Account;

import java.util.Optional;


public interface AccountService {
    void signUp(AccountDto accountDto);
    Optional<Account> findByEmail(String accountEmail);
    Optional<Account> findById(long id);
    void deleteById(long id);


}
