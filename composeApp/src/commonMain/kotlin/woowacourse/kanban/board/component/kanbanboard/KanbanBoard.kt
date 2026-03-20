package woowacourse.kanban.board.component.kanbanboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.CoroutineScope
import woowacourse.kanban.board.component.createtaskcard.ActionButton
import woowacourse.kanban.board.component.createtaskcard.TaskCardDataInput
import woowacourse.kanban.board.constant.ColorPalette
import woowacourse.kanban.board.model.State
import woowacourse.kanban.board.model.TaskCardDataInputState
import woowacourse.kanban.board.model.TaskCardTable

@Composable
fun KanbanBoard(
    taskCardDataInputState: TaskCardDataInputState,
    taskCardTable: TaskCardTable,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorPalette.KANBAN_BOARD_BACKGROUND)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 24.dp, top = 16.dp, bottom = 16.dp, end = 24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text(
                        text = "Compose Desktop 칸반 보드",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "완료율 : ${taskCardTable.ratioOfDoneInt}% (${taskCardTable.doneTaskCount}/${taskCardTable.allTaskCount}) "
                    )
                }
                ActionButton(
                    containerColor = ColorPalette.TASK_ADD_BUTTON,
                    text = "+새 태스크 생성",
                    onClick = { taskCardDataInputState.onShowDialogChange(true) }
                )
                if(taskCardDataInputState.showDialog){
                    Dialog(
                        onDismissRequest = { taskCardDataInputState.onShowDialogChange(false) },
                        properties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        TaskCardDataInput(
                            state = taskCardDataInputState,
                            onCreate = {
                                taskCardTable.addCard(it)
                            },
                        )
                    }
                }
            }
            LinearProgressIndicator(
                progress = { taskCardTable.ratioOfDoneFloat },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                trackColor = Color(0xFFE5E7EB),
                color = Color(0xFF4F39F6)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFFF9FAFB))
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TaskBoard(State.TODO, taskCardTable.todoTable)
            TaskBoard(State.IN_PROGRESS, taskCardTable.inProgressTable)
            TaskBoard(State.DONE, taskCardTable.doneTable)
        }
    }
}

@Preview(widthDp = 1200, heightDp = 900, showBackground = true)
@Composable
fun KanbanBoardPreview() {
    val state = remember { TaskCardDataInputState() }
    val taskCardTable = remember { TaskCardTable() }
    KanbanBoard(
        state,
        taskCardTable
    )
}