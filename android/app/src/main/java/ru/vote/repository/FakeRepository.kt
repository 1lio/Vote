package ru.vote.repository

import ru.vote.entity.Poll
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

     private val question1 = Poll(1212,1,
         "1 main klein soldaten",
         "1  ghjjkhbgvfcxdczsszdcxfg hhc ghfc ghfjc gvh",
         arrayListOf("1", "2","3")
     )
     private val question2 = Poll(13,2,
         "2d main fgrehery2w345klein soldaten",
         "2222",
         arrayListOf("4", "5","хуй", "7")
     )
     private val question3 = Poll(12,14,
         "3g3 main ky45tyyewywlein soldaten",
         "333",
         arrayListOf("yes", "no")
     )
     private val question4 = Poll(16,2,
         "dfg33 maidfgdn ky45tyyewywlein soldaten",
         "333",
         arrayListOf("yes", "no", "bh")
     )
     private val question5 = Poll(9,1,
         "33 maigghgfhffdvdein soldaten",
         "333",
         arrayListOf("213", "1231", "b12412tfdvfch")
     )

     fun getQuestions() = arrayListOf(question1, question2, question3, question4, question5)
}