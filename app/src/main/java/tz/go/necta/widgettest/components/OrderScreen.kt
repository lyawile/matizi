package tz.go.necta.widgettest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Orders(navController: NavController){
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
        items(listOf(1, 2).size) {
            TechnicianOrderItem(navController)
        }
    }
}