package ru.vote.entity

class Question(
    var type: Int,
    var title: String,
    var subtitle: String = "",
    var listAnswers: MutableList<String>
)