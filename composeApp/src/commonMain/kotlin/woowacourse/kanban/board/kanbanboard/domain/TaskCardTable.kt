package woowacourse.kanban.board.kanbanboard.domain

import androidx.compose.runtime.mutableStateListOf
import woowacourse.kanban.board.taskcard.domain.State
import woowacourse.kanban.board.taskcard.domain.TaskCardData

class TaskCardTable {
    private val tasks = mutableStateListOf<TaskCardData>()

    val todoTable: List<TaskCardData> get() = tasks.filter { it.state == State.TODO }
    val inProgressTable: List<TaskCardData> get() = tasks.filter { it.state == State.IN_PROGRESS }
    val doneTable: List<TaskCardData> get() = tasks.filter { it.state == State.DONE }

    val allTaskCount: Int get() = tasks.size

    val todoTaskCount:Int get() = todoTable.size

    val inProgressTaskCount: Int get() = inProgressTable.size

    val doneTaskCount: Int get() = doneTable.size

    val ratioOfDoneInt: Int get() = if (tasks.isEmpty()) 0 else (doneTaskCount * 100) / allTaskCount

    val ratioOfDoneFloat: Float get() = if (tasks.isEmpty()) 0f else (doneTaskCount.toFloat() / allTaskCount.toFloat())

    fun addCard(inputCard: TaskCardData) {
        tasks.add(inputCard)
    }
}
