package com.example.gracefinance.model

import java.time.LocalDate
import java.time.LocalTime

open class Transaction(
    val amount: Double,
    val date: LocalDate,
    val time: LocalTime,
    val type: TransactionType,
    val card: Card
)

class ExpenseTransaction(
    amount: Double,
    date: LocalDate,
    time: LocalTime,
    card: Card,
    val category: ExpenseCategory
) : Transaction(amount, date, time, TransactionType.EXPENSE, card) {
    init {
        card.updateBalance(-amount)
    }
}

class IncomeTransaction(
    amount: Double,
    date: LocalDate,
    time: LocalTime,
    card: Card,
    val source: String
) : Transaction(amount, date, time, TransactionType.INCOME, card) {
    init {
        card.updateBalance(amount)
    }
}
class TransferTransaction(
    amount: Double,
    date: LocalDate,
    time: LocalTime,
    senderCard: Card,
    recipientCard: Card
) : Transaction(amount, date, time, TransactionType.TRANSFER, senderCard) {
    init {
        senderCard.updateBalance(-amount)
        recipientCard.updateBalance(amount)
    }
}

class DebtTransaction(
    amount: Double,
    date: LocalDate,
    time: LocalTime,
    debtorUser: User,
    creditorUser: User
) : Transaction(amount, date, time, TransactionType.DEBT, debtorUser.userCards[0]) {
    val debtorUser: User = debtorUser
    val creditorUser: User = creditorUser
}

class SavingsTransaction(
    amount: Double,
    date: LocalDate,
    time: LocalTime,
    card: Card,
    val description: String
) : Transaction(amount, date, time, TransactionType.SAVINGS, card)