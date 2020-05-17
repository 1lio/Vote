package ru.vote.extensions


// Возвращает строку в 24-часовом формате <00:00>
fun Int.timeFormat(): String {
    // Получим остаток от текущего значения
    val hour = if ((this / 60) > 24) (this / 60) - 24 else this / 60   // Часы
    val min = this % 60    // Минуты
    // Сформатируем строку
    val hh: String = if (hour < 10) "0$hour" else "$hour"
    val mm: String = if (min < 10) "0$min" else "$min"
    // Вернем отформатированную строку
    return "$hh:$mm"
}

// Остаток времени
fun Int.remainedTimeFormat(): String {
    // Получим остаток от текущего значения
    val hour = if ((this / 60) > 24) (this / 60) - 24 else this / 60   // Часы
    val min = this % 60    // Минуты
    // Сформатируем строку
    val hh: String = if (hour < 10) "0$hour" else "00"
    val mm: String = if (min < 10) "0$min" else "$min"
    // Вернем отформатированную строку
    return "$hh:$mm"
}
