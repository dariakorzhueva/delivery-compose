package com.korzhueva.delivery.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.korzhueva.delivery.compose.ui.theme.DeliveryComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Splash.tag
    ) {
        composable(NavigationRoute.Splash.tag) {
            SplashScreen(navController = navController)
        }
        composable(NavigationRoute.Onboarding_1.tag) {
            Onboarding1Screen(navController = navController)
        }
        composable(NavigationRoute.Onboarding_2.tag) {
            Onboarding2Screen(navController = navController)
        }
        composable(NavigationRoute.Login.tag) {
        }
    }
}

val LightGreen: Color
    @Composable
    get() = Color(0xFF53E88B)

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    DeliveryComposeTheme {
        SplashScreen(rememberNavController())
    }
}