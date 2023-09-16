package tz.go.necta.widgettest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Pill() {
    Box(
        modifier = Modifier
            .background(Color.LightGray, RoundedCornerShape(50))
    ) {
        Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text = "Contents will go here for the test in order to" +
                        " check if things are running",
                modifier = Modifier.weight(0.9F)
            )
            Icon(
                imageVector = Icons.Filled.Close, contentDescription = "Delete Item",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWidget() {
    Pill()
}