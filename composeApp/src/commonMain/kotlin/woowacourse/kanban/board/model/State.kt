package woowacourse.kanban.board.model

enum class State(
    val value: String
) {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
}