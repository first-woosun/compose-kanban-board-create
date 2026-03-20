package woowacourse.kanban.board.component.taskboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.junit.Test
import woowacourse.kanban.board.model.Manager
import woowacourse.kanban.board.model.State
import woowacourse.kanban.board.model.TaskCardData
import woowacourse.kanban.board.unittest.TaskCardTable

@Composable
fun TaskBoard(taskState: State, taskCards: List<TaskCardData>){
    Box(
        modifier = Modifier
            .width(320.dp)
            .fillMaxHeight()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier.align(alignment = Alignment.Start)
            ) {
                Text(
                    text = taskState.value
                )
            }
        }
    }
}


class TaskBoardTest {
    @Test
    fun `입력된 태스크의 카드가 보드에 표시된다`() {

    }

    @Test
    fun `태스크의 개수가 보드 상단에 표시된다`() {

    }

    @Test
    fun `입력된 모든 태스크는 스크롤을 통해 표시 되어야 한다`() {

    }

    companion object {
        private val mock = List<TaskCardData>(10000) { TaskCardData(title = "${it}", state = State.TODO, manager = Manager.DINO) }
    }
}