package woowacourse.kanban.board.ui.create.maincontent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class TagTextFieldTest {

    @Test
    fun `에러 상태가 주어지면 에러 문구가 표시된다`() = runComposeUiTest {
        setContent {
            TagArea(
                value = "버그,",
                onTagChange = {},
                errorMessage = "태그 형식이 올바르지 않습니다.",
                isError = true,
            )
        }

        onNodeWithText("태그 형식이 올바르지 않습니다.", useUnmergedTree = true)
            .assertExists()
    }

    @Test
    fun `정상 상태가 주어지면 안내 문구가 표시된다`() = runComposeUiTest {
        setContent {
            TagArea(
                value = "버그, 긴급",
                onTagChange = {},
                errorMessage = null,
                isError = false,
            )
        }

        onNodeWithText("5자 이내의 태그를 최대 5개까지 등록할 수 있습니다.", useUnmergedTree = true)
            .assertExists()
    }

    @Test
    fun `입력값은 onTagChange로 전달된다`() = runComposeUiTest {
        var latestInput = ""

        setContent {
            var tagText by remember { mutableStateOf("") }

            TagArea(
                value = tagText,
                onTagChange = {
                    tagText = it
                    latestInput = it
                },
                errorMessage = null,
                isError = false,
            )
        }

        onAllNodes(hasSetTextAction())[0].performTextInput("버그, 긴급")

        assertEquals("버그, 긴급", latestInput)
    }
}
