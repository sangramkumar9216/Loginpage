package com.example.loginpage


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpage.ui.theme.Logo1
import com.example.loginpage.ui.theme.provider


val screenFont = GoogleFont("Karla")
val fontFamily = FontFamily(
        Font(googleFont = screenFont,
            fontProvider = provider,
            weight = FontWeight.Black,
        )
)

@Composable
fun SelectOption(){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(10.dp)
    ){
        ElevatedButton(onClick = {  },
            modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(Logo1)) {
            Text(text = "Sign in",
                fontFamily = fontFamily)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SelectOptionPreview(){
    SelectOption()
}