package com.nexus.uidemo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    Surface(
        Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxSize()
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }
            item {
                Divider(
                    modifier = Modifier
                        .height(2.dp)
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
            item {
                Divider(
                    modifier = Modifier
                        .height(2.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}