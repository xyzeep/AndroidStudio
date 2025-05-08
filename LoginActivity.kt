package com.example.animation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                LoginBody()
        }
    }
}

@Composable
fun AlertDialogBody() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        // Trigger to show the dialog
        Button(onClick = { showDialog = true }) {
            Text("Show AlertDialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                }, // dismiss when clicked outside
                confirmButton = {
                    Button(onClick = {
                        // Confirm action
                        showDialog = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    Button(onClick = {
                        // Cancel action
                        showDialog = false
                    }) {
                        Text("Cancel")
                    }
                },
                title = { Text(text = "Alert Title") },
                text = { Text("This is an alert dialog message.") }
            )
        }
    }
}

@Composable
fun LoginBody() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember {mutableStateOf(false)}
    var rememberMe by remember {mutableStateOf(false)}

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current
    Scaffold (
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(R.drawable.login_img),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            //email
            OutlinedTextField(
                value = email,
                onValueChange = { input ->
                    email = input
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(12.dp),
                prefix = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text("abc@gmail.com")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Gray.copy(0.2f)
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            // password
            OutlinedTextField(
                value = password,
                onValueChange = { input ->
                    password = input
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(12.dp),
                prefix = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                suffix = {
                    Icon(
                        painter = painterResource(
                            if (passwordVisibility) R.drawable.baseline_remove_red_eye_24 else R.drawable.baseline_visibility_off_24
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                passwordVisibility = !passwordVisibility
                            }
                    )
                },
                placeholder = {
                    Text("Password")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Gray.copy(0.2f)
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = {
                            rememberMe = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Green,
                            checkmarkColor = Color.White
                        )
                    )

                    Text("Remember me")
                }
                Text("Forgot Password?", Modifier.padding(10.dp))
            }

            Button(
                onClick = {
                    if (email == "pawan@gmail.com" && password == "password") {
                        Toast.makeText(
                            context,
                            "Login Success",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        Toast.makeText(context, "Invalid Login", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .width(200.dp)
            ) {
                Text(text = "Login")
            }

            Spacer(Modifier.height(10.dp))

            Text(text = "User other methods")
            Spacer(Modifier.height(10.dp))
            Row {
                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(Modifier.width(10.dp))
                Image(
                    painter = painterResource(R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(Modifier.height(10.dp))

            Button(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Hello, world!")
                }
            }) {
                Text("Show Snackbar")
            }


                AlertDialogBody()



        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    LoginBody()
}