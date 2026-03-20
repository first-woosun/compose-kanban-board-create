package woowacourse.kanban.board.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class TaskCardDataInputState {

    var title = ""

    val isNotValidTitle = Title(title).isNotValidTitle()

//    fun onTitleChange(value: String) {
//        title = value
//    }

    var description = ""

//    fun onDescriptionChange(value: String) {
//        description = value
//    }

    var tags = ""

    val isNotValidTags = Tags(tags).isNotValidTags()

//    fun onTagsChange(value: String) {
//        tags = value
//    }

    var selectedState = State.TODO

//    fun onStateClick(value: State) {
//        selectedState = value
//    }

    var selectedManager = Manager.DINO

//    fun onManagerClick(value: Manager) {
//        selectedManager = value
//    }
}