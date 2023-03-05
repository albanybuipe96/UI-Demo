package com.nexus.uidemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nexus.uidemo.ui.theme.BackgroundGray
import com.nexus.uidemo.ui.theme.TextGray2
import com.nexus.uidemo.ui.theme.activeTabStyle

@Composable
fun TabBar() {
    var index by remember {
        mutableStateOf(0)
    }
    TabRow(
        selectedTabIndex = index,
        backgroundColor = BackgroundGray,
        contentColor = BackgroundGray,
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
    ) {
        val tabs = listOf(
            "History", "Transaction Summary"
        )
        tabs.forEachIndexed() { tabIndex, tabTitle ->
            Tab(
                modifier = Modifier.padding(4.dp),
                selected = index == tabIndex,
                onClick = { index = tabIndex }) {
                if (index == tabIndex) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
//                            .fillMaxHeight(),
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp),
                        elevation = 1.dp,
                        border = BorderStroke(width = 1.dp, color = Color.White)
                    ) {
                        Text(
                            text = tabTitle,
                            style = activeTabStyle,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                } else {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
//                            .fillMaxHeight(),
                        color = BackgroundGray
                    ) {
                        Text(
                            text = tabTitle,
                            style = activeTabStyle.copy(fontWeight = FontWeight.Normal, color = TextGray2),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

/**



 */