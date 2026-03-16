package woowacourse.kanban.board.ui.taskForm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Condition
import woowacourse.kanban.board.util.ColorPalette
import woowacourse.kanban.board.util.Font
import woowacourse.kanban.board.util.Text as UiText

@Composable
fun ConditionInputSection() {
    Column {
        Text(
            text = UiText.LABEL_STATUS,
            fontSize = Font.FORMTITLE.size,
            fontWeight = Font.FORMTITLE.weight,
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
        )
        ConditionField()
    }
}

@Preview(showBackground = true)
@Composable
private fun ConditionInputPreview() {
    MaterialTheme {
        ConditionInputSection()
    }
}

@Composable
fun ConditionField() {
    var selectedCondition by remember { mutableStateOf(Condition.TODO) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Condition.entries.forEach {
            val borderColor = remember(selectedCondition) {
                if (selectedCondition == it) ColorPalette.ConditionSelectedBorder
                else ColorPalette.ConditionUnSelectedBorder
            }
            val backgroundColor = remember(selectedCondition) {
                if (selectedCondition == it) ColorPalette.ConditionSelectedBackground
                else ColorPalette.ConditionUnSelectedBackground
            }
            val textColor = remember(selectedCondition) {
                if (selectedCondition == it) ColorPalette.ConditionSelectedText
                else ColorPalette.ConditionUnselectedText
            }
            SelectionItem(
                modifier = Modifier.weight(1f),
                borderColor = borderColor,
                backgroundColor = backgroundColor,
                onClick = { selectedCondition = it },
                padding = 8.dp,
            ) {
                Text(
                    text = it.text,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = textColor,
                )
            }
        }
    }
}
