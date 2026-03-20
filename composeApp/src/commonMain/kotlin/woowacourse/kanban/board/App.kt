package woowacourse.kanban.board

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import woowacourse.kanban.board.component.createtaskcard.TaskCardDataInput
import woowacourse.kanban.board.component.kanbanboard.KanbanBoard
import woowacourse.kanban.board.model.TaskCardDataInputState
import woowacourse.kanban.board.model.TaskCardTable

@Composable
fun App() {
    val state = remember { TaskCardDataInputState() }
    val taskCardTable = remember { TaskCardTable() }

    KanbanBoard(
        state,
        taskCardTable
    )
}
