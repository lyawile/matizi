package tz.go.necta.widgettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tz.go.necta.widgettest.ui.theme.WidgetTestTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WidgetTestTheme {
                // A surface container using the 'background' color from the theme

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize().padding(32.dp)
                        .background(Color.Blue)
                ) {
                    TFSDropDownMenu(label = "Select Gender", mutableListOf("Male", "Female"))
                    Spacer(modifier = Modifier.height(16.dp))
                    TFSDropDownMenu(label = "Select Category", mutableListOf("Client", "Technician"))
                }

            }
        }
    }
}

@Composable
private fun TextFieldForSpinner(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder",
    fontSize: TextUnit = MaterialTheme.typography.bodySmall.fontSize,
    isPassword: Boolean = false,
    selectedOption: MutableState<String>

) {
    var text by selectedOption
    BasicTextField(
        modifier = modifier
            .background(
                Color.Blue,
                MaterialTheme.shapes.small,
            ),
        value = text,
        readOnly = true,
        onValueChange = {
            text = it
        },
        singleLine = true,
//        cursorBrush = SolidColor(MaterialTheme.colors.primary),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = fontSize
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.background(
                    Color.White,
                    RoundedCornerShape(percent = 60)
                ).padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f).padding(start = 8.dp)) {
                    if (text.isEmpty()) Text(
                        placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            fontSize = fontSize
                        )
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TFSDropDownMenu(label:String, list: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth().background(Color.Blue)) {
        val stateList by remember { mutableStateOf(list) }
        val selectedOption = remember { mutableStateOf("") }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextFieldForSpinner(
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        null,
                        tint = LocalContentColor.current.copy(alpha = 0.3f)
                    )
                },
                trailingIcon = null,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        RoundedCornerShape(percent = 50)
                    )
                    .height(48.dp),
                fontSize = 16.sp,
                placeholderText = label,
                selectedOption = selectedOption
            )
            
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                ) {
                    stateList.forEach { selectedText ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOption.value = selectedText
                                expanded = false
                            },
                            text = {
                                Text(text = selectedText)
                            },
                        )
                    }
                }
        }
        val interactionSource = MutableInteractionSource()
        Spacer(modifier = Modifier.matchParentSize().background(Color.Transparent).clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            expanded = !expanded
        })
    }
}





