package com.example.myapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditProfileScreen(sheetState: ModalBottomSheetState) {
	val coroutineScope = rememberCoroutineScope()
	val isNameReqVisible = remember { mutableStateOf(false) }
	val isAddressValidVisible = remember { mutableStateOf(false) }
	val isPhoneValidVisible = remember { mutableStateOf(false) }
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(colorResource(id = R.color.colorPrimary)),
		horizontalAlignment = Alignment.CenterHorizontally// Set the background color here
	) {
		// Content of the screen
		IconButton(
			onClick = { /* Handle button click */ },
			modifier = Modifier
				.size(80.dp)
				.padding(top = 15.dp)
		) {
			Image(
				modifier = Modifier
					.size(80.dp),
				painter = painterResource(R.drawable.ic_menu_profile), // Replace with your image resource
				contentDescription = "Edit Button"
			)
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 40.dp)
				.padding(start = 15.dp)
				.padding(end = 15.dp)
				.clip(RoundedCornerShape(50.dp))
				.background(colorResource(id = R.color.white))
		) {
			Icon(
				modifier = Modifier.padding(10.dp),
				painter = painterResource(id = R.drawable.ic_user),
				contentDescription = "Email Icon",
			)
			BasicTextField(
				value = GlobalState.textFieldValue,
				singleLine = true,
				onValueChange = { value ->
					GlobalState.textFieldValue = value
					GlobalState.isTextMatch = value.text == "DELETE" // Update the state based on the text match
				},
				decorationBox = { innerTextField ->
					Row(
						Modifier
							.padding(start = 5.dp)
					) {
						if (GlobalState.textFieldValue.text.isEmpty()) {
							Text("Name",
							color = colorResource(id = R.color.main_text_color))
						}
						innerTextField()
					}
				},
				textStyle = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.padding(horizontal = 32.dp, vertical = 10.dp)
					.fillMaxWidth(),
			)
		}
		if (isNameReqVisible.value) {
			Text(
				text = "*Name is required",
				color = colorResource(id = R.color.pink),
				modifier = Modifier
					.align(alignment = Alignment.Start)
					.padding(start = 25.dp)
			)
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 20.dp)
				.padding(start = 15.dp)
				.padding(end = 15.dp)
				.clip(RoundedCornerShape(50.dp))
				.background(colorResource(id = R.color.white))
		) {
			Icon(
				modifier = Modifier.padding(10.dp),
				painter = painterResource(id = R.drawable.ic_location),
				contentDescription = "Email Icon",
			)
			BasicTextField(
				value = GlobalState.textFieldValue,
				singleLine = true,
				onValueChange = { value ->
					GlobalState.textFieldValue = value
					GlobalState.isTextMatch = value.text == "DELETE" // Update the state based on the text match
				},
				decorationBox = { innerTextField ->
					Row(
						Modifier
							.padding(start = 5.dp)
					) {
						if (GlobalState.textFieldValue.text.isEmpty()) {
							Text("Enter your address",
								color = colorResource(id = R.color.main_text_color))
						}
						innerTextField()
					}
				},
				textStyle = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.padding(horizontal = 32.dp, vertical = 10.dp)
					.fillMaxWidth(),
			)
		}
		if (isAddressValidVisible.value) {
			Text(
				text = "*Address is not valid",
				color = colorResource(id = R.color.pink),
				modifier = Modifier
					.align(alignment = Alignment.Start)
					.padding(start = 25.dp)
			)
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 20.dp)
				.padding(start = 15.dp)
				.padding(end = 15.dp)
				.clip(RoundedCornerShape(50.dp))
				.background(colorResource(id = R.color.white))
		) {
			Icon(
				modifier = Modifier.padding(10.dp),
				painter = painterResource(id = R.drawable.ic_phone),
				contentDescription = "Email Icon",
			)
			BasicTextField(
				value = GlobalState.textFieldValue,
				singleLine = true,
				onValueChange = { value ->
					GlobalState.textFieldValue = value
					GlobalState.isTextMatch = value.text == "DELETE" // Update the state based on the text match
				},
				decorationBox = { innerTextField ->
					Row(
						Modifier
							.padding(start = 5.dp)
							.padding(end = 5.dp),
						verticalAlignment = Alignment.CenterVertically
					) {
						Image(
							painter = painterResource(id = R.drawable.ic_bd_flag),
							contentDescription = "Email Icon",
						)
						Text("+88",
							Modifier.padding(start = 5.dp).padding(end = 5.dp),
							color = colorResource(id = R.color.main_text_color))
						Image(
							painter = painterResource(id = R.drawable.ic_path_down_arrow),
							contentDescription = "Email Icon",
						)

						if (GlobalState.textFieldValue.text.isEmpty()) {
							Text("01xxxxxxxxx",
								Modifier.padding(start = 5.dp),
								color = colorResource(id = R.color.main_text_color))
						}
						innerTextField()
					}
				},
				textStyle = MaterialTheme.typography.titleMedium,
				modifier = Modifier
					.padding(horizontal = 32.dp, vertical = 10.dp)
					.fillMaxWidth(),
			)
		}
		if (isPhoneValidVisible.value) {
			Text(
				text = "*Phone is not valid",
				color = colorResource(id = R.color.pink),
				modifier = Modifier
					.align(alignment = Alignment.Start)
					.padding(start = 25.dp)
			)
		}

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 30.dp)
				.padding(15.dp),
			horizontalArrangement = Arrangement.Center,
		) {
			Button(
				colors = ButtonDefaults.buttonColors(
					containerColor = colorResource(id = R.color.colorPrimary),
					disabledContentColor = Color.Gray,
				),
				onClick = {
					coroutineScope.launch { sheetState.hide() }
				},
				modifier = Modifier
					.padding(10.dp)
					.weight(1f),
				border = BorderStroke(2.dp, colorResource(id = R.color.colorSecondaryDark))
			) {
				Text(
					text = "CANCEL",
					color = colorResource(id = R.color.colorSecondaryDark),
					maxLines = 1,
					fontSize = 13.sp
				)
			}

			Button(
				colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink)),
				onClick = {
					isNameReqVisible.value = true
					isAddressValidVisible.value = true
					isPhoneValidVisible.value = true
					},
				modifier = Modifier
					.padding(10.dp)
					.weight(1f),
			)
			{
				Text(
					text = "SAVE CHANGES",
					color = colorResource(id = R.color.white),
					maxLines = 1,
					fontSize = 13.sp
				)
			}

		}

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight()
				.padding(top = 10.dp)
				.padding(start = 15.dp)
				.padding(end = 15.dp),
			horizontalArrangement = Arrangement.Center
		) {
			Box(
				Modifier
					.weight(1f)
					.fillMaxWidth()
					.fillMaxHeight(),
				 Alignment.Center
			) {
				// Column 1 content
				Button(
					colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.colorPrimary)),
					onClick = { coroutineScope.launch { sheetState.show()}},
					modifier = Modifier
						.padding(16.dp)
				) {
					Text("DELETE PROFILE & DATA",
						color = colorResource(id = R.color.pink))
				}
			}
		}

	}
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ScreenPreviews() {
	val sheetState = rememberModalBottomSheetState(
		initialValue = ModalBottomSheetValue.Hidden,
		confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
	)
	EditProfileScreen(sheetState)
}