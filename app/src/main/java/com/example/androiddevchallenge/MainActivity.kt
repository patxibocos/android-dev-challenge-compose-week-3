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
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.util.firstBaselineToTop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Scaffold { paddingValues ->
        Login(Modifier.padding(paddingValues), isSystemInDarkTheme())
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme(darkTheme = false) {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun Welcome(modifier: Modifier = Modifier, darkTheme: Boolean = false) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_welcome else R.drawable.ic_light_welcome),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo),
                contentDescription = null,
            )
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(72.dp)
            ) {
                Text("SIGN UP")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(72.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text("LOG IN")
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier, darkTheme: Boolean = false) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_login else R.drawable.ic_light_login),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.firstBaselineToTop(200.dp),
                color = MaterialTheme.colors.onBackground,
            )
            TextField(
                value = "", onValueChange = { /*TODO*/ },
                placeholder = {
                    Text(
                        text = "Email address",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
//                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                },
                modifier = Modifier
                    .padding(top = 32.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                ),
                singleLine = true
            )
            TextField(
                value = "", onValueChange = { /*TODO*/ },
                placeholder = {
                    Text(
                        "Password",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface,
//                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(56.dp)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                ),
                singleLine = true
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(72.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("LOG IN")
            }
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
                modifier = Modifier.firstBaselineToTop(32.dp),
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Composable
fun Home() {

}
