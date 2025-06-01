package com.skyd.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skyd.settings.dsl.SettingsLazyListScope
import com.skyd.settings.dsl.SettingsLazyListScopeImpl

@Composable
fun SettingsLazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: SettingsLazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding + PaddingValues(vertical = SettingsDefaults.itemTopBottomSpace),
        content = { SettingsLazyListScopeImpl(this).content() },
    )
}