package bank.service.service;

import bank.service.model.AccountNumber;
import bank.service.model.BankAccount;
import bank.service.repository.AccountRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class AccountService implements Service<BankAccount> {

    private final AccountRepository repository;
    private final AccountNumberService accountNumberService;

    @Override
    public BankAccount save(BankAccount model) {
        Random random = new Random();
        accountNumberService.save(new AccountNumber(random.nextInt(), 0));
        return repository.save(model);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(BankAccount model) {
        accountNumberService.save(model.getAccountNumber());
        repository.save(model);
    }

    @Override
    public List<BankAccount> findALL() {
        return repository.findAll();
    }

    @Override
    public Optional<BankAccount> findById(int id) {
        return repository.findById(id);
    }
}
