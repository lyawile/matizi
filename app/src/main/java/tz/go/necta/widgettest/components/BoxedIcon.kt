package tz.go.necta.widgettest.components

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tz.go.necta.widgettest.R

@Composable
fun BoxedIcon(imageVector: ImageVector? = null, drawable: Int? = 0) {
    Box(
        modifier = Modifier.height(32.dp).width(32.dp)
            .background(
                Color(0XFF0262ad),
                shape = RoundedCornerShape(20)
            ),
        contentAlignment = Alignment.Center
    )
    {
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Person",
                tint = Color.White
            )
        }
        if (drawable != 0)
            drawable?.let { painterResource(it) }?.let {
                Icon(
                    painter = it,
                    contentDescription = "icon",
                    tint = Color.White,
                    modifier = Modifier.height(16.dp).width(16.dp)
                )
            }
    }
}

@Composable
@Preview
fun Preview() {
    BoxedIcon(drawable = R.drawable.sharp_adb_24)
}