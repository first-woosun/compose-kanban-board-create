package woowacourse.kanban.board.ui.create.maincontent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.component.Label
import woowacourse.kanban.board.ui.preview.KanbanPreview
import woowacourse.kanban.board.ui.theme.Gray
import woowacourse.kanban.board.ui.theme.Gray500
import woowacourse.kanban.board.ui.theme.Red

private const val TITLE_LABEL = "설명"
private const val TITLE_LABEL_PLACEHOLDER = "태스크에 대한 자세한 설명을 입력하세요"

@Composable
fun ContentArea(modifier: Modifier = Modifier, value: String, onContentChange: (String) -> Unit) {
    Column(
        modifier = modifier.fillMaxWidth(1f),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Label(TITLE_LABEL)
        OutlinedTextField(
            value = value,
            onValueChange = {
                onContentChange(it)
            },
            modifier = Modifier.fillMaxWidth(1f),
            placeholder = {
                Text(
                    text = TITLE_LABEL_PLACEHOLDER,
                    color = Gray,
                )
            },
            minLines = 6,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                unfocusedBorderColor = Gray500,
                errorBorderColor = Red,
            ),
        )
    }
}

@Composable
@KanbanPreview
private fun ContentPreview() {
    ContentArea(
        value = "",
        onContentChange = {},
    )
}
