package com.plcoding.woox.ui.componts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.woox.common.theme.ColorPrimary
import com.plcoding.woox.common.theme.fonts

@Composable
fun CustomButton(
    name: String,
    onButtonClick: () -> Unit,
    paddingTop: Int = 0,
    paddingHorizontal: Int = 0,
    modifier: Modifier,
    fontSize: TextUnit = 16.sp
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = paddingHorizontal.dp,
                end = paddingHorizontal.dp,
                top = paddingTop.dp
            ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 8.dp, pressedElevation = 20.dp, focusedElevation = 20.dp
        ),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ColorPrimary),
        onClick = onButtonClick
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontSize = fontSize,
                color = Color.Black,
                fontFamily = fonts,
                fontWeight = FontWeight.W500
            )
        )
    }
}