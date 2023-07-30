package com.bestswlkh0310.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bestswlkh0310.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {

}

enum class NAV_ROUTE(val routeName: String, val description: String) {
    HOME("제가 누군지 아시나요??", "'나'는 누구인가"),
    IDK("내가 어떻게 알아 이 자식아", "정말 모르겠어요")
}

class RouteAction(navHostController: NavHostController) {
    val navTo: (NAV_ROUTE) -> Unit = {
        navHostController.navigate(it)
    }

    val goBack: () -> Unit = {
        navHostController.navigateUp()
    }
}

@Composable
fun NavigationGraph(startRoute: String = NAV_ROUTE = NAV_ROUTE.HOME) {
    val navController = rememberNavController()

    val routeAction = remember(navController) {
        NavHost(navController, startRoute) {
            
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        App()
    }
}