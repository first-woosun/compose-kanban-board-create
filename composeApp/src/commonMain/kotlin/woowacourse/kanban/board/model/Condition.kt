package woowacourse.kanban.board.model

import woowacourse.kanban.board.util.Text

enum class Condition(val text: String) {
    TODO(Text.CONDITION_TODO),
    INPROGRESS(Text.CONDITION_IN_PROGRESS),
    DONE(Text.CONDITION_DONE),
}
