package ru.vote.entity

// Опрос
data class Poll(
    val id: Int,
    val title: String,
    val subtitle: String,
    val answers: List<String>
)