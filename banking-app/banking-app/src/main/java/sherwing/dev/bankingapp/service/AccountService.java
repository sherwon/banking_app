package sherwing.dev.bankingapp.service;
import sherwing.dev.bankingapp.dto.AccountDto;

public interface AccountService {
    AccountDto creatAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);

    AccountDto deposite(long id, double amount);

    AccountDto widthDraw(Long id, double amount);
}
