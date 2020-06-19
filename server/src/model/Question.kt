package server.model

class Question(
    var type: Int,
    var title: String,
    var subtitle: String = "",
    var listAnswers: MutableList<String>
)