package woowacourse.kanban.board.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class UsernameTextFieldTest {

    @Test
    fun test1() = runComposeUiTest {
        // given: 이름 초깃값은 빈 문자열이다.
        var username by mutableStateOf("")
        setContent {
            UsernameTextField(username, { username = it })
        }
        // when: 사용자가 "김컴포즈"라는 문자열을 입력한다.
        username = "김컴포즈"
        // then: 에러 메세지가 보여져서는 안된다.
        onNodeWithTag("error").assertDoesNotExist()
    }

    @Test
    fun test2() = runComposeUiTest {
        // given: 이름 초깃값은 빈 문자열이다.
        var username by mutableStateOf("")
        // 검증하는 책임은 누구에게 있는가?
        setContent {
            UsernameTextField(username, { username = it })
        }
        // when: 사용자가 "김컴포즈입니다"라는 문자열을 입력한다.
        username = "김컴포즈입니다"
        // then: "이름은 2~5자여야 합니다"라는 에러 메세지가 노출된다.
        onNodeWithTag("error", useUnmergedTree = true).assertExists()
    }

}
