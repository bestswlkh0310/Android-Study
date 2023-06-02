package com.example.factorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.factorial.ui.theme.ComposePracticeTheme
import com.example.factorial.util.Calculator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    if (shouldShowOnboarding) {
        OnBoardingScreen { shouldShowOnboarding = !shouldShowOnboarding }
    } else {
        Greetings()
    }
}

@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Text(
                        text = "클릭해 봐",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }
                items(names) { name ->
                        Greeting(name)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
    val isExpanded= remember {
        mutableStateOf(false)
    }
    Card(
        colors = CardDefaults.cardColors (
            contentColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        onClick = { isExpanded.value = !isExpanded.value }
    ) {
        CardContent(name = name, isExpanded)
    }
}

@Composable
fun CardContent(name: String, isExpanded: MutableState<Boolean>) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 12.dp)
        ) {
            Text(text = "Hello,")
            Text(
                text = "$name!",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            if (isExpanded.value) {
                Text(text = Calculator.factorial(name.toInt()).toString())
            }
        }
        IconButton(
            onClick = { isExpanded.value = !isExpanded.value },
        ) {
            Icon(
                painter = if (isExpanded.value) painterResource(R.drawable.expand_less_24 ) else painterResource(R.drawable.expand_more_24 ),
                contentDescription = if (isExpanded.value) stringResource(R.string.show_less) else stringResource(R.string.show_more)
            )
        }
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Swift is best language")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}
@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun OnBoardingPreview() {
    ComposePracticeTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        MyApp()
        Greetings()
    }
}