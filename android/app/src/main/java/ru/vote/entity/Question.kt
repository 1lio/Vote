package ru.vote.entity

class Question(
    var type: Int,
    var title: String,
    var question: String = "",
    var answeres: MutableList<String>
)