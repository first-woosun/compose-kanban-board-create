package woowacourse.kanban.board.model

import woowacourse.kanban.board.util.Text

object TaskCardValidators {
    fun validateTitle(text: String): Result<Title> {
        return if (text.isNotBlank()) {
            Result.success(Title(text))
        } else {
            Result.failure(IllegalArgumentException(Text.ERROR_TITLE_EMPTY))
        }
    }

    fun validateAssignee(name: String): Result<Assignee> {
        return if (name.isNotBlank()) {
            Result.success(Assignee(name))
        } else {
            Result.failure(IllegalArgumentException(Text.ERROR_ASSIGNEE_EMPTY))
        }
    }

    fun validateTag(text: String): Result<Tag> {
        return when {
            text.isBlank() -> Result.failure(IllegalArgumentException(Text.ERROR_TAG_EMPTY))
            text.length > Tag.MAXIMUM_TAG_LENGTH -> Result.failure(
                IllegalArgumentException(Text.errorTagTooLong(Tag.MAXIMUM_TAG_LENGTH)),
            )
            else -> Result.success(Tag(text))
        }
    }

    fun validateTagGroup(tags: List<Tag>): Result<TagGroup> {
        return if (tags.size <= TagGroup.MAXIMUM_TAG_COUNT) {
            Result.success(TagGroup(tags))
        } else {
            Result.failure(
                IllegalArgumentException(Text.errorTagCountExceeded(TagGroup.MAXIMUM_TAG_COUNT)),
            )
        }
    }
}
