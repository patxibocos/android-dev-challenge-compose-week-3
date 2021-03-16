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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.ext.firstBaselineToTop

@Composable
fun Home(modifier: Modifier = Modifier, darkTheme: Boolean = false) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        MySootheTextField(
            value = "",
            placeholderText = "Search",
            onValueChange = { },
            modifier = Modifier.padding(top = 56.dp),
            leadingIcon = {
                Image(
                    painter = painterResource(id = if (darkTheme) R.drawable.ic_search_white else R.drawable.ic_search_black),
                    contentDescription = "Search",
                    modifier = Modifier.size(18.dp)
                )
            }
        )
        Text(
            text = "FAVORITE COLLECTIONS",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.firstBaselineToTop(40.dp, 8.dp)
        )
        Text(
            text = "ALIGN YOUR BODY",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.firstBaselineToTop(48.dp, 8.dp)
        )
        Text(
            text = "ALIGN YOUR MIND",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.firstBaselineToTop(48.dp, 8.dp)
        )
    }
}
