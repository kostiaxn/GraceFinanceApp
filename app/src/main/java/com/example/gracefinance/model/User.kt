package com.example.gracefinance.model

data class User(
    val userId: Int,
    val userName: String,
    val userCards: MutableList<Card> = mutableListOf(),
    val balances: MutableMap<Currency, Double> = mutableMapOf()
) {
    fun addAccount(account: Card) {
        userCards.add(account)
    }

    fun removeAccount(account: Card) {
        userCards.remove(account)
    }

    fun getBalance(currency: Currency): Double {
        return balances[currency] ?: 0.0
    }

    fun updateBalance(currency: Currency, amount: Double) {
        balances[currency] = getBalance(currency) + amount
    }
}