package com.example.gracefinance.model

data class Card(
    val cardName: String,
    val cardCurrency: Currency,
    var cardBalance: Double
) {
    private val transactions: MutableList<Transaction> = mutableListOf()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun getTransactions(): List<Transaction> {
        return transactions.toList()
    }

    fun updateBalance(amount: Double) {
        cardBalance += amount
    }
}