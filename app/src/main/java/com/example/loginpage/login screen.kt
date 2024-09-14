package com.example.loginpage

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun LoginScreen(){

    var name by remember {
        mutableStateOf("")
    }
    var number by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ppimg), contentDescription ="Login Image", modifier = Modifier.size(250.dp) )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Welcome to the app!", modifier = Modifier.padding(3.dp), fontSize = 25.sp, fontWeight = FontWeight.Bold)
        
        Text(text = "Create new account", modifier = Modifier.padding(10.dp), fontSize = 15.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = name, onValueChange = {
            name = it
        }, label = {Text(text = "Name")}, )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = number, onValueChange = {
            number = it
        }, label = {Text(text = "Number or Email")}, )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = confirmPassword, onValueChange = {
            confirmPassword = it
        }, label = {Text(text = "Confirm Password")},
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(12.dp))
        ElevatedButton(onClick = {
            Log.i("Credential","name: $name Password: $password Number: $number Confirm Password: $confirmPassword")
        }) {
            Text(text = "Sign up")
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = "Already have an account?", fontSize = 17.sp, fontWeight = FontWeight.Light, modifier = Modifier.clickable {  } )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Forgot password!", fontSize = 17.sp, fontWeight = FontWeight.Light, modifier = Modifier.clickable {  } )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Or signin with")
        Spacer(modifier = Modifier.height(2.dp))
        Row {
            Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google login",
                modifier = Modifier
                    .size(35.dp)
                    .clickable { })
            Spacer(modifier = Modifier.width(15.dp))
            Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "Google login",
                modifier = Modifier
                    .size(35.dp)
                    .clickable { })

        }


    }



}


