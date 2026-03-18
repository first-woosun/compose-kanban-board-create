package woowacourse.kanban.board.ui.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ui.theme.Gray600

private const val CONTENT_MAX_LINE = 2

@Composable
fun CardContent(content: String) {
    Text(
        text = content,
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        color = Gray600,
        maxLines = CONTENT_MAX_LINE,
        overflow = TextOverflow.Ellipsis,
    )
}
