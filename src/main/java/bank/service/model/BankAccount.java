package bank.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bank_account")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private int pin;

    @OneToOne
    @JoinColumn(name = "account_number_id")
    private AccountNumber accountNumber;
}
