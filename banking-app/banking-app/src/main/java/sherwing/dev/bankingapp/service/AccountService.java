package sherwing.dev.bankingapp.service;
import sherwing.dev.bankingapp.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto creatAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);

    AccountDto deposite(long id, double amount);

    AccountDto widthDraw(Long id, double amount);

    List<AccountDto> getAllAccount();

    AccountDto delAccount(Long id);
}
