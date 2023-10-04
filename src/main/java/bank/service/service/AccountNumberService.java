package bank.service.service;

import bank.service.repository.AccountNumberRepository;
import bank.service.model.AccountNumber;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class AccountNumberService implements Service<AccountNumber> {

    private final AccountNumberRepository repository;

    @Override
    public AccountNumber save(AccountNumber model) {
        return repository.save(model);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(AccountNumber model) {
        repository.save(model);
    }

    @Override
    public List<AccountNumber> findALL() {
        return repository.findAll();
    }

    @Override
    public Optional<AccountNumber> findById(int id) {
        return repository.findById(id);
    }
}
