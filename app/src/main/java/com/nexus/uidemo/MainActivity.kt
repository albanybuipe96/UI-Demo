package com.nexus.uidemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nexus.uidemo.components.FabIconButton
import com.nexus.uidemo.components.HistoryCard
import com.nexus.uidemo.components.SearchRow
import com.nexus.uidemo.components.TabBar
import com.nexus.uidemo.components.bottom_nav_bar.BottomNavBar
import com.nexus.uidemo.components.bottom_nav_bar.Page
import com.nexus.uidemo.model.getHistories
import com.nexus.uidemo.ui.theme.BackgroundWhite
import com.nexus.uidemo.ui.theme.UIDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentScreen = remember {
                mutableStateOf<Page>(Page.Home)
            }
            UIDemoTheme {
                TransparentSystemBars()
                Surface(modifier = Modifier.padding(5.dp)) {
                    Scaffold(modifier = Modifier.background(color = BackgroundWhite), topBar = {
                        TabBar()
                    }, content = { /*padding -> */
                        LazyColumn {
                            it
                            item {
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                            item {
                                Divider(
                                    modifier = Modifier.height(2.dp)
                                )
                            }
                            item {
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                            item {
                                SearchRow()
                            }
                            item {
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                            items(getHistories()) {
                                HistoryCard(history = it)
                            }

                        }
                    }, bottomBar = {
                        BottomNavBar(currentScreenId = currentScreen.value.id) {
                            currentScreen.value = it
                        }
                    }, floatingActionButton = {
                        FabIconButton()
                    }, floatingActionButtonPosition = FabPosition.Center
                    )
                }
            }
        }
    }
}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent, darkIcons = useDarkIcons
        )
    }
}