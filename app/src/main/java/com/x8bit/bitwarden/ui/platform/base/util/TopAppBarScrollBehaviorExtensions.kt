package com.x8bit.bitwarden.ui.platform.base.util

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

/**
 * Returns the correct color for a scrolled container based on the given [TopAppBarScrollBehavior]
 * and target [expandedColor] / [collapsedColor].
 */
@OptIn(ExperimentalMaterial3Api::class)
fun TopAppBarScrollBehavior.toScrolledContainerColor(
    expandedColor: Color,
    collapsedColor: Color,
): Color {
    val progressFraction = if (this.isPinned) {
        this.state.overlappedFraction
    } else {
        this.state.collapsedFraction
    }
    return lerp(
        start = expandedColor,
        stop = collapsedColor,
        fraction = progressFraction,
    )
}
