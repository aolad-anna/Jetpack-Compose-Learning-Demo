package com.example.myapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun BottomSheetContent() {
	Header()
	TextViewTitle()
	TextView1()
	TextView2()
	TextView3()
	DeleteTextField()
	DeleteButton()
}
@Composable
fun Header(){
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		Box(
			Modifier
				.height(8.dp)
				.width(50.dp)
				.clip(RoundedCornerShape(50.dp))
				.background(colorResource(id = R.color.cardTitleColor)),
			Alignment.Center
		) {
			// Column 1 content
		}
	}
}

@Composable
fun ThreeColumnRow() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(15.dp),
		horizontalArrangement = Arrangement.Center,
	) {
		Box(
			Modifier.weight(1f),
			Alignment.Center
		) {
			// Column 1 content
			Text(
				text = "Column 1",
				fontSize = 16.sp
			)
		}
		Box(
			Modifier.weight(1f),
			Alignment.Center
		) {
			// Column 2 content
			Text(
				text = "Column 2",
				fontSize = 16.sp
			)
		}
		Box(
			Modifier.weight(1f),
			Alignment.Center
		) {
			// Column 3 content
			Text(
				text = "Column 3",
				fontSize = 16.sp
			)
		}
	}
}

@Composable
fun TextViewTitle() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		Box(
			Modifier.weight(1f),
			Alignment.Center
		) {
			// Column 1 content
			Text(
				text = "Delete Profile & Data",
				style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
				fontSize = 20.sp,
				color = colorResource(id = R.color.main_text_color)
			)
		}
	}
}

@Composable
fun TextView1() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 5.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		Box(
			Modifier.weight(1f),
			Alignment.Center
		) {
			// Column 1 content
			Text(
				text = "If you wish to proceed, your profile and data (identification data, channel data, and activities) will deleted permanently. If you have subscribed to any premium content, you will lose access to it. ",
				fontSize = 12.sp,
				color = colorResource(id = R.color.main_text_color)
			)
		}
	}
}

@Composable
fun TextView2() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		Box(
			Modifier.weight(1f),
			Alignment.Center
		) {
			// Column 1 content
			Text(
				text = "You can open a fresh new account with the same mobile number, or continue to enjoy the free content on Toffee without signing in.",
				fontSize = 12.sp,
				color = colorResource(id = R.color.main_text_color)
			)
		}
	}
}

@Composable
fun TextView3() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		Box(
			Modifier.weight(1f),
		) {
			// Column 1 content
			Text(
				text = "Type DELETE if you are sure you want to continue",
				fontSize = 12.sp,
				color = colorResource(id = R.color.main_text_color)
			)
		}
	}
}

@Composable
fun DeleteTextField() {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp)
			.clip(RoundedCornerShape(50.dp))
			.background(colorResource(id = R.color.cardTitleColor))
	) {
		BasicTextField(
			value = GlobalState.textFieldValue,
			singleLine = true,
			onValueChange = { value ->
				GlobalState.textFieldValue = value
				GlobalState.isTextMatch = value.text == "DELETE" // Update the state based on the text match
			},
			textStyle = MaterialTheme.typography.titleMedium,
			modifier = Modifier
				.padding(horizontal = 16.dp, vertical = 8.dp)
				.fillMaxWidth(),
		)

	}
}

@Composable
fun DeleteButton() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		if (GlobalState.isTextMatch) {
			Button(
				colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.pink)),
				enabled = GlobalState.isTextMatch,
				onClick = { GlobalState.isBottomSheetVisible = true },
				modifier = Modifier
					.fillMaxWidth()
			)
			{
				Text(
					text = "DELETE EVERYTHING",
					color = colorResource(id = R.color.white)
				)
			}
		} else {
			Button(
				colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.cardTitleColor)),
				enabled = !GlobalState.isTextMatch,
				onClick = {

				},
				modifier = Modifier
					.fillMaxWidth()
			) {
				Text(
					text = "DELETE EVERYTHING",
					color = colorResource(id = R.color.colorSecondaryDark)
				)
			}
		}
	}
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CancelButton(sheetState: ModalBottomSheetState) {
	val coroutineScope = rememberCoroutineScope()
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
			.padding(start = 15.dp)
			.padding(end = 15.dp),
		horizontalArrangement = Arrangement.Center
	) {
		Button(
			colors = ButtonDefaults.buttonColors(
				containerColor = colorResource(id = R.color.colorSecondaryDark),
				disabledContentColor = Color.Gray,
			),
			onClick = {
				coroutineScope.launch { sheetState.hide() }
			},
			modifier = Modifier
				.fillMaxWidth(),
			border = BorderStroke(2.dp, colorResource(id = R.color.main_text_color))
		) {
			Text(
				text = "CANCEL",
				color = colorResource(id = R.color.main_text_color)
			)
		}
	}
}

@Preview
@Composable
fun BottomSheetContentPreview() {
	BottomSheetContent()
}