package woowacourse.kanban.board.domain.model

import woowacourse.kanban.board.domain.model.Card.Companion.MAX_TAG_SIZE
import woowacourse.kanban.board.domain.model.Tag.Companion.MAX_TAG_LENGTH

data class Tags (private val value: List<Tag>) {
    init {
        require(value.size <= MAX_TAG_SIZE) { "태그는 최대 $MAX_TAG_SIZE 개까지 입력 가능합니다." }
    }

    companion object {
        fun fromContents(tags: List<String>): Boolean {
            return tags.size > MAX_TAG_SIZE || tags.any { it.length > MAX_TAG_LENGTH }
        }
    }
}
