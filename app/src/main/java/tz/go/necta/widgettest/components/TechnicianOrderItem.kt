package tz.go.necta.widgettest.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TechnicianOrderItem(navController: NavController) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        .clickable {
            navController.navigate("technician_orders_details")
        }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Order #: " + "TFS230000001",
                modifier = Modifier.padding(vertical = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                "Services",
                modifier = Modifier.padding(vertical = 8.dp),
            )

            listOf<String>("Data 1", "Data 2").forEachIndexed { _, service ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "Arrow forward"
                    )
                    Text(
                        service,
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
            Text(
                "Order Date: 2023-09-28 10:00:00",
                modifier = Modifier.padding(vertical = 8.dp),
                fontWeight = FontWeight.SemiBold
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Status: "
                )

                Text(
                    "Pending",
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = Color.Red,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}