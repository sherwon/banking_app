package sherwing.dev.bankingapp.service.impl;

import org.springframework.stereotype.Service;
import sherwing.dev.bankingapp.dto.AccountDto;
import sherwing.dev.bankingapp.entity.Account;
import sherwing.dev.bankingapp.mapper.AccountMapper;
import sherwing.dev.bankingapp.repository.AccountRepository;
import sherwing.dev.bankingapp.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

//service anotation automatically create springbean - manage object
@Service
public class AccountServiceImpl implements AccountService {
//    inject dependency
    private AccountRepository accountRepository;
//constructor base dependecy injection to inject accountRepository dependency
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto creatAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposite(long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto widthDraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient account balance");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account saveBalance = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveBalance);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public AccountDto delAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account does not exists"));
        accountRepository.deleteById(id);
        return AccountMapper.mapToAccountDto(account);
    }
}
