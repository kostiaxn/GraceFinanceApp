package com.example.gracefinance.model

import android.content.Context
import android.preference.PreferenceManager

class UserManager private constructor() {
    private val userList = mutableListOf<User>()

    companion object {
        @Volatile private var instance: UserManager? = null

        fun getInstance(): UserManager {
            return instance ?: synchronized(this) {
                instance ?: UserManager().also { instance = it }
            }
        }
    }


    fun addUser(user: User) {
        userList.add(user)
    }

    fun removeUser(user: User) {
        userList.remove(user)
    }

}