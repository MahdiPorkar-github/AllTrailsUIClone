package com.adammcneilly.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.alltrails.theme.AllTrailsTheme

@Composable
fun TrailGroupListItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1F)
            .clip(RoundedCornerShape(32.dp)),
    ) {
        Image(
            painter = painterResource(R.drawable.nationalpark),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black,
                        ),
                    ),
                ).align(Alignment.BottomStart)
                .padding(16.dp),
        ) {
            Text(
                text = "Trout Brook Valley State Park Reserve",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
            )

            Text(
                text = "10 trails • Connecticut, United States",
                color = Color.White,
            )
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun TrailGroupListItemPreview() {
    AllTrailsTheme {
        TrailGroupListItem()
    }
}
