package org.example.ebankify.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.enums.TransactionStatus;
import org.example.ebankify.enums.TransactionType;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "sender_id")
    private Account sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "receiver_id")
    private Account receiver;

}