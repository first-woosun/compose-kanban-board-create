package woowacourse.kanban.board.ui.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ui.preview.KanbanPreview

const val HEAD_TEXT = "새 태스크 생성"

@Composable
fun KanbanCreateHeader(modifier: Modifier = Modifier, onDismiss: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(1f)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = HEAD_TEXT,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        IconButton(
            onClick = onDismiss,
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "테스크 종료",
            )
        }
    }
}

@Composable
@KanbanPreview
private fun HeaderPreview() {
    KanbanCreateHeader(
        onDismiss = {},
    )
}
