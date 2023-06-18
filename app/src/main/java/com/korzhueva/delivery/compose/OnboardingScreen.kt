package com.korzhueva.delivery.compose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.korzhueva.delivery.compose.ui.theme.DeliveryComposeTheme

@Composable
fun OnboardingScreen(
    @DrawableRes
    onboardingDrawable: Int,
    @StringRes
    onboardingTitle: Int,
    @StringRes
    onboardingDescription: Int,
    onNext: (tag: String) -> Unit
) {
    Column {
        Image(
            painter = painterResource(id = onboardingDrawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            text = stringResource(onboardingTitle)
        )
        Text(
            text = stringResource(onboardingDescription),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 24.dp, bottom = 32.dp),
        )
        Button(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.light_green),
                contentColor = colorResource(id = R.color.white)
            ),
            shape = RoundedCornerShape(25),
            onClick = {
                onNext(NavigationRoute.Onboarding_2.tag)
            }) {
            Text(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp),
                fontSize = 24.sp,
                text = stringResource(R.string.next)
            )
        }
    }
}

@Composable
fun Onboarding1Screen(navController: NavController) {
    OnboardingScreen(
        onboardingDrawable = R.drawable.ic_onboarding_1,
        onboardingTitle = R.string.onboarding_first_page_title,
        onboardingDescription = R.string.onboarding_first_page_description,
        onNext = { navController.navigate(NavigationRoute.Onboarding_2.tag) }
    )
}

@Preview(showBackground = true)
@Composable
fun Onboarding1ScreenPreview() {
    DeliveryComposeTheme {
        Onboarding1Screen(rememberNavController())
    }
}

@Composable
fun Onboarding2Screen(navController: NavController) {
    OnboardingScreen(
        onboardingDrawable = R.drawable.ic_onboarding_2,
        onboardingTitle = R.string.onboarding_second_page_title,
        onboardingDescription = R.string.onboarding_second_page_description,
        onNext = { navController.navigate(NavigationRoute.Login.tag) }
    )
}

@Preview(showBackground = true)
@Composable
fun Onboarding2ScreenPreview() {
    DeliveryComposeTheme {
        Onboarding2Screen(rememberNavController())
    }
}
