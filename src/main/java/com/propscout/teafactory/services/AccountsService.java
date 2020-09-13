package com.propscout.teafactory.services;

import com.propscout.teafactory.models.entities.Account;
import com.propscout.teafactory.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountsService {

    private final AccountRepository accountRepository;

    public AccountsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public boolean addAccount(Account account) {

        Optional<Account> optionalAccount = accountRepository.findByTransactionAccNo(account.getTransactionAccNo());

        if (optionalAccount.isPresent()) {
            return false;
        }

        accountRepository.save(account);

        return true;
    }

    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    public boolean updateAccount(Account account) {

        Optional<Account> optionalAccount = accountRepository.findById(account.getId());

        if (optionalAccount.isEmpty()) {
            return false;
        }

        accountRepository.save(account);

        return true;
    }
}
