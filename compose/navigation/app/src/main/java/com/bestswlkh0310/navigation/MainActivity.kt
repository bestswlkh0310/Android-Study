package com.bestswlkh0310.navigation

import androidx.compose.runtime.remember

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
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
                    NavigationGraph()
                }
            }
        }
    }
}

enum class NAV_ROUTE(val routeName: String, val description: String) {
    HOME("HOME", "'나'는 누구인가"),
    IDK("IDK", "정말 모르겠어요")
}

class RouteAction(navHostController: NavHostController) {
    val navTo: (NAV_ROUTE) -> Unit = {
        navHostController.navigate(it.routeName)
    }

    val goBack: () -> Unit = {
        navHostController.navigateUp()
    }
}

@Composable
fun NavigationGraph(startRoute: NAV_ROUTE = NAV_ROUTE.HOME) {
    val navController = rememberNavController()
    val routeAction = remember(navController) { RouteAction(navController) }

    Log.d("TAG", "${NAV_ROUTE.HOME.routeName} - NavigationGraph() called")
    NavHost(navController, startRoute.routeName) {
        composable(NAV_ROUTE.HOME.routeName) {
            HomeView(routeAction = routeAction)
        }
        composable(NAV_ROUTE.IDK.routeName) {
            IdkScreen(routeAction = routeAction)
        }
    }
}


@Composable
fun HomeView(routeAction: RouteAction){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.padding(16.dp)) {
            NavButton(route = NAV_ROUTE.IDK, routeAction = routeAction)
        }
    }
}

@Composable
fun ColumnScope.NavButton(route: NAV_ROUTE, routeAction: RouteAction){
    Button(onClick = {
        routeAction.navTo(route)
    },colors = ButtonDefaults.buttonColors(contentColor = Color.Black),
        modifier = Modifier
            .weight(1f)
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(text = route.description,
            style = TextStyle(Color.White, 22.sp, FontWeight.Medium)
        )
    }
}

@Composable
fun IdkScreen(routeAction: RouteAction){
    Surface(Modifier.fillMaxSize()) {
        Box(Modifier.padding(8.dp), Alignment.Center){
            Text(text = "로그인 화면", style = TextStyle(Color.Black, 22.sp, FontWeight.Medium))
            Button(onClick = routeAction.goBack,
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y = 100.dp)) {
                Text("뒤로가기")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        NavigationGraph()
    }
}
