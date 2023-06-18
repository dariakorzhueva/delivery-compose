package com.korzhueva.delivery.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.korzhueva.delivery.compose.ui.theme.DeliveryComposeTheme

@Composable
fun OnboardingScreen(navController: NavController) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_onboarding_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    DeliveryComposeTheme {
        OnboardingScreen(rememberNavController())
    }
}