package com.adammcneilly.alltrails

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.alltrails.theme.AllTrailsTheme

@Composable
fun ATBottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
    ) {
        ExploreTab()
        CommunityTab()
        NavigateTab()
        SavedTab()
        ProfileTab()
    }
}

@Composable
private fun RowScope.ExploreTab() {
    NavItem(
        icon = Icons.Default.Search,
        label = "Explore",
        selected = true,
    )
}

@Composable
private fun RowScope.CommunityTab() {
    NavItem(
        icon = Icons.Default.People,
        label = "Community",
    )
}

@Composable
private fun RowScope.NavigateTab() {
    NavItem(
        icon = Icons.Default.Navigation,
        label = "Navigate",
    )
}

@Composable
private fun RowScope.SavedTab() {
    NavItem(
        icon = Icons.Default.BookmarkBorder,
        label = "Saved",
    )
}

@Composable
private fun RowScope.ProfileTab() {
    NavItem(
        icon = Icons.Default.Person,
        label = "Profile",
    )
}

@Composable
private fun RowScope.NavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean = false,
) {
    val selectedColor = MaterialTheme.colorScheme.onSurface
    val unselectedColor = selectedColor.copy(
        alpha = 0.50F,
    )

    val colorsWithoutIndicator = NavigationBarItemDefaults.colors().copy(
        selectedIconColor = selectedColor,
        selectedTextColor = selectedColor,
        selectedIndicatorColor = Color.Transparent,
        unselectedIconColor = unselectedColor,
        unselectedTextColor = unselectedColor,
    )

    NavigationBarItem(
        selected = selected,
        onClick = {},
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold.takeIf { selected },
            )
        },
        colors = colorsWithoutIndicator,
    )
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
private fun ATBottomBarPreview() {
    AllTrailsTheme {
        ATBottomBar()
    }
}
