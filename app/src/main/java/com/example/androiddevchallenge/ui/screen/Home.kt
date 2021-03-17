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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Align
import com.example.androiddevchallenge.data.Favorite
import com.example.androiddevchallenge.data.Home
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.ext.firstBaselineToTopAndBottom
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Home(home: Home, modifier: Modifier, darkTheme: Boolean) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        MySootheTextField(
            value = "",
            placeholderText = "Search",
            onValueChange = { },
            modifier = Modifier.padding(top = 56.dp, end = 16.dp),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = if (darkTheme) R.drawable.ic_search_white else R.drawable.ic_search_black),
                    contentDescription = "Search",
                    modifier = Modifier.size(18.dp),
                    tint = MaterialTheme.colors.onSurface
                )
            }
        )
        FavoriteCollection(home.favorites)
        AlignYourBody(home.bodyAligns)
        AlignYourMind(home.mindAligns)
    }
}

@Composable
fun FavoriteCollection(favorites: List<Favorite>) {

    @Composable
    fun FavoritesRow(data: List<Favorite>, modifier: Modifier = Modifier) {
        LazyRow(modifier = modifier.fillMaxWidth()) {
            items(
                items = data,
                itemContent = { item ->
                    FavoriteItem(text = item.name, imageUrl = item.imageUrl)
                    Spacer(modifier = Modifier.width(if (data.last() == item) 16.dp else 8.dp))
                }
            )
        }
    }

    Text(
        text = "FAVORITE COLLECTIONS",
        style = MaterialTheme.typography.h2,
        modifier = Modifier.firstBaselineToTopAndBottom(40.dp, 8.dp)
    )
    FavoritesRow(favorites.filterIndexed { index, _ -> index % 2 == 0 })
    FavoritesRow(
        favorites.filterIndexed { index, _ -> index % 2 != 0 },
        modifier = Modifier.padding(top = 8.dp)
    )
}

@Composable
fun AlignYourBody(bodyAligns: List<Align>) {
    Text(
        text = "ALIGN YOUR BODY",
        style = MaterialTheme.typography.h2,
        modifier = Modifier.firstBaselineToTopAndBottom(48.dp, 8.dp)
    )
    AlignRow(bodyAligns)
}

@Composable
fun AlignYourMind(mindAligns: List<Align>) {
    Text(
        text = "ALIGN YOUR MIND",
        style = MaterialTheme.typography.h2,
        modifier = Modifier.firstBaselineToTopAndBottom(40.dp, 8.dp)
    )
    AlignRow(mindAligns)
}

@Composable
fun AlignRow(aligns: List<Align>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(
            items = aligns,
            itemContent = { item ->
                AlignItem(text = item.name, imageUrl = item.imageUrl)
                Spacer(modifier = Modifier.width(if (aligns.last() == item) 16.dp else 8.dp))
            }
        )
    }
}

@Composable
fun FavoriteItem(text: String, imageUrl: String) {
    Surface(
        modifier = Modifier
            .size(192.dp, 56.dp)
            .clip(MaterialTheme.shapes.small)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoilImage(
                data = imageUrl,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
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

@Composable
fun AlignItem(text: String, imageUrl: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CoilImage(
            data = imageUrl,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.firstBaselineToTopAndBottom(24.dp, 8.dp),
            maxLines = 1
        )
    }
}
