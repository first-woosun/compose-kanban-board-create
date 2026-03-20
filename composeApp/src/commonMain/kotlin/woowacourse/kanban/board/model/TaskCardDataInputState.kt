package woowacourse.kanban.board.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TaskCardDataInputState {
    var title by mutableStateOf("")
    val isNotValidTitle: Boolean
        get() = Title(title).isNotValidTitle()
    fun onTitleChange(value: String) {
        title = value
    }

    var description by mutableStateOf("")
    fun onDescriptionChange(value: String) {
        description = value
    }

    var tags by mutableStateOf("")
    val isNotValidTags: Boolean
        get() = Tags(tags).isNotValidTags()
    fun onTagsChange(value: String) {
        tags = value
    }

    var selectedState by mutableStateOf(State.TODO)
    fun onStateClick(value: State) {
        selectedState = value
    }

    var selectedManager by mutableStateOf(Manager.DINO)
    fun onManagerClick(value: Manager) {
        selectedManager = value
    }

    var showDialog by mutableStateOf(false)
    fun onShowDialogChange(value: Boolean) {
        showDialog = value
    }

    fun getCard(): TaskCardData {
        val newCard = TaskCardData(
            title = title,
            description = description,
            tags = Tags(tags).extractTags(),
            state = selectedState,
            manager = selectedManager
        )

        title = ""
        description = ""
        tags = ""
        selectedState = State.TODO
        selectedManager = Manager.DINO

        return newCard
    }
}