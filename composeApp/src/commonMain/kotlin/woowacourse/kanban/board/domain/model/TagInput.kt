package woowacourse.kanban.board.domain.model

import woowacourse.kanban.board.domain.model.Tags.Companion.fromContents

private const val TAG_FORMAT_MESSAGE = "태그 형식이 올바르지 않습니다."
private const val TAG_LIMIT_MESSAGE = "태그는 5자 이내로 5개까지만 등록할 수 있습니다"

data class TagInput(private val tag: String) {
    fun formatTagInput(): String? {
        val contents = tag.split(",").map { it.trim() }

        return when {
            contents.any { it.isBlank() } -> TAG_FORMAT_MESSAGE
            fromContents(contents) -> TAG_LIMIT_MESSAGE
            else -> null
        }
    }
}

