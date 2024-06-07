package com.cognito.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private TransactionType transactionType;
    private LocalDateTime creationDate;
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "accountId",nullable = false)
    private Account account;

    public Transaction(BigDecimal amount, LocalDateTime creationDate, Account account) {
        this.amount = amount;
        this.creationDate = creationDate;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", transactionType=" + transactionType +
                ", creationDate=" + creationDate +
                ", amount=" + amount +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && transactionType == that.transactionType && Objects.equals(creationDate, that.creationDate) && Objects.equals(amount, that.amount) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionType, creationDate, amount);
    }
}
