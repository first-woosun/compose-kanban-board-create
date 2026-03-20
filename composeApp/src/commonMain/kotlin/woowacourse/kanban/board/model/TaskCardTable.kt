package woowacourse.kanban.board.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

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

    val ratioOfDoneFloat: Float get() = if (tasks.isEmpty()) 0f else (doneTaskCount / allTaskCount).toFloat()

    fun addCard(inputCard: TaskCardData) {
        tasks.add(inputCard)
    }
}