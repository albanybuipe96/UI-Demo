package com.nexus.uidemo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nexus.uidemo.ui.theme.BackgroundWhite
import com.nexus.uidemo.ui.theme.FabBackground

@Composable
@Preview
fun FabIconButton() {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = FabBackground,
        modifier = Modifier
            .padding(12.dp)
//            .height(45.dp)
            .clickable {}) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.padding(end = 5.dp, top = 3.dp),
                shape = CircleShape,
                color = BackgroundWhite
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Send new",
                    tint = FabBackground
                )
            }
            Text(
                text = "SEND NEW",
                style = MaterialTheme.typography.h5.copy(color = BackgroundWhite)
            )
        }
    }
}