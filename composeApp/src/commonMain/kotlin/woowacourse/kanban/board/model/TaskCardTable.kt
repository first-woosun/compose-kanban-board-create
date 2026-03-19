package woowacourse.kanban.board.model

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