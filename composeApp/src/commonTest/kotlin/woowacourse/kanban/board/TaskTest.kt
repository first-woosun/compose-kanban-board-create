package woowacourse.kanban.board

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import kotlin.test.Test

class Task(
    val title: String,
    val description: String,
    val tags: List<String>,
    val status: String,
    val assignee: String,
) {
    init {
        require(title.isNotEmpty()) { "제목은 빈 문자열일 수 없습니다." }
        require(tags.size <= 5) { "태그는 5개까지만 생성 가능합니다." }
    }
}

class TaskTest {

    @Test
    fun `태스크는 제목, 설명, 태그, 상태, 담당자를 가진다`() {
        val task = Task(
            title = "TDD 수업하기",
            description = "오늘 배운 내용을 복습하고 다음 주제를 준비한다.",
            tags = listOf("공부", "TDD"),
            status = "TODO",
            assignee = "레아",
        )
        assertThat(task.title).isEqualTo("TDD 수업하기")
        assertThat(task.description).isEqualTo("오늘 배운 내용을 복습하고 다음 주제를 준비한다.")
        assertThat(task.tags).isEqualTo(listOf("공부", "TDD"))
        assertThat(task.status).isEqualTo("TODO")
        assertThat(task.assignee).isEqualTo("레아")
    }

    @Test
    fun `제목이 빈 문자열이면 태스크 생성이 불가능하다`() {
        assertThatThrownBy {
            val task = Task(
                title = "",
                description = "오늘 배운 내용을 복습하고 다음 주제를 준비한다.",
                tags = listOf("공부", "TDD"),
                status = "TODO",
                assignee = "레아",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `태그는 최대 5개까지 생성 가능하다`() {
        assertThatThrownBy {
            val task = Task(
                title = "TDD 수업하기",
                description = "오늘 배운 내용을 복습하고 다음 주제를 준비한다.",
                tags = listOf("공부", "TDD", "TDD1", "TDD2", "TDD3", "TDD4"),
                status = "TODO",
                assignee = "레아",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
