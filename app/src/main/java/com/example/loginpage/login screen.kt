package com.example.loginpage

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginpage.ui.theme.Logo1
import com.example.loginpage.ui.theme.colo2
import com.example.loginpage.ui.theme.color1


@Composable
fun LoginScreen(
    navController: NavHostController
){

    var name by rememberSaveable {
        mutableStateOf("")
    }
    var number by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var confirmPassword by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(color1, colo2)
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.listlog),
            contentDescription ="Login Image",
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Welcome to the app!", modifier = Modifier.padding(3.dp), fontSize = 25.sp, fontWeight = FontWeight.Bold)
        
        Text(text = "Create new account", modifier = Modifier.padding(10.dp), fontSize = 15.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = name, onValueChange = {
            name = it
        }, label = {Text(text = "Name")}, modifier = Modifier.background(MaterialTheme.colorScheme.background, shape = MaterialTheme.shapes.large) )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = number, onValueChange = {
            number = it
        }, label = {Text(text = "Number or Email")}, modifier = Modifier.background(MaterialTheme.colorScheme.background, shape = MaterialTheme.shapes.large) )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = password, onValueChange = {
            password = it
        }, label = {Text(text = "Password")},
            modifier = Modifier.background(MaterialTheme.colorScheme.background,shape = MaterialTheme.shapes.large),
            visualTransformation = PasswordVisualTransformation(),
            )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(value = confirmPassword, onValueChange = {
            confirmPassword = it
        }, label = {Text(text = "Confirm Password")},
            modifier = Modifier.background(MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.large),
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(12.dp))
        ElevatedButton(onClick = {
            Log.i("Credential","name: $name Password: $password Number: $number Confirm Password: $confirmPassword")
        }, colors = ButtonDefaults.buttonColors(Logo1)) {
            Text(text = "Sign up")
        }
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = "Already have an account?",
            fontSize = 17.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.clickable {
                navController.navigate("existing_account")
            },
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = "Forgot password!", fontSize = 17.sp, fontWeight = FontWeight.Light,
            modifier = Modifier.clickable {  },
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "or Sign in with")
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Image(painter = painterResource(id = R.drawable.google),
                contentDescription = "Google login",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { })
            Spacer(modifier = Modifier.width(15.dp))
            Image(painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Twiter login",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { })
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(navController = rememberNavController())
}

