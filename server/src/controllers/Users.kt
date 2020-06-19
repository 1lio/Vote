package server.controllers

import server.model.User

interface Users {

    // CRUD

    fun createUser()

    fun updateUser(users: User)

    fun getUser(id: String): User

    fun deleteUser(id: String)

    fun getAllUsers(): ArrayList<String>


    // Passwords

    fun resetUserPass(id: String)

    fun resetAllUsersPass()
}