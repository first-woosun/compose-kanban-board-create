package woowacourse.kanban.board.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UsernameTextField(username: String, onUsernameChange: (String) -> Unit) {
    val isError = username.length !in 2..5
    TextField(
        value = username,
        onValueChange = { onUsernameChange(it) },
        isError = isError,
        supportingText = {
            if (isError) {
                Text("이름은 2~5자여야 합니다", modifier = Modifier.Companion.testTag("error"))
            }
        },
    )
}

@Preview
@Composable
private fun UsernameTextFieldPreview() {
    UsernameTextField(username = "a", onUsernameChange = {})
}
