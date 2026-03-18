package woowacourse.kanban.board.ui.create.maincontent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.ui.component.Label
import woowacourse.kanban.board.ui.component.SingleLineTextField
import woowacourse.kanban.board.ui.preview.KanbanPreview

private const val CONTENT_LABEL = "태그"
private const val TAG_LABEL_PLACEHOLDER = "태그를 쉼표로 구분하여 입력하세요 (예: 버그,긴급)"
private const val TAG_LABEL_SUPPORTING = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."

@Composable
fun TagArea(
    modifier: Modifier = Modifier,
    value: String,
    onTagChange: (String) -> Unit,
    errorMessage: String? = null,
    isError: Boolean = false,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Label(CONTENT_LABEL)
        SingleLineTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { onTagChange(it) },
            isError = isError,
            errorMessage = errorMessage,
            placeHolderMessage = TAG_LABEL_PLACEHOLDER,
            supportingText = TAG_LABEL_SUPPORTING,
        )
    }
}

@Composable
@KanbanPreview
private fun TagPreview() {
    TagArea(
        value = "",
        onTagChange = {},
        isError = false,
        errorMessage = null,
    )
}
