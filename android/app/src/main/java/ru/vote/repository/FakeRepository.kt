package ru.vote.repository

import ru.vote.entity.Vote

 class FakeRepository {

    private val vote: Vote = Vote(1, "Пленарное заседание от 25.04.2016", "15:00", "17:00", listOf(), listOf())
    private val vote1: Vote = Vote(2, "Комиссия 28.08.2016", "13:00", "18:00", listOf(), listOf())
    private val vote2: Vote = Vote(3, "Общий сболр 28.08.2016", "13:00", "18:00",listOf(), listOf())


    fun getVote(id: Int): Vote {
       return  when (id) {
           vote.id ->  vote
           vote1.id -> vote1
           vote2.id -> vote2
           else -> vote
       }
    }

}