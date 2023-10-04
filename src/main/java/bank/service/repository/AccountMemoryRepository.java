package bank.service.repository;

import bank.service.model.BankAccount;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountMemoryRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final Map<Integer, BankAccount> repository = new ConcurrentHashMap<>();

    public Collection<BankAccount> findAll() {
        return repository.values();
    }

    public BankAccount save(BankAccount entity) {
        entity.setId(nextId.incrementAndGet());
        return repository.put(entity.getId(), entity);
    }

    public void update(BankAccount account) {
        repository.computeIfPresent(account.getId(),
                (id, oldAcc) -> new BankAccount(account.getId(),
                        account.getName(), account.getPin(), account.getAccountNumber()));
    }

    public Optional<BankAccount> findById(int id) {
        return Optional.ofNullable(repository.get(id));
    }

    public void deleteById(int id) {
        repository.remove(id);
    }
}
