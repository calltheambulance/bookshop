package com.stc.web.services;

import com.stc.web.dto.AccountDto;
import com.stc.web.models.Role;
import com.stc.web.models.State;
import com.stc.web.models.account.Account;
import com.stc.web.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    @Override
    public void signUp(AccountDto accountDto) {
        Account account = Account.builder()
                .email(accountDto.getEmail())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .name(accountDto.getName())
                .surname(accountDto.getSurname())
                .phone(accountDto.getPhone())
                .state(State.CONFIRMED)
                .role(Role.USER)
                .build();
        accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByEmail(String accountEmail) {
        return accountRepository.findByEmail(accountEmail);
    }

    @Override
    public Optional<Account> findById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }


}
