package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DescriptionTest {
    private val validText = "이건 설명 텍스트입니다."
    private val emptyText = ""
    private val blankText = " "

    @Test
    fun `텍스트로 Description 객체를 생성할 수 있다`() {
        val description = createDescription(validText)
        assertEquals(validText, description.text)
    }

    @Test
    fun `빈 공란으로도 isBlank()가 true가 된다`() {
        val description = createDescription(emptyText)
        assertTrue(description.isBlank())
    }

    @Test
    fun `공백만 있을 경우 isBlank()가 true가 된다`() {
        val description = createDescription(blankText)
        assertTrue(description.isBlank())
    }

    private fun createDescription(text: String): Description {
        return Description(text)
    }
}
