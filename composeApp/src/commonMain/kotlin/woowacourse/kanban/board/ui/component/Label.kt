package woowacourse.kanban.board.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.preview.KanbanPreview
import woowacourse.kanban.board.ui.theme.Gray700

@Composable
fun Label(label: String, required: Boolean = false) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            color = Gray700,
        )
        if (required) {
            Text(
                text = "*",
                color = Gray700,
            )
        }
    }
}

@Composable
@KanbanPreview
private fun LabelPreview() {
    Label("로미", true)
}
