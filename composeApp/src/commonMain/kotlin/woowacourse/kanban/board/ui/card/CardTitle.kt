package woowacourse.kanban.board.ui.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.ui.theme.Gray900

private const val DEFAULT_TITLE = "제목 없음"
private const val TITLE_MAX_LINE = 1

@Composable
fun CardTitle(title: String?) {
    Text(
        text = if (title.isNullOrBlank()) DEFAULT_TITLE else title,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        color = Gray900,
        maxLines = TITLE_MAX_LINE,
        overflow = TextOverflow.Ellipsis,
    )
}
