package tz.go.necta.widgettest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tz.go.necta.widgettest.R

@Composable
 fun DriverOrder(){
     Column {
         Box(modifier = Modifier.background(MaterialTheme.colorScheme.primary)
             .fillMaxWidth()
             .height(50.dp)){
             Row(
                 horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                 Row(verticalAlignment = Alignment.CenterVertically){
                     Text(text = "GO ONLINE", fontSize = 32.sp)
                     Image(painter = painterResource(R.drawable.double_arrow),
                         contentDescription ="Arrow")
                 }
             }
         }
     }
 }