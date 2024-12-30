package com.example.bazarapp_1.onBoarding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bazarapp_1.LoginPage
import com.example.bazarapp_1.R
import com.example.bazarapp_1.ui.theme.BazarApp_1Theme
import com.example.bazarapp_1.ui.theme.robotofontfamily

@Composable
fun IntroScreen(navController: NavHostController) {
  Column(modifier = Modifier.background(color = Color.White
  )) {
      Column(modifier = Modifier.weight(.8f)) {
          LazyRow(
              modifier = Modifier
                  .fillMaxSize()
                  .background(Color.White)

          ) {
              item { OnBoardingScreen1() }
              item { OnBoardingScreen2() }
              item { OnBoardingScreen3(navController = navController) }
          }
      }
      // new column
      Column(modifier = Modifier.weight(.1f)) {
          ButtonFun(
              modifier = Modifier.background(color = Color.White),
              navController = navController
          )
      }
  }
}

@Composable
fun OnBoardingScreen1(modifier: Modifier = Modifier) {
   Box(modifier = Modifier.fillMaxSize()){
       Column(
           modifier = modifier
               .background(Color.White)
               .padding(16.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
          Box (modifier = Modifier){
              Image(
                  painter = painterResource(R.drawable.board_read1),
                  contentDescription = "OnBoardingScreen1 Image",
                  modifier = Modifier
                      .width(370.dp)
                      .padding(top = 10.dp)
                      .align(Alignment.Center)
              )
          }
           Text(
               text = "Now reading books\nwill be easier",
               color = Color.Black,
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold,
               fontFamily = robotofontfamily,
               textAlign = TextAlign.Center,
               modifier = Modifier
                   .padding(top = 30.dp)
                   .align(Alignment.CenterHorizontally)
           )
           Text(
               text = "Discover new worlds, join a vibrant\nreading community. Start your reading\nadventure effortlessly with us.",
               color = Color(0xffA6A6A6),
               lineHeight = 24.sp,

               fontSize = 16.sp,
               fontFamily = robotofontfamily,
               modifier = Modifier
                   .padding(top = 20.dp)
                   .align(Alignment.CenterHorizontally)
           )

       }
   }
}

@Composable
fun OnBoardingScreen2(modifier: Modifier = Modifier.fillMaxSize()) {
   Box (modifier = Modifier.fillMaxSize()){  Column(
       modifier = modifier
           .background(Color.White)
           .padding(16.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {

       Box(modifier = Modifier) {
           Image(
           painter = painterResource(R.drawable.board_read2),
           contentDescription = "OnBoardingScreen2 Image",
           modifier = Modifier
               .width(370.dp)
               .padding(top = 10.dp)
               .align(Alignment.Center)
       ) }
       Text(
           text = "Your Bookish Soulmate\nAwaits",
           color = Color.Black,
           fontSize = 24.sp,
           fontWeight = FontWeight.Bold,
           fontFamily = robotofontfamily,
           textAlign = TextAlign.Center,
           modifier = Modifier
               .padding(top = 30.dp)
               .align(Alignment.CenterHorizontally)
       )
       Text(
           text = "Let us be the guide to the perfect read.\nDiscover books tailored to your tastes\nfor a truly rewarding experience.",
           color = Color(0xffA6A6A6),
           lineHeight = 24.sp,
           fontSize = 16.sp,
           fontFamily = robotofontfamily,
           modifier = Modifier
               .padding(top = 20.dp)
               .align(Alignment.CenterHorizontally)
       )

   } }
}

@Composable
fun OnBoardingScreen3(navController: NavHostController, modifier: Modifier = Modifier.fillMaxSize()) {
   Box(modifier = Modifier.fillMaxSize()) {  Column(
       modifier = modifier
           .background(Color.White)
           .padding(16.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
     Box(modifier = Modifier) {   Image(
         painter = painterResource(R.drawable.board_read3),
         contentDescription = "OnBoardingScreen3 Image",
         modifier = Modifier
             .width(370.dp)
             .padding(top = 10.dp)
             .align(Alignment.Center)
     ) }
       Text(
           text = "Start your Adventure",
           color = Color.Black,
           fontSize = 24.sp,
           fontWeight = FontWeight.Bold,
           fontFamily = robotofontfamily,
           textAlign = TextAlign.Center,
           modifier = Modifier
               .padding(top = 30.dp)
               .align(Alignment.CenterHorizontally)
       )
       Text(
           text = "Ready to embark on a quest for\ninspiration and knowledge? Your\nadventure begins now. Let's go!",
           color = Color(0xffA6A6A6),
           lineHeight = 24.sp,
           fontSize = 16.sp,
           fontFamily = robotofontfamily,
           modifier = Modifier
               .padding(top = 20.dp)
               .align(Alignment.CenterHorizontally)
       )

   } }
}

@Composable
fun ButtonFun(modifier: Modifier = Modifier,navController: NavHostController) {
   Box(modifier = Modifier.background(color = Color.White).padding(vertical = 5.dp)) {  Button(
       onClick = { navController.navigate(LoginPage) },
       modifier = Modifier
           .fillMaxWidth()
           .padding(top = 0.dp, start = 15.dp, end = 15.dp , bottom = 0.dp)
           .height(60.dp),
       shape = RoundedCornerShape(12.dp),
       colors = ButtonDefaults.buttonColors(containerColor = Color(0xff54408C))
   ) {
       Text(text = "Get Started 👋", fontSize = 16.sp, fontFamily = robotofontfamily)
   } }
}
@Preview
@Composable
fun PreviewOnBoardingLazyColumn() {
    BazarApp_1Theme {
        IntroScreen(navController = rememberNavController())
    }
}