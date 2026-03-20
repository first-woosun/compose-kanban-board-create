package woowacourse.kanban.board.model

data class TaskCardData(
    val title: String,
    val description: String? = null,
    val tags: List<String>? = null,
    var state: State,
    val manager: Manager
)
