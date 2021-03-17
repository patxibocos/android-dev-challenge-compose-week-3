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
package com.example.androiddevchallenge.data

class Home(val favorites: List<Favorite>, val bodyAligns: List<Align>, val mindAligns: List<Align>)
class Favorite(val name: String, val imageUrl: String)
class Align(val name: String, val imageUrl: String)

private val favorites = listOf(
    Favorite("Short mantras", "https://images.pexels.com/photos/4515858/pexels-photo-4515858.jpeg"),
    Favorite(
        "Nature meditations",
        "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg"
    ),
    Favorite(
        "Stress and anxiety",
        "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg"
    ),
    Favorite("Self-massage", "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg"),
    Favorite("Overwhelmed", "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg"),
    Favorite(
        "Nightly wind down",
        "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg"
    )
)

private val bodyAligns = listOf(
    Align("Inversions", "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg"),
    Align("Quick yoga", "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg"),
    Align("Stretching", "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg"),
    Align("Tabata", "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg"),
    Align("HIIT", "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg"),
    Align("Pre-natal yoga", "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg")
)

private val mindAligns = listOf(
    Align("Meditate", "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg"),
    Align("With kids", "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg"),
    Align("Aromatherapy", "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg"),
    Align("On the go", "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg"),
    Align("With pets", "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg"),
    Align("High stress", "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg")
)

val home = Home(favorites, bodyAligns, mindAligns)
