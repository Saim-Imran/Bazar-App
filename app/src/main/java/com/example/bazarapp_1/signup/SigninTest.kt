package com.example.bazarapp_1.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily
import java.util.Locale


@Composable
fun BoxTest(modifier: Modifier = Modifier) {
   Column (modifier = Modifier){
       Row (modifier=Modifier.fillMaxWidth()
           .padding(16.dp),
           horizontalArrangement = Arrangement.SpaceEvenly, ){

           Box(
               modifier = Modifier
                   .size(width = 140.dp, height = 160.dp)
                   .background(
                       color = Color(0xff54408C),
                       shape = RoundedCornerShape(12.dp)
                   ),

               contentAlignment = Alignment.Center
           ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {

                   Text(
                       text = "50%\nOFF",
                       lineHeight = 35.sp,
                       color = Color.White,
                       fontSize = 32.sp,

                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 4.dp)
                   )


                   Button(
                       onClick = { },
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White
                       ),
                       modifier = Modifier.padding(4.dp)
                   ) {
                       Text(
                           text = "Copy",
                           color = Color(0xff54408C),
                           fontSize = 14.sp
                       )
                   }
               }
           }
           // 2nd box in row

           Box(
               modifier = Modifier
                   .size(width = 140.dp, height = 160.dp)
                   .background(
                       color = Color(0xffF5BE00),
                       shape = RoundedCornerShape(12.dp)
                   ),

               contentAlignment = Alignment.Center
           ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {

                   Text(
                       text = "23%\nOFF",
                       lineHeight = 35.sp,
                       color = Color.White,
                       fontSize = 32.sp,

                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 4.dp)
                   )


                   Button(
                       onClick = { },
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White
                       ),
                       modifier = Modifier.padding(4.dp)
                   ) {
                       Text(
                           text = "Copy",
                           color = Color(0xffF5BE00),
                           fontSize = 14.sp
                       )
                   }
               }
           }
       }
   //2nd row
       Row (modifier=Modifier.fillMaxWidth()
           .padding(16.dp),
           horizontalArrangement = Arrangement.SpaceEvenly, ){

           Box(
               modifier = Modifier
                   .size(width = 140.dp, height = 160.dp)
                   .background(
                       color = Color(0xff3784FB),
                       shape = RoundedCornerShape(12.dp)
                   ),

               contentAlignment = Alignment.Center
           ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {

                   Text(
                       text = "50%\nOFF",
                       lineHeight = 35.sp,
                       color = Color.White,
                       fontSize = 32.sp,

                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 4.dp)
                   )


                   Button(
                       onClick = { },
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White
                       ),
                       modifier = Modifier.padding(4.dp)
                   ) {
                       Text(
                           text = "Copy",
                           color = Color(0xff3784FB),
                           fontSize = 14.sp
                       )
                   }
               }
           }
           // 2nd box in 2nd row

           Box(
               modifier = Modifier
                   .size(width = 140.dp, height = 160.dp)
                   .background(
                       color = Color(0xffFF8C39),
                       shape = RoundedCornerShape(12.dp)
                   ),

               contentAlignment = Alignment.Center
           ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {

                   Text(
                       text = "23%\nOFF",
                       lineHeight = 35.sp,
                       color = Color.White,
                       fontSize = 32.sp,

                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 4.dp)
                   )


                   Button(
                       onClick = { },
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White
                       ),
                       modifier = Modifier.padding(4.dp)
                   ) {
                       Text(
                           text = "Copy",
                           color = Color(0xffFF8C39),
                           fontSize = 14.sp
                       )
                   }
               }
           }
       }
       //column
       Row (modifier=Modifier.fillMaxWidth()
           .padding(16.dp),
           horizontalArrangement = Arrangement.SpaceEvenly, ){

           Box(
               modifier = Modifier
                   .size(width = 140.dp, height = 160.dp)
                   .background(
                       color = Color(0xff121212),
                       shape = RoundedCornerShape(12.dp)
                   ),

               contentAlignment = Alignment.Center
           ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {

                   Text(
                       text = "50%\nOFF",
                       lineHeight = 35.sp,
                       color = Color.White,
                       fontSize = 32.sp,

                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 4.dp)
                   )


                   Button(
                       onClick = { },
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White
                       ),
                       modifier = Modifier.padding(4.dp)
                   ) {
                       Text(
                           text = "Copy",
                           color = Color(0xff121212),
                           fontSize = 14.sp
                       )
                   }
               }
           }
           // 2nd box in row

           Box(
               modifier = Modifier
                   .size(width = 140.dp, height = 160.dp)
                   .background(
                       color = Color(0xff34A853),
                       shape = RoundedCornerShape(12.dp)
                   ),

               contentAlignment = Alignment.Center
           ) {
               Column(horizontalAlignment = Alignment.CenterHorizontally) {

                   Text(
                       text = "23%\nOFF",
                       lineHeight = 35.sp,
                       color = Color.White,
                       fontSize = 32.sp,

                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(bottom = 4.dp)
                   )


                   Button(
                       onClick = { },
                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.White
                       ),
                       modifier = Modifier.padding(4.dp)
                   ) {
                       Text(
                           text = "Copy",
                           color = Color(0xff34A853),
                           fontSize = 14.sp
                       )
                   }
               }
           }
       }
       //column
   }
}


@Preview
@Composable
fun ButtonPreview() {
    BazarApp_1Theme {
//SearchView()
        BoxTest()
    }
}
