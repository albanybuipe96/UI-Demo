package com.nexus.uidemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
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
import com.nexus.uidemo.R
import com.nexus.uidemo.ui.theme.*

@Composable
fun TransactionCard(
    time: String,
    userName: String,
    phone: String,
    isSuccessful: Boolean,
    amount: Double,
    imageId: Int,
    comment: String,
    starred: Boolean,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 1.dp, color = BackgroundGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = time, color = Color.LightGray)
            Column(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 0.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row {
                    Image(
                        painterResource(id = imageId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(39.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = userName)
                            TransactionStatus(isSuccessful)
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = phone, color = Color.LightGray)
                            Spacer(modifier = Modifier.fillMaxWidth(fraction = 0.7f))
                            Text(
                                text = "GHS ${amount.toInt()}",
                                style = statusTextStyle.copy(fontWeight = FontWeight.ExtraBold)
                            )
                        }
                    }
                }
            }
            Divider(modifier = Modifier.height(1.dp))
            CardBottom(title = "Personal", comment = comment, starred = starred)
        }
    }
}

@Composable
private fun TransactionStatus(isSuccessful: Boolean) {
    Surface(
        shape = RoundedCornerShape(13.dp),
        color = if (isSuccessful) BackgroundGreen else BackgroundBrown
    ) {
        Row(
            modifier = Modifier
//                                        .fillMaxWidth(fraction = 0.8f)
                .padding(
                    top = 3.dp, bottom = 3.dp, end = 9.dp, start = 3.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = if (isSuccessful) R.drawable.successful else R.drawable.failed_icon),
                contentDescription = null,
                modifier = Modifier.padding(start = 3.dp, end = 3.dp)
            )
            if (isSuccessful) {
                Text(
                    text = "Successful",
                    style = statusTextStyle.copy(color = TextGreen)
                )
            } else {
                Text(
                    text = "Failed",
                    style = statusTextStyle.copy(color = TextBrown)
                )
            }
        }
    }
}

@Composable
private fun CardBottom(
    title: String = "Personal",
    comment: String? = "Cool your heart wai",
    starred: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.person_icon),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(end = 5.dp)
        )
        Text(text = title)
        Surface(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(4.dp)
                .height(4.dp),
            shape = CircleShape,
            color = Color(0xFF9CABB8)
        ) {}
        Text(text = comment ?: "")
        Spacer(modifier = Modifier.fillMaxWidth(fraction = 0.7f))
        Image(
            painter = painterResource(id = R.drawable.favorite_icon),
            contentDescription = null,
            modifier = Modifier.size(15.dp)
        )
    }
}
