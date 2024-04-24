package sherwing.dev.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//anotate with lombok data, to automatically create constructor setter getter method
@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;


}
