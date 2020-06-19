package server.model

data class Vote(
    val id: Int,
    val name: String,
    val beginTime: String,
    val finishTime: String,
    val listUsers: List<User>,
    val listVote: List<Poll>
)