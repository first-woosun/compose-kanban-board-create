package woowacourse.kanban.board.unittest

import org.junit.Test
import woowacourse.kanban.board.model.Manager
import woowacourse.kanban.board.model.State
import woowacourse.kanban.board.model.TaskCardData
import kotlin.test.assertEquals

class TaskCardTable {
    val todoTable = mutableListOf<TaskCardData>()
    val inProgressTable = mutableListOf<TaskCardData>()
    val doneTable = mutableListOf<TaskCardData>()

    fun addCard(inputCard: TaskCardData) {
        when (inputCard.state){
            State.TODO -> todoTable.add(inputCard)
            State.IN_PROGRESS -> inProgressTable.add(inputCard)
            State.DONE -> doneTable.add(inputCard)
        }
    }

    fun getAllTaskCount() = todoTable.size + inProgressTable.size + doneTable.size

    fun getTodoTaskCount() = todoTable.size

    fun getInProgressTaskCount() = inProgressTable.size

    fun getDoneTaskCount() = doneTable.size

    fun getRatioOfDoneTask(): Int {
        val ratio = (doneTable.size.toDouble() / getAllTaskCount()) * HUNDRED

        return ratio.toInt()
    }
    companion object {
        const val HUNDRED = 100
    }
}

class TaskCardCollectionTest {
    @Test
    fun `TODO 상태 태스크가 입력되면 todoTable에 저장된다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title",
            description = "description",
            tags = listOf("tag1", "tag2"),
            state = State.TODO,
            manager = Manager.DINO
        ))

        assertEquals(1, taskCardTable.getTodoTaskCount())
        assertEquals(0, taskCardTable.getInProgressTaskCount())
        assertEquals(0, taskCardTable.getDoneTaskCount())
    }

    @Test
    fun `IN_PROGRESS 상태 태스크가 입력되면 inProgressTable에 저장된다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title",
            description = "description",
            tags = listOf("tag1", "tag2"),
            state = State.IN_PROGRESS,
            manager = Manager.DINO
        ))

        assertEquals(0, taskCardTable.getTodoTaskCount())
        assertEquals(1, taskCardTable.getInProgressTaskCount())
        assertEquals(0, taskCardTable.getDoneTaskCount())
    }

    @Test
    fun `DONE 상태 태스크가 입력되면 doneTable에 저장된다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title",
            description = "description",
            tags = listOf("tag1", "tag2"),
            state = State.DONE,
            manager = Manager.DINO
        ))

        assertEquals(0, taskCardTable.getTodoTaskCount())
        assertEquals(0, taskCardTable.getInProgressTaskCount())
        assertEquals(1, taskCardTable.getDoneTaskCount())
    }

    @Test
    fun `입력된 태스크의 전채 개수를 알 수 있다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title1",
            state = State.TODO,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title2",
            state = State.TODO,
            manager = Manager.FAMES
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title3",
            state = State.IN_PROGRESS,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title4",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title5",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title6",
            state = State.DONE,
            manager = Manager.DINO
        ))

        assertEquals(6, taskCardTable.getAllTaskCount())
    }

    @Test
    fun `여러 태스크 중 DONE 상태인 task의 개수를 알 수 있다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title1",
            state = State.TODO,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title2",
            state = State.TODO,
            manager = Manager.FAMES
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title3",
            state = State.IN_PROGRESS,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title4",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title5",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title6",
            state = State.DONE,
            manager = Manager.DINO
        ))

        assertEquals(3, taskCardTable.getDoneTaskCount())
    }

    @Test
    fun `입력 된 태스크의 완료율을 알 수 있다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title1",
            state = State.TODO,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title2",
            state = State.TODO,
            manager = Manager.FAMES
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title3",
            state = State.IN_PROGRESS,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title4",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title5",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title6",
            state = State.DONE,
            manager = Manager.DINO
        ))

        assertEquals(50, taskCardTable.getRatioOfDoneTask())
    }

    @Test
    fun `완료된 태스크가 없으면 완료율은 0이디 `() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title1",
            state = State.TODO,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title2",
            state = State.TODO,
            manager = Manager.FAMES
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title3",
            state = State.IN_PROGRESS,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title4",
            state = State.TODO,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title5",
            state = State.TODO,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title6",
            state = State.TODO,
            manager = Manager.DINO
        ))

        assertEquals(0, taskCardTable.getRatioOfDoneTask())
    }

    @Test
    fun `모든 태스크가 완료되면 완료율은 100이다`() {
        val taskCardTable = TaskCardTable()

        taskCardTable.addCard(TaskCardData(
            title = "title1",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title2",
            state = State.DONE,
            manager = Manager.FAMES
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title3",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title4",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title5",
            state = State.DONE,
            manager = Manager.DINO
        ))
        taskCardTable.addCard(TaskCardData(
            title = "title6",
            state = State.DONE,
            manager = Manager.DINO
        ))

        assertEquals(100, taskCardTable.getRatioOfDoneTask())
    }
}