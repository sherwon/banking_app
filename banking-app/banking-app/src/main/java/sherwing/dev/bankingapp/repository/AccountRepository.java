package sherwing.dev.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sherwing.dev.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
