package woowacourse.kanban.board.ui.create

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import woowacourse.kanban.board.ui.preview.KanbanPreview

@Composable
fun KanbanCreateDialog(onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = onDismissRequest,
        content = {
            KanbanCreateDialogContent(
                onDismiss = onDismissRequest,
            )
        },
    )
}

@Composable
@KanbanPreview
private fun KanbanDialogPreview() {
    KanbanCreateDialog(
        onDismissRequest = {},
    )
}
