package bank.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account_number")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private int number;

    private int balance;

    public AccountNumber() {
    }

    public AccountNumber(int number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public AccountNumber(int id, int number, int balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }
}
