package com.adammcneilly.alltrails

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScrollingText(
    text: String,
    modifier: Modifier = Modifier,
) {
    AnimatedContent(
        targetState = text,
        transitionSpec = { textChangeAnimation() },
    ) { state ->
        Text(
            text = state,
            modifier = modifier,
        )
    }
}

private fun textChangeAnimation(durationMillis: Int = 500): ContentTransform {
    val enterTransition = slideInVertically(
        animationSpec = tween(durationMillis),
    ) { height ->
        height
    } + fadeIn(
        animationSpec = tween(durationMillis),
    )

    val exitTransition = slideOutVertically(
        animationSpec = tween(durationMillis),
    ) { height ->
        -height
    } + fadeOut(
        animationSpec = tween(durationMillis),
    )

    return enterTransition.togetherWith(exitTransition)
}
