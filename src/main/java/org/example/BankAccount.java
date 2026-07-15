package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class BankAccount { // Сам класс тоже стоит сделать final

    private final long id;
    private final String ownerName;
    private final BigDecimal balance; // В копейках для точности
    private final LocalDateTime createdAt;

    public BankAccount(long id, String ownerName, BigDecimal balance) {
        this.id = id;
        this.ownerName = Objects.requireNonNull(ownerName);
        this.balance = balance;
        this.createdAt = LocalDateTime.now(); // Фиксируем время создания
    }

    public long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        // Возвращаем копию, если бы это был Date, но LocalDateTime сам по себе immutable
        return createdAt;
    }

    // Вместо сеттера — метод, создающий новый объект
    public BankAccount withReplenishment(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        return new BankAccount(this.id, this.ownerName, this.balance.add(amount));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return id == that.id;
    }
}
