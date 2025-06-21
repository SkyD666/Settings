package com.skyd.settings

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SettingsStyle(
    val itemTopBottomSpace: Dp = 16.dp,
    val itemHorizontalSpace: Dp = 16.dp,
    val itemVerticalSpace: Dp = 1.dp,
    val baseItemVerticalPadding: Dp = 14.dp,
    val baseItemBackground: Color? = null,
    val baseItemEnabled: Boolean = true,
    val baseItemRoundTop: Boolean = false,
    val baseItemRoundBottom: Boolean = false,
    val baseItemUseColorfulIcon: Boolean = false,
)

val LocalSettingsStyle = compositionLocalOf { SettingsStyle() }

object SettingsDefaults {
    internal val itemRoundLarge = 20.dp
    internal val itemRoundSmall = 5.dp

    val itemTopBottomSpace: Dp
        @Composable get() = LocalSettingsStyle.current.itemTopBottomSpace
    val itemHorizontalSpace: Dp
        @Composable get() = LocalSettingsStyle.current.itemHorizontalSpace
    val itemVerticalSpace: Dp
        @Composable get() = LocalSettingsStyle.current.itemVerticalSpace

    val baseItemVerticalPadding: Dp
        @Composable get() = LocalSettingsStyle.current.baseItemVerticalPadding
    val baseItemBackground: Color
        @Composable get() = LocalSettingsStyle.current.baseItemBackground
            ?: MaterialTheme.colorScheme.surfaceContainerHighest
    val baseItemEnabled: Boolean
        @Composable get() = LocalSettingsStyle.current.baseItemEnabled
    val baseItemRoundTop: Boolean
        @Composable get() = LocalSettingsStyle.current.baseItemRoundTop
    val baseItemRoundBottom: Boolean
        @Composable get() = LocalSettingsStyle.current.baseItemRoundBottom
    val baseItemTopRound: Dp
        @Composable get() = if (baseItemRoundTop) itemRoundLarge else itemRoundSmall
    val baseItemBottomRound: Dp
        @Composable get() = if (baseItemRoundBottom) itemRoundLarge else itemRoundSmall
    val baseItemUseColorfulIcon: Boolean
        @Composable get() = LocalSettingsStyle.current.baseItemUseColorfulIcon
}