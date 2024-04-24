package com.derandecker.businesscarduipractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.sharp.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.derandecker.businesscarduipractice.ui.theme.BusinessCardUIPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardUIPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardMain()
                }
            }
        }
    }
}

@Composable
fun BusinessCardMain(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(modifier = modifier.height(32.dp))
        Detail()
    }
}

@Preview(showBackground = true)
@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = modifier.padding(bottom = 8.dp)
        )
        Text(text = stringResource(R.string.name))
        Text(text = stringResource(R.string.title))
    }
}

@Preview(showBackground = true)
@Composable
fun Detail(modifier: Modifier = Modifier) {
    Column() {
        DetailItem(icon = Icons.Filled.Call, text = R.string.phone)
        DetailItem(icon = Icons.Rounded.AccountCircle, text = R.string.social_media)
        DetailItem(icon = Icons.Sharp.CheckCircle, text = R.string.email)
    }
}

@Composable
fun DetailItem(modifier: Modifier = Modifier, icon: ImageVector, @StringRes text: Int) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Icon(modifier = Modifier.padding(end = 8.dp), imageVector = icon, contentDescription = "")
        Text(text = stringResource(id = text))
    }
}

@Preview(showBackground = true)
@Composable
fun DetailItemPreview() {
    DetailItem(icon = Icons.Filled.Call, text = R.string.phone)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardUIPracticeTheme {
        BusinessCardMain()
    }
}
