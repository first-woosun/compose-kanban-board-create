package woowacourse.kanban.board.util

object Text {
    const val LABEL_STATUS = "상태 *"
    const val LABEL_TITLE = "제목 *"
    const val LABEL_DESCRIPTION = "설명"
    const val LABEL_TAG = "태그"
    const val LABEL_ASSIGNEE = "담당자 *"

    const val HEADER_CREATE_TASK = "새 태스크 생성"

    const val PLACEHOLDER_TITLE = "태스크 제목을 입력하세요"
    const val PLACEHOLDER_DESCRIPTION = "태스크에 대한 자세한 설명을 입력하세요"
    const val PLACEHOLDER_TAG = "태그를 쉼표로 구분하여 입력하세요(예: 버그, 긴급)"

    const val ERROR_TITLE_EMPTY_INPUT = "제목을 입력해주세요"
    const val ERROR_TAG_FORMAT_INVALID = "태그 형식이 올바르지 않습니다."
    const val HELPER_TAG_LIMIT = "5자 이내의 태그를 최대 5개까지 등록할 수 있습니다."

    const val ACTION_CANCEL = "취소"
    const val ACTION_CREATE = "생성"
    const val ACTION_CLOSE = "닫기"

    const val CONTENT_USER_DEFAULT_IMAGE = "사용자 기본 이미지"
    const val CONTENT_ERROR = "error"

    const val CONDITION_TODO = "To Do"
    const val CONDITION_IN_PROGRESS = "In Progress"
    const val CONDITION_DONE = "Done"

    const val ERROR_TITLE_EMPTY = "[ERROR] 제목은 빈 값일 수 없습니다."
    const val ERROR_ASSIGNEE_EMPTY = "[ERROR] 담당자는 빈 값일 수 없습니다."
    const val ERROR_TAG_EMPTY = "[ERROR] 태그 텍스트는 빈 값일 수 없습니다."

    fun errorTagTooLong(maxLength: Int): String {
        return "[ERROR] 태그 텍스트는 ${maxLength}글자 이하여야 합니다."
    }

    fun errorTagCountExceeded(maxCount: Int): String {
        return "[ERROR] 태그 개수는 ${maxCount}개 이하여야합니다."
    }
}
