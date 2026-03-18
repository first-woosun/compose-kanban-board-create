package woowacourse.kanban.board.ui.create.maincontent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.domain.model.User

@OptIn(ExperimentalTestApi::class)
class ManagerSelectorTest {

    @Test
    fun `담당자를 변경하면 선택 UI가 함께 변경된다`() = runComposeUiTest {
        val users = listOf(
            User("디노"),
            User("제임스"),
        )

        setContent {
            var selectedUser by remember { mutableStateOf(users.first()) }

            ManagerSelector(
                managers = users,
                selectedUser = selectedUser,
                onUserChange = { selectedUser = it },
            )
        }

        onNodeWithText("디노")
            .assertIsSelected()
        onNodeWithText("제임스")
            .assertIsNotSelected()

        onNodeWithText("제임스")
            .performClick()

        onNodeWithText("디노")
            .assertIsNotSelected()
        onNodeWithText("제임스")
            .assertIsSelected()
    }
}
