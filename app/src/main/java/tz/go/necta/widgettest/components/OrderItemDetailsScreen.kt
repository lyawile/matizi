package tz.go.necta.widgettest.components

import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderItemDetailsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
            .padding()
    ) {
        var phoneNumber by remember { mutableStateOf("") }
        val context = LocalContext.current
        Column() {
            Box(
                modifier = Modifier.weight(0.5f)
                    .fillMaxHeight().fillMaxWidth(),
                contentAlignment = Alignment.Center,

                ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Hassan Lyawile", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    Text("Requested from Dodoma, TZ")
                    Text("67.5E, 100N")
                }
            }

            Box(
                modifier = Modifier.weight(1f).padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(24.dp)).padding(bottom = 16.dp)
                    .fillMaxHeight().fillMaxWidth().background(Color.White)
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Column(modifier = Modifier.weight(1f).fillMaxWidth()) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Row(modifier = Modifier.padding(top = 32.dp),
                                verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "0718 440 572", modifier = Modifier.weight(1f),
                                    fontSize = 24.sp
                                )
                                val phoneNumber = "0718440572"

                                Box(modifier = Modifier.clip(CircleShape).wrapContentSize()
                                    .background(Color(0XFF006400)).padding(8.dp)){
                                    Icon(
                                        imageVector = Icons.Filled.Call,
                                        modifier = Modifier.height(32.dp).width(32.dp).clickable {
                                            val intent = Intent(Intent.ACTION_DIAL)
                                            intent.data = Uri.parse("tel:$phoneNumber")
                                            context.startActivities(arrayOf(intent))
                                        },
                                        tint = Color.White,
                                        contentDescription = "Call Icon"
                                    )
                                }

                            }

                            Row(modifier = Modifier.padding(top = 32.dp)) {
                                var text by remember { mutableStateOf("") }
                                Box(modifier = Modifier.weight(1f).padding(end = 16.dp)) {
                                    BasicTextField(
                                        value = text,
                                        textStyle = TextStyle(
                                            fontSize = 24.sp,
                                        ),
                                        onValueChange = {
                                            text = it
                                        },
                                        maxLines = 1,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(48.dp).clip(RoundedCornerShape(24.dp))
                                            .background(Color.LightGray)
                                            .padding(start = 16.dp).padding(vertical = 8.dp),
                                        interactionSource = remember { MutableInteractionSource() }
                                            .also { interactionSource ->
                                                LaunchedEffect(interactionSource) {
                                                    interactionSource.interactions.collect {
                                                        if (it is PressInteraction.Release) {
//                                        togglePlaceholder = text.isNotEmpty()
                                                        }
                                                    }
                                                }
                                            }
                                    )
                                }





                                Button(
                                    modifier = Modifier.height(48.dp),
                                    onClick = {

                                    }) {
                                    Text("Save Amount", color = Color.White)
                                }
                            }

                            var textAdditional by remember { mutableStateOf("") }
                            var hide by remember { mutableStateOf(false) }
                            Box(modifier = Modifier.weight(1f).padding(top = 16.dp)) {
                                BasicTextField(
                                    value = textAdditional,
                                    textStyle = TextStyle(
                                        fontSize = 24.sp,
                                    ),
                                    onValueChange = {
                                        textAdditional = it
                                    },
                                    maxLines = 10,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp).clip(RoundedCornerShape(16.dp))
                                        .background(Color.LightGray)
                                        .padding(start = 16.dp).padding(vertical = 8.dp),
                                    interactionSource = remember { MutableInteractionSource() }
                                        .also { interactionSource ->
                                            LaunchedEffect(interactionSource) {
                                                interactionSource.interactions.collect {
                                                    if (it is PressInteraction.Release) {
//                                        togglePlaceholder = text.isNotEmpty()
                                                        hide = true
                                                    }
                                                }
                                            }
                                        },
                                    decorationBox = {
                                        if(!hide){
                                            Text("Enter technical note")
                                        }
                                    }
                                )
                            }
                        }
                    }
                    Button(
                        onClick = {

                        },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp).height(48.dp)
                    ) {
                        Text(text = "Confirm Order", color = Color.White)
                    }
                }
            }
        }
    }
}