package com.datnx.design_system.theme

import ErrorColor
import PrimaryColor
import TextDisableColor
import TextDisableColor2
import TextEnableColor
import TextPrimaryColor
import TextPrimaryColor2
import TextSecondaryColor
import ValueInforColor
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


data class CustomTextType(
    val dialogTitle: TextStyle,
    val inputTitle: TextStyle,
    val normal: TextStyle,
    val normal2: TextStyle,
    val normal3: TextStyle,
    val languageTitle: TextStyle,
    val requiredSymbol: TextStyle,
    val requiredSymbol2: TextStyle,
    val requiredSymbol3: TextStyle,
    val textButtonEnable: TextStyle,
    val textButtonEnable2: TextStyle,
    val textButtonDisable: TextStyle,
    val textError: TextStyle,
    val textOtp: TextStyle,
    val subTitle: TextStyle,
    val settingValue: TextStyle,
    val settingTitle: TextStyle,
    val userNameTitle: TextStyle,
)

val customType = CustomTextType(
    dialogTitle = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextPrimaryColor,
        textAlign = TextAlign.Center
    ),
    inputTitle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = Color(0XFF737373),
        textAlign = TextAlign.Start
    ),
    normal = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(400),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextPrimaryColor,
        textAlign = TextAlign.Center
    ),
    normal2 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(400),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextSecondaryColor,
        textAlign = TextAlign.Center
    ),
    normal3 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight(500),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = Color.White,
        textAlign = TextAlign.Center
    ),
    languageTitle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = Color(0XFF737373),
        textAlign = TextAlign.Center
    ),
    requiredSymbol = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = PrimaryColor,
        textAlign = TextAlign.Unspecified
    ),
    requiredSymbol2 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = PrimaryColor,
        textAlign = TextAlign.Center
    ),

    requiredSymbol3 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextDisableColor,
        textAlign = TextAlign.Unspecified
    ),
    textButtonEnable = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextEnableColor,
        textAlign = TextAlign.Center
    ),
    textButtonEnable2 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextPrimaryColor2,
        textAlign = TextAlign.Center
    ),
    textButtonDisable = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextDisableColor,
        textAlign = TextAlign.Center
    ),
    textError = TextStyle(
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(500),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = ErrorColor,
        textAlign = TextAlign.Center
    ),
    textOtp = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight(600),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextPrimaryColor,
        textAlign = TextAlign.Center
    ),
    subTitle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(600),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextPrimaryColor,
        textAlign = TextAlign.Center
    ),
    settingValue = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(600),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = ValueInforColor,
        textAlign = TextAlign.End
    ),
    settingTitle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight(600),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = TextDisableColor2,
        textAlign = TextAlign.End
    ),
    userNameTitle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(700),
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        color = ValueInforColor,
        textAlign = TextAlign.Start
    ),
)


val LocalTypo = compositionLocalOf { customType }
