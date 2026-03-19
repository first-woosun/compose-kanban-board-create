package woowacourse.kanban.board.model

data class Title(
    val value: String
) {
    fun isNotValidTitle() = value.isBlank()
}