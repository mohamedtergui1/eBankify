package org.example.ebankify.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.enums.AccountStatus;

import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double balance;
    @Column(name = "account_number",unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sender" )
    private List<Transaction> transactionssender;

    @OneToMany(mappedBy = "receiver")
    private List<Transaction> transactionsreciver;

}