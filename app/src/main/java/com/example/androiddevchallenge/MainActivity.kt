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
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.home
import com.example.androiddevchallenge.ui.navigation.MySootheBottomBar
import com.example.androiddevchallenge.ui.navigation.MySootheFloatingActionButton
import com.example.androiddevchallenge.ui.navigation.Routes
import com.example.androiddevchallenge.ui.navigation.isAtHome
import com.example.androiddevchallenge.ui.screen.Home
import com.example.androiddevchallenge.ui.screen.Login
import com.example.androiddevchallenge.ui.screen.Welcome
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                ProvideWindowInsets {
                    MySootheApp(isSystemInDarkTheme())
                }
            }
        }
    }
}

@Composable
fun MySootheApp(darkTheme: Boolean) {
    val navController = rememberNavController()
    Scaffold(
        floatingActionButton = {
            if (navController.isAtHome()) {
                MySootheFloatingActionButton(darkTheme)
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (navController.isAtHome()) {
                MySootheBottomBar(darkTheme)
            }
        }
    ) { paddingValues ->
        NavHost(navController, startDestination = Routes.Welcome) {
            composable(Routes.Welcome) {
                Welcome(
                    Modifier.padding(paddingValues),
                    darkTheme
                ) { navController.navigate(Routes.Login) }
            }
            composable(Routes.Login) {
                Login(
                    Modifier.padding(paddingValues),
                    darkTheme
                ) { navController.navigate(Routes.Home) }
            }
            composable(Routes.Home) { Home(home, Modifier.padding(paddingValues), darkTheme) }
        }
    }
}
