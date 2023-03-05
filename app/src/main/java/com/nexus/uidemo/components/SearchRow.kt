package com.nexus.uidemo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nexus.uidemo.R
import com.nexus.uidemo.ui.theme.BackgroundGray
import com.nexus.uidemo.ui.theme.TextGray2

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
fun SearchRow() {
    var search by remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = search,
            onValueChange = {
                search = it
            },
            singleLine = true,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "Search",
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp)
                )
            },
            placeholder = {
                Text(text = "Search")
            },
            label = {
                Text(text = "Search")
            },
            shape = RoundedCornerShape(6.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = TextGray2,
                backgroundColor = BackgroundGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            }),
            modifier = Modifier.weight(fill = true, weight = 0.2f)
        )
        Image(
            painter = painterResource(id = R.drawable.shutter_stock_one),
            contentDescription = "",
            modifier = Modifier
                .width(44.dp)
                .height(40.dp),
        )
    }
}