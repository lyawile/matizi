package tz.go.necta.widgettest.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    Card(shape = RoundedCornerShape(60)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.fillMaxWidth().weight(0.9f)
            ) {
                Box {
                    SearchTextField(onValueChange = {
                    })
                    Text("Search services", modifier = Modifier.padding(top = 21.dp, start = 51.dp))
                }
            }
            Box(Modifier.weight(0.1f)){
                Box(
                    modifier = Modifier
                        .border(2.dp, Color.Black, shape = CircleShape,
                        ),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "user icon",
                    )
                }
            }
        }
    }
}