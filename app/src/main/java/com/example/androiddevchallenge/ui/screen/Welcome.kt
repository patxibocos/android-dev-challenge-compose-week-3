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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.MySootheButton

@Composable
fun Welcome(modifier: Modifier = Modifier, darkTheme: Boolean = false) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_dark_welcome else R.drawable.ic_light_welcome),
            contentDescription = "Welcome background image",
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo),
                contentDescription = "MySoothe logo",
            )
            MySootheButton(
                text = "SIGN UP",
                onClick = { },
                modifier = Modifier.padding(top = 32.dp)
            )
            MySootheButton(
                text = "LOG IN",
                onClick = { },
                modifier = Modifier.padding(top = 8.dp),
                backgroundColor = MaterialTheme.colors.secondary
            )
        }
    }
}
