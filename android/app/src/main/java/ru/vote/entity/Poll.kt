package ru.vote.entity

// Это биллютень
class Poll(
    val id: Int,
    var type: Int,
    var title: String,
    var subtitle: String = "",
    var listAnswers: MutableList<String>
)