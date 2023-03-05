package com.nexus.uidemo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.nexus.uidemo.R

val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_regular, weight = FontWeight.Normal),
    Font(R.font.nunito_sans_bold, weight = FontWeight.Bold),
    Font(R.font.nunito_sans_light, weight = FontWeight.Light),
    Font(R.font.nunito_sans_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.nunito_sans_extra_bold, weight = FontWeight.ExtraBold),
)

val activeTabStyle = TextStyle(
    fontFamily = NunitoSans,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 14.sp,
    textAlign = TextAlign.Center,
)

val statusTextStyle = TextStyle(fontFamily = NunitoSans, fontWeight = FontWeight.Normal)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = NunitoSans, fontWeight = FontWeight.Normal, fontSize = 14.sp
    ),
    h6 = TextStyle(
        fontFamily = NunitoSans, fontWeight = FontWeight.Medium, fontSize = 16.sp
    ),
    h5 = TextStyle(
        fontFamily = NunitoSans, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)