/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import java.util.Locale

object Routes {
    const val Welcome = "welcome"
    const val Login = "login"
    const val Home = "home"
}

@Composable
fun NavHostController.isAtHome(): Boolean {
    val navBackStackEntry: NavBackStackEntry? by this.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    return currentRoute == Routes.Home
}

@Composable
fun MySootheFloatingActionButton(darkTheme: Boolean) {
    FloatingActionButton(
        onClick = { },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = FloatingActionButtonDefaults.elevation(8.dp, 8.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_play_arrow_black else R.drawable.ic_play_arrow_white),
            contentDescription = "Play",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun MySootheBottomBar(darkTheme: Boolean) {
    @Composable
    fun RowScope.MySootheBottomNavigationItem(
        text: String,
        @DrawableRes darkImageResId: Int,
        @DrawableRes lightImageResId: Int
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = if (darkTheme) darkImageResId else lightImageResId),
                    contentDescription = text,
                    modifier = Modifier.size(18.dp)
                )
            },
            label = {
                Text(
                    text = text.toUpperCase(Locale.ROOT),
                    style = MaterialTheme.typography.caption
                )
            }
        )
    }

    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp
    ) {
        MySootheBottomNavigationItem("Home", R.drawable.ic_spa_black, R.drawable.ic_spa_white)
        MySootheBottomNavigationItem(
            "Profile",
            R.drawable.ic_account_circle_black,
            R.drawable.ic_account_circle_white
        )
    }
}
