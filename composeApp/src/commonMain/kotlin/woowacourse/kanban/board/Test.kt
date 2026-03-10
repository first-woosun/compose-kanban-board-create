package woowacourse.kanban.board

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

data class Test(
    var foo: String
)

@Composable
fun TextFieldSample() {
    var value: Test by remember { mutableStateOf(Test("")) }
    TextField(
        value = value.foo, // TextField에 보여줄 텍스트 값
        onValueChange = { value.foo = value.copy(foo = it).foo }, // 사용자가 텍스트를 입력할 때마다, 변경된 새 텍스트를 전달
    )
}

@Preview
@Composable
private fun TextFieldPreview() {
    TextFieldSample()
}
