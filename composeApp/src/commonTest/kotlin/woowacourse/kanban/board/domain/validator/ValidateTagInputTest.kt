package woowacourse.kanban.board.domain.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ValidateTagInputTest {

    @Test
    fun `쉼표 뒤 공백이 있어도 태그 형식은 정상이다`() {
        val result = validateTagInput("버그, 긴급")

        assertNull(result)
    }

    @Test
    fun `빈 태그가 포함되면 형식 오류를 반환한다`() {
        val result = validateTagInput("버그, ")

        assertEquals("태그 형식이 올바르지 않습니다.", result)
    }
}
