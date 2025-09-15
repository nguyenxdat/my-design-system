package com.datnx.design_system.components

import DisableColor
import PrimaryColor
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.datnx.design_system.theme.LocalTypo

@Composable
fun ButtonApp(
    modifier: Modifier = Modifier,
    btnTitle: String,
    isEnable: Boolean = true,
    onBtnClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp,
            bottomStart = 0.dp,
            bottomEnd = 8.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isEnable) PrimaryColor else DisableColor,
        ),
        onClick = onBtnClick
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = btnTitle,
                style = if (isEnable) LocalTypo.current.textButtonEnable else LocalTypo.current.textButtonDisable
            )
        }
    }
}

@Preview
@Composable
fun PreviewButtonApp(modifier: Modifier = Modifier) {
    ButtonApp(btnTitle = "Button", onBtnClick = {})
}