package com.plcoding.woox.ui.screens.loginscreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.plcoding.woox.common.theme.fonts
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.plcoding.woox.R
import com.plcoding.woox.common.Constants.USER_AUTHENTICATE
import com.plcoding.woox.ui.componts.CustomButton
import com.plcoding.woox.common.theme.CreamColor
import com.plcoding.woox.ui.screens.bottomnav.BottomBar

@Composable
fun LoginScreen(
    navHostController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    var emailId by remember { mutableStateOf(TextFieldValue("adecstudent1")) }
    var password by remember { mutableStateOf(TextFieldValue("12345678")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.loginResponse.let {
           // it.records.
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = null, // provide content description if needed
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent), // make the image background transparent
                contentScale = ContentScale.FillBounds // scale the image to fill the Box
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 30.dp, 20.dp, 10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                val outlinedTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    cursorColor = Color.Black,
                    textColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                )
                LazyColumn(
                    modifier = Modifier
                        .height(420.dp)
                        .padding(0.dp, 50.dp, 0.dp, 0.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        LazyColumn(
                            modifier = Modifier
                                .height(280.dp)
                                .fillMaxWidth()
                                .background(
                                    color = CreamColor,
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .padding(20.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                OutlinedTextField(
                                    value = emailId,
                                    onValueChange = { emailId = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),
                                    label = {
                                        Text(
                                            text = stringResource(id = R.string.username),
                                            fontFamily = fonts
                                        )
                                    },
                                    singleLine = true,
                                    placeholder = {
                                        Text(
                                            text = stringResource(id = R.string.enter_your_username),
                                            fontFamily = fonts
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                    textStyle = androidx.compose.ui.text.TextStyle(fontFamily = fonts),
                                    colors = outlinedTextFieldColors
                                )
                                Spacer(modifier = Modifier.height(15.dp))

                                OutlinedTextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),
                                    label = {
                                        Text(
                                            text = stringResource(id = R.string.password),
                                            fontFamily = fonts
                                        )
                                    },
                                    singleLine = true,
                                    placeholder = {
                                        Text(
                                            text = stringResource(id = R.string.enter_your_password),
                                            fontFamily = fonts
                                        )
                                    },
                                    visualTransformation = if (passwordVisible) VisualTransformation.None else
                                        PasswordVisualTransformation(),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                                    textStyle = androidx.compose.ui.text.TextStyle(fontFamily = fonts),
                                    trailingIcon = {
                                        val image = if (passwordVisible) Icons.Filled.Visibility
                                        else Icons.Filled.VisibilityOff
                                        // Please provide localized description for accessibility services
                                        val description =
                                            if (passwordVisible) "Hide password" else "Show password"
                                        IconButton(onClick = {
                                            passwordVisible = !passwordVisible
                                        }) {
                                            Icon(imageVector = image, description)
                                        }
                                    },
                                    colors = outlinedTextFieldColors
                                )

                            }
                        }
                        CustomButton(
                            name = stringResource(id = R.string.login),
                            onButtonClick = {
                                if (emailId.text.isNullOrEmpty() && password.text.isNullOrEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter correct detail.",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                } else {
                                    viewModel.getLogin(USER_AUTHENTICATE + "adecstudent1")
                                }
                            },
                            paddingTop = 10,
                            paddingHorizontal = 30,
                            modifier = Modifier.height(90.dp)
                        )

                    }
                }

            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }

}

@Composable
@Preview
fun BottomNavPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}