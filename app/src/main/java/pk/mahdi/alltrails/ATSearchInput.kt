package com.adammcneilly.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.alltrails.theme.AllTrailsTheme
import kotlinx.coroutines.delay

/**
 * This is implemented as a [SearchBar] for now to get
 * as close as possible to the existing UI. However,
 * if we decide to animate the text similar to AllTrails, we will probably
 * need to replace this with a custom component that gives us
 * control over the query content (as opposed to this which just consumes
 * a string).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ATSearchInput(modifier: Modifier = Modifier) {
    val typeOptions = listOf("trails", "parks", "cities")

    var typeIndex by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)

            typeIndex = (typeIndex + 1) % typeOptions.size
        }
    }

    SearchBar(
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = null,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = CircleShape,
                    ).padding(6.dp),
            )
        },
        placeholder = {
            Row {
                Text(
                    text = "Find ",
                )

                ScrollingText(
                    text = typeOptions[typeIndex],
                )
            }
        },
        modifier = modifier,
    ) {
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
private fun ATSearchInputPreview() {
    AllTrailsTheme {
        ATSearchInput(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )
    }
}
