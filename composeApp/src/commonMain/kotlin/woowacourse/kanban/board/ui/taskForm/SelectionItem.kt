package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SelectionItem(
    modifier: Modifier = Modifier,
    borderColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    padding: Dp = 8.dp,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(10.dp),
            )
            .background(
                color = backgroundColor,
            )
            .clickable(onClick = onClick)
            .padding(padding),
        content = content,
    )
}
