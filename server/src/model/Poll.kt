package server.model

// Опрос
data class Poll(
    val id: Int,
    val type: Int,
    val title: String,
    val subtitle: String,
    val answers: List<String>
)