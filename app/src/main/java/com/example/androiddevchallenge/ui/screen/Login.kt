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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.MySootheButton
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.ext.firstBaselineToTopAndBottom

@Composable
fun Login(modifier: Modifier, darkTheme: Boolean, onLoginClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_dark_login else R.drawable.ic_light_login),
            contentDescription = "Login background image",
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.firstBaselineToTopAndBottom(200.dp, 32.dp),
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Left
            )
            MySootheTextField(
                value = "",
                placeholderText = "Email address",
                onValueChange = {},
            )
            MySootheTextField(
                value = "",
                placeholderText = "Password",
                onValueChange = {},
                modifier = Modifier.padding(top = 8.dp)
            )
            MySootheButton(
                text = "LOG IN",
                onClick = onLoginClick,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = buildAnnotatedString {
                    append("Don't have an account? ")
                    withStyle(
                        style = MaterialTheme.typography.body1.toSpanStyle()
                            .copy(
                                textDecoration = TextDecoration.Underline,
                                color = MaterialTheme.colors.onBackground
                            )
                    ) {
                        append("Sign up")
                    }
                },
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(32.dp),
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
