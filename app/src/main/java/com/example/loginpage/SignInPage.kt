package com.example.loginpage


import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun SignInScreen(navController: NavHostController){
    var loginid by rememberSaveable { mutableStateOf("") }
    var passwordl by rememberSaveable { mutableStateOf("") }

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
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Welcome back!", modifier = Modifier.padding(3.dp), fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = "Sign in to continue", modifier = Modifier.padding(10.dp),
            fontSize = 15.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(5.dp))
        TextField(value = loginid, onValueChange = {
            loginid =it
        },label = { Text(text = "Number or Email") },
            modifier = Modifier.background(MaterialTheme.colorScheme.background, shape = MaterialTheme.shapes.large))

        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = passwordl, onValueChange = {
            passwordl =it
        }, label = { Text(text = "Enter Password") },
            modifier = Modifier.background(MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.large))
        
        Spacer(modifier = Modifier.height(7.dp))
        ElevatedButton(onClick = {
            Log.i("Credential","loginid: $loginid Password: $passwordl")
        }, colors = ButtonDefaults.buttonColors(Logo1)) {
            Text(text = "Sign in")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Don't Have an Account?",
            fontSize = 17.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.clickable {
                navController.navigate("create_account")
            },
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Color.Blue)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Forgot password!", fontSize = 17.sp, fontWeight = FontWeight.Light,
            modifier = Modifier.clickable {  },
            style = TextStyle(textDecoration = TextDecoration.Underline),
            color = Color.Blue
        )
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
fun SignInScreenPreview(){
    SignInScreen(navController = rememberNavController())
}