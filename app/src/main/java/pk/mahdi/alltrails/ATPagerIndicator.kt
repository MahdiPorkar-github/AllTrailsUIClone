package com.adammcneilly.alltrails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adammcneilly.alltrails.theme.AllTrailsTheme

@Composable
fun ATPagerIndicator(
    currentPageIndex: Int,
    totalPages: Int,
    modifier: Modifier = Modifier,
) {
    val selectedColor = Color.White
    val defaultColor = selectedColor.copy(
        alpha = 0.50F,
    )

    val defaultSize = 12.dp
    val miniSize = 8.dp

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        StartIndicator(
            currentPageIndex = currentPageIndex,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
            miniSize = miniSize,
        )

        MidIndicator(
            currentPageIndex = currentPageIndex,
            totalPages = totalPages,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
        )

        EndIndicator(
            currentPageIndex = currentPageIndex,
            totalPages = totalPages,
            selectedColor = selectedColor,
            defaultColor = defaultColor,
            defaultSize = defaultSize,
            miniSize = miniSize,
        )
    }
}

@Composable
private fun EndIndicator(
    currentPageIndex: Int,
    totalPages: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
    miniSize: Dp,
) {
    val endIndicatorColor = when {
        currentPageIndex == totalPages - 1 -> selectedColor
        else -> defaultColor
    }

    val endIndicatorSize = when {
        currentPageIndex >= totalPages - 2 -> defaultSize
        else -> miniSize
    }

    IndicatorDot(endIndicatorColor, endIndicatorSize)
}

@Composable
private fun MidIndicator(
    currentPageIndex: Int,
    totalPages: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
) {
    val midIndicatorColor = when {
        currentPageIndex > 0 && currentPageIndex < totalPages - 1 -> selectedColor
        else -> defaultColor
    }

    IndicatorDot(midIndicatorColor, defaultSize)
}

@Composable
private fun StartIndicator(
    currentPageIndex: Int,
    selectedColor: Color,
    defaultColor: Color,
    defaultSize: Dp,
    miniSize: Dp,
) {
    val startIndicatorColor = when {
        currentPageIndex == 0 -> selectedColor
        else -> defaultColor
    }

    val startIndicatorSize = when {
        currentPageIndex <= 1 -> defaultSize
        else -> miniSize
    }

    IndicatorDot(startIndicatorColor, startIndicatorSize)
}

@Composable
private fun IndicatorDot(
    color: Color,
    size: Dp,
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(size),
    )
}

@Preview
@Composable
private fun StartPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 0,
                totalPages = 5,
            )
        }
    }
}

@Preview
@Composable
private fun MiddlePagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 2,
                totalPages = 5,
            )
        }
    }
}

@Preview
@Composable
private fun EndPagerIndicatorPreview() {
    AllTrailsTheme {
        Surface(
            color = Color.Black,
        ) {
            ATPagerIndicator(
                currentPageIndex = 4,
                totalPages = 5,
            )
        }
    }
}
