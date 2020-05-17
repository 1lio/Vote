package ru.vote.entity

class User(
    val id: Int,                        // Число в БД
    val fio: String,                    // Иванов Иван Иванович

    val login: String,                  // IvIvIch
    val pass: String,                   // В шифрованном виде
    val isAdmin: Boolean = false,       // Права на создание голосований

    val session: Int
) {

    // TODO: Оформить ввиде проперти

    val name: String = ""
    val family: String = ""
    val parentName: String = ""
}