package com.nexus.uidemo.model

import com.nexus.uidemo.R

data class History(
    val month: String, val day: String, val year: String, val transactions: List<Transaction>
)

data class Transaction(
    val time: String,
    val userName: String,
    val phone: String,
    val isSuccessful: Boolean,
    val amount: Double,
    val imageId: Int,
    val comment: String,
    val starred: Boolean,
)

fun getHistories() = listOf<History>(
    History(
        month = "May", day = "24", year = "2022", transactions = listOf(
            Transaction(
                time = "14:45PM",
                userName = "Emmanuel Rockson",
                phone = "024 123 456",
                isSuccessful = true,
                amount = 500.0,
                imageId = R.drawable.mtn_mobile_money_double,
                comment = "Cool your heart wai",
                starred = true
            ),
            Transaction(
                time = "14:45PM",
                userName = "Absa Bank",
                phone = "024 123 456",
                isSuccessful = false,
                amount = 500.0,
                imageId = R.drawable.absa_double,
                comment = "Cool your heart wai",
                starred = false
            ),

            )
    ), History(
        month = "May", day = "23", year = "2022", transactions = listOf(
            Transaction(
                time = "14:45PM",
                userName = "Emmanuel Rockson",
                phone = "024 123 456",
                isSuccessful = true,
                amount = 500.0,
                imageId = R.drawable.mtn_mobile_money_double,
                comment = "Cool your heart wai",
                starred = true
            ), Transaction(
                time = "14:45PM",
                userName = "Emmanuel Rockson",
                phone = "024 123 456",
                isSuccessful = false,
                amount = 500.0,
                imageId = R.drawable.absa_double,
                comment = "",
                starred = true
            )
        )
    )
)