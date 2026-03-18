package woowacourse.kanban.board.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import woowacourse.kanban.board.domain.model.Card
import woowacourse.kanban.board.domain.model.User
import woowacourse.kanban.board.ui.card.KanbanCard

private class CardPreviewParameterProvider : PreviewParameterProvider<Card> {
    override val values = sequenceOf(
        Card(
            title = TITLE_EX,
            content = CONTENT_EX,
            tags = USER_GROUP_EX,
            user = User(name = NAME_EX),
        ),
        Card(
            title = TITLE_EX,
            tags = USER_GROUP_EX,
            user = User(name = NAME_EX),
        ),
        Card(
            title = TITLE_EX,
            content = CONTENT_EX,
            user = User(name = NAME_EX),
        ),
        Card(
            title = TITLE_EX,
            user = User(name = NAME_EX),
        ),
        Card(
            title = TITLE_MAX_EX,
            user = User(name = NAME_EX),
        ),
        Card(
            title = TITLE_EX,
            content = CONTENT_MAX_EX,
            tags = USER_GROUP_MAX_EX,
            user = User(name = NAME_MAX_EX),
        ),
    )
}

@Composable
@KanbanPreview
private fun KanbanCardPreview(@PreviewParameter(CardPreviewParameterProvider::class) card: Card) {
    KanbanCard(card)
}
