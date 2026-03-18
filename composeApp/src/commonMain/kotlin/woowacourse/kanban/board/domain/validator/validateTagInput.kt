package woowacourse.kanban.board.domain.validator

import woowacourse.kanban.board.domain.model.TagInput

fun validateTagInput(tag: String): String? {
    return TagInput(tag).formatTagInput()
}
