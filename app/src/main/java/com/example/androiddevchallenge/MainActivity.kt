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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.data.home
import com.example.androiddevchallenge.ui.screen.Home
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                ProvideWindowInsets {
                    MyApp(isSystemInDarkTheme())
                }
            }
        }
    }
}

@Composable
fun MyApp(darkTheme: Boolean) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }, backgroundColor = MaterialTheme.colors.primary) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_play_arrow_black else R.drawable.ic_play_arrow_white),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.navigationBarsPadding(),
                backgroundColor = MaterialTheme.colors.background
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_spa_black else R.drawable.ic_spa_white),
                            contentDescription = "Home",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(text = "HOME", style = MaterialTheme.typography.caption)
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_account_circle_black else R.drawable.ic_account_circle_white),
                            contentDescription = "Profile",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(text = "PROFILE", style = MaterialTheme.typography.caption)
                    }
                )
            }
        }
    ) { paddingValues ->
        Home(home, Modifier.padding(paddingValues), darkTheme)
    }
}
