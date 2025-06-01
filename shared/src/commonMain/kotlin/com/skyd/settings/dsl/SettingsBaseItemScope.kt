package com.skyd.settings.dsl

import androidx.compose.foundation.lazy.LazyItemScope

interface SettingsBaseItemScope : LazyItemScope
interface SettingsOtherItemScope : LazyItemScope
interface SettingsItemScope : SettingsBaseItemScope, SettingsOtherItemScope

internal class SettingsBaseItemScopeImpl(lazyItemScope: LazyItemScope) :
    SettingsBaseItemScope, LazyItemScope by lazyItemScope

internal class SettingsOtherItemScopeImpl(lazyItemScope: LazyItemScope) :
    SettingsOtherItemScope, LazyItemScope by lazyItemScope

internal class SettingsItemScopeImpl(lazyItemScope: LazyItemScope) :
    SettingsItemScope, LazyItemScope by lazyItemScope