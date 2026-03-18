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
import woowacourse.kanban.board.domain.model.Status

@OptIn(ExperimentalTestApi::class)
class StatusSelectorTest {

    @Test
    fun `상태를 변경하면 선택 UI가 함께 변경된다`() = runComposeUiTest {
        setContent {
            var selectedStatus by remember { mutableStateOf(Status.TODO) }

            StatusSelector(
                selectedStatus = selectedStatus,
                onStatusChange = { selectedStatus = it },
            )
        }

        onNodeWithText("To Do")
            .assertIsSelected()
        onNodeWithText("Done")
            .assertIsNotSelected()

        onNodeWithText("Done")
            .performClick()

        onNodeWithText("To Do")
            .assertIsNotSelected()
        onNodeWithText("Done")
            .assertIsSelected()
    }
}
