package sherwing.dev.bankingapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sherwing.dev.bankingapp.dto.AccountDto;
import sherwing.dev.bankingapp.service.AccountService;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
//injection
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.creatAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
       AccountDto accountDto = accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }
//Sting is a key and Double is a type value
    @PutMapping("/{id}/deposite")
    public ResponseEntity<AccountDto> deposite (@PathVariable  Long id, @RequestBody Map<String, Double> req) {
       double amount = req.get("amount");
        AccountDto accountDto = accountService.deposite(id, amount);
        return ResponseEntity.ok(accountDto);
    }
}

