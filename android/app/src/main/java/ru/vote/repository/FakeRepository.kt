package ru.vote.repository

import ru.vote.entity.Question
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

     private val question1 = Question(1,
         "1 main klein soldaten",
         "1  ghjjkhbgvfcxdczsszdcxfg hhc ghfc ghfjc gvh",
         arrayListOf("1", "2","3")
     )
     private val question2 = Question(1,
         "2 main fgrehery2w345klein soldaten",
         "2222",
         arrayListOf("4", "5","6", "7")
     )
     private val question3 = Question(1,
         "33 main ky45tyyewywlein soldaten",
         "333",
         arrayListOf("8", "9","10", "11")
     )

     fun getQuestions() = arrayListOf<Question>(question1, question2, question3)
}