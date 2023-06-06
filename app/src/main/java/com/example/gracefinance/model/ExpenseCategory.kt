package com.example.gracefinance.model

class ExpenseCategory {
    private val categories: MutableList<String> = mutableListOf()

    fun addCategory(category: String) {
        if (!categories.contains(category)) {
            categories.add(category)
        }
    }

    fun getCategories(): List<String> {
        return categories.toList()
    }
}