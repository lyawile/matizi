package tz.go.necta.widgettest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tz.go.necta.widgettest.components.DriverOrder
import tz.go.necta.widgettest.components.SearchBar
import tz.go.necta.widgettest.ui.theme.WidgetTestTheme
import tz.go.necta.widgettest.components.ServiceSummaryBox

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WidgetTestTheme {
                // A surface container using the 'background' color from the theme
//                SearchBar()

                var text by remember { mutableStateOf("") }

                PlainTextField(
                    value = text,
                    onValueChange = {
                        text = it
                    }
                )
            }
        }
    }


    @Composable
    fun PlainTextField(value: String, onValueChange: (String) -> Unit) {
        var togglePlaceholder by remember { mutableStateOf(true) }
        Card(shape = RoundedCornerShape(60), modifier = Modifier) {
            Box() {
                BasicTextField(
                    value = value,
                    textStyle = TextStyle(
                        fontSize = 24.sp
                    ),
                    onValueChange = { newText ->
                        onValueChange(newText)
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    interactionSource = remember { MutableInteractionSource() }
                        .also { interactionSource ->
                            LaunchedEffect(interactionSource) {
                                interactionSource.interactions.collect {
                                    if (it is PressInteraction.Release) {
                                        togglePlaceholder = value.isNotEmpty()
                                    }
                                }
                            }
                        }
//                .border(1.dp, Color.Gray), // Add a border if desired
                )
                if (togglePlaceholder) {
                    Box(modifier = Modifier.padding(top = 20.dp, start = 16.dp)) {
                        Text("Search service")
                    }
                }

            }

        }

    }
}



