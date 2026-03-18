package woowacourse.kanban.board.ui.card

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.domain.model.User
@OptIn(ExperimentalTestApi::class)
class CardUserProfileUiTest {

    @Test
    fun `유저가 null인 경우 - 알 수 없는 유저 노출`() = runComposeUiTest {
        setContent {
            CardUserProfile(
                null,
            )
        }

        onNodeWithText(UNKNOWN_USER).assertIsDisplayed()
    }

    @Test
    fun `전달된 유저 이름 표시`() = runComposeUiTest {
        val given = "다이노"
        setContent {
            CardUserProfile(
                User(given),
            )
        }

        onNodeWithText(given).assertIsDisplayed()
    }

    companion object {
        private const val UNKNOWN_USER = "알 수 없는 유저"
    }
}
