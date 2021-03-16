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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun FavoriteItem(text: String, @DrawableRes drawableResId: Int) {
    Surface(
        modifier = Modifier
            .size(192.dp, 56.dp)
            .clip(MaterialTheme.shapes.small)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
                painter = painterResource(id = drawableResId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = text,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}