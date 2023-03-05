package com.nexus.uidemo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexus.uidemo.model.History
import com.nexus.uidemo.model.getHistories
import com.nexus.uidemo.ui.theme.BackgroundGray
import com.nexus.uidemo.ui.theme.TextGray

@Composable
@Preview
fun HistoryCard(history: History = getHistories()[0]) {
    Column(
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(13.dp), color = BackgroundGray
        ) {
            Text(
                text = "${history.month} ${history.day}, ${history.year}",
                style = MaterialTheme.typography.h5.copy(fontSize = 10.sp, color = TextGray),
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp),
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        history.transactions.forEach { transaction ->
            TransactionCard(
                time = transaction.time,
                userName = transaction.userName,
                phone = transaction.phone,
                isSuccessful = transaction.isSuccessful,
                amount = transaction.amount,
                imageId = transaction.imageId,
                comment = transaction.comment,
                starred = transaction.starred
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}