package woowacourse.kanban.board.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.forEach
import woowacourse.kanban.board.domain.model.Tag
import woowacourse.kanban.board.ui.preview.KanbanPreview
import woowacourse.kanban.board.ui.theme.Gray100
import woowacourse.kanban.board.ui.theme.Gray700

@Composable
fun CardTags(tags: List<Tag>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.forEach { tag ->
            Chip(content = tag.content)
        }
    }
}

@Composable
private fun Chip(modifier: Modifier = Modifier, content: String, textColor: Color = Gray700, backgroundColor: Color = Gray100) {
    Text(
        text = content,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        color = textColor,
        modifier = modifier
            .clip(shape = RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 4.dp),
    )
}

@Composable
@KanbanPreview
fun ChipPreview() {
    Chip(content = "칩입니다")
}
