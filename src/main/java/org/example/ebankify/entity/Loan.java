package org.example.ebankify.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.ebankify.enums.LoanStatus;
@Entity
@Table(name = "loans")
@Getter
@Setter
public class Loan {
    @Id
    private Long id;

    @Column(nullable = false)
    private Double principal;

    @Column(nullable = false, name = "interest_rate")
    private Double interestRate;

    @Column(nullable = false , name = "term_months")
    private int termMonths;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean approved;
}
