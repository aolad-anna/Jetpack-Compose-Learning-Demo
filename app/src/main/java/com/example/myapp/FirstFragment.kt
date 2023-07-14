package com.example.myapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue

object GlobalState {
    var textFieldValue by mutableStateOf(TextFieldValue())
    var isTextMatch by mutableStateOf(false)
    var isBottomSheetVisible by mutableStateOf(false)
}

@Composable
fun FirstFragment(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorSecondaryDark)) // Set the background color here
    ) {
        TopActionBar()
        Button(
            onClick = { navController.navigate("screen2") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Go to Screen 2")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopActionBar(){
    TopAppBar(
        title = {
            Text(text = "Toffee")
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Image(painter = painterResource(id = R.drawable.ic_toffee), contentDescription = "Back")
            }
        }
    )
}

@Preview
@Composable
fun FirstFragmentPreview() {
    val navController = rememberNavController()
    FirstFragment(navController)
}