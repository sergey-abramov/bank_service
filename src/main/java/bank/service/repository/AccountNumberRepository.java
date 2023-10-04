package bank.service.repository;

import bank.service.model.AccountNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountNumberRepository extends CrudRepository<AccountNumber, Integer> {

    List<AccountNumber> findAll();
}
