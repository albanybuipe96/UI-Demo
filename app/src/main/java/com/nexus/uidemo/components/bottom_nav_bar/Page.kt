package com.nexus.uidemo.components.bottom_nav_bar

import com.nexus.uidemo.R

sealed class Page(val id: String, val title: String, val imageId: Int) {
    object Home : Page("home", "Home", R.drawable.home_icon)
    object Send : Page("send", "Send", R.drawable.send_icon)
    object History : Page("history", "History", R.drawable.history_icon)
    object Scheduled : Page("scheduled", "Scheduled", R.drawable.schedule)

    object pages {
        val list = listOf(Home, Send, History, Scheduled)
    }
}