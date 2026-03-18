package woowacourse.kanban.board.ui.create.maincontent

import woowacourse.kanban.board.domain.model.Status

private const val TODO_TEXT = "To Do"
private const val IN_PROGRESS_TEXT = "In Progress"
private const val DONE_TEXT = "Done"

fun Status.toDisplayText(): String {
    return when (this) {
        Status.TODO -> TODO_TEXT
        Status.IN_PROGRESS -> IN_PROGRESS_TEXT
        Status.DONE -> DONE_TEXT
    }
}
