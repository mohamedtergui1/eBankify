package org.example.ebankify.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class Invoice {

    @Id
    private Long id;

    @Column(name = "amount_due")
    private Double amountDue;

    @Column(name = "due_date")
    private Date dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
