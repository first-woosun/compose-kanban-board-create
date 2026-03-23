package woowacourse.kanban.board.taskcard.domain

enum class State(
    val value: String
) {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
}
