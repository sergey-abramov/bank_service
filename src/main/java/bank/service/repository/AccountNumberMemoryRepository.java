package bank.service.repository;

import bank.service.model.AccountNumber;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountNumberMemoryRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final Map<Integer, AccountNumber> repository = new ConcurrentHashMap<>();

    public AccountNumber save(AccountNumber accountNumber) {
        accountNumber.setId(nextId.incrementAndGet());
        return repository.put(accountNumber.getId(), accountNumber);
    }

    public void update(AccountNumber accountNumber) {
        repository.computeIfPresent(accountNumber.getId(),
                (id, oldAccountNumber) -> new AccountNumber(accountNumber.getId(),
                        accountNumber.getNumber(), accountNumber.getBalance()));
    }

    public Optional<AccountNumber> findById(int id) {
        return Optional.ofNullable(repository.get(id));
    }

    public Collection<AccountNumber> findAll() {
        return repository.values();
    }

    public void deleteById(int id) {
        repository.remove(id);
    }
}
