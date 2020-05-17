package ru.vote.ui.message

object MessageType {

    const val CHECK_VOTE = 0    // Проверка аутентификации
    const val OK_VOTE = 1       // Проверка получение события
    const val TIME_VOTE = 2     // Событие через определённое время
    const val NOT_VOTE = 3      // Нет событий
    const val DONE_VOTE = 4     // Пропущенно событие
    const val PLANE_VOTE = 5    // Запланированно заседание
}