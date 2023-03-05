package com.nexus.uidemo.components.bottom_nav_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexus.uidemo.ui.theme.SelectedNavItemColor
import com.nexus.uidemo.ui.theme.UnselectedGray

@Composable
fun BottomNavBar(currentScreenId: String, onItemSelected: (Page) -> Unit) {
    val pages = Page.pages.list
    Column {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            pages.forEach { page ->
                BottomNavBarItem(page = page, isSelected = page.id == currentScreenId) {
                    onItemSelected(page)
                }
            }
        }
        Divider(
            thickness = 5.dp, color = Color(0xFF000000), modifier = Modifier
                .padding(horizontal = 120.dp, vertical = 5.dp)
                .clip(RoundedCornerShape(100.dp))
        )
    }
}

@Composable
fun BottomNavBarItem(page: Page, isSelected: Boolean, onClick: () -> Unit) {
    val selectedTextStyle =
        if (isSelected) {
            MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 10.sp
            )
        } else {
            MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 10.sp,
                color = UnselectedGray
            )
        }
    val background = when(page) {
        is Page.Home -> {
            SelectedNavItemColor
        }
        else -> {
            Color.Transparent
        }
    }
    val contentColor =
        if (isSelected) Color(0xFF000000) else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(id = page.imageId),
                contentDescription = page.title,
                contentScale = ContentScale.Crop,
            )
            if (page != Page.Home) {
                Text(
                    text = page.title,
                    style = selectedTextStyle
                )
            }
        }
    }
}

@Composable
//@Preview
fun Prev1() {
    BottomNavBar(currentScreenId = Page.Home.id) {}
}

@Composable
//@Preview
fun Prev2() {
    BottomNavBarItem(page = Page.Home, isSelected = true) {}
}