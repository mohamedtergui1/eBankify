package org.example.ebankify.entity;

import jakarta.persistence.*;
import org.example.ebankify.enums.AccountStatus;

import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sender")
    List<Transaction> transactionssender;

    @OneToMany(mappedBy = "receiver")
    List<Transaction> transactionsreciver;

}