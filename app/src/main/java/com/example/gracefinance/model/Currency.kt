package com.example.gracefinance.model

class Currency(
    val currencyCode: String
) {
    companion object {
        private val currencies: MutableSet<Currency> = mutableSetOf()

        fun getInstance(currencyCode: String): Currency {
            val currency = Currency(currencyCode)
            currencies.add(currency)
            return currency
        }

        fun getCurrencies(): Set<Currency> {
            return currencies.toSet()
        }

        fun addCurrency(currency: Currency) {
            currencies.add(currency)
        }

        fun removeCurrency(currency: Currency) {
            currencies.remove(currency)
        }
    }

    override fun toString(): String {
        return currencyCode
    }
}