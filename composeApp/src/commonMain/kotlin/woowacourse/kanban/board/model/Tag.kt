package woowacourse.kanban.board.model

data class Tag(val text: String) {
    companion object {
        const val MAXIMUM_TAG_LENGTH = 5
    }
}
