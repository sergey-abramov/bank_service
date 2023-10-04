package bank.service.repository;

import bank.service.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<BankAccount, Integer> {

    List<BankAccount> findAll();
}
