package woowacourse.kanban.board.model

data class TaskCard(
    val title: String,
    val description: String = "",
    val condition: Condition,
    val tags: List<Tag> = emptyList(),
    val assignee: String,
)
