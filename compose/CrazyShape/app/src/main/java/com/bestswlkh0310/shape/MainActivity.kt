package com.bestswlkh0310.shape

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bestswlkh0310.shape.ui.theme.ShapeTheme
import java.lang.Math.cos
import java.lang.Math.sin
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShapeContainer()
                }
            }
        }
    }
}

@Composable
fun DummyBox(modifier: Modifier = Modifier, color: Color? = null){
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    val randomColor = color ?: Color(red, green, blue)
    Box(modifier = modifier
        .size(200.dp)
        .background(randomColor))
}

@Composable
fun ShapeContainer(){
    var polySides by remember { mutableStateOf(3) }
    var a by remember { mutableStateOf(1) }
    var polyRadius by remember { mutableStateOf(100f) }
    var b by remember { mutableStateOf(1.1f) }
    var isButtonPressed by remember { mutableStateOf(false) }

    val buttonColors = Brush.horizontalGradient(listOf(Color.Yellow, Color.Red))

    RepeatedTask(intervalMillis = 10) {
        if (polySides > 20) a = -1
        if (polySides < 4) a = 1
        polySides += a

        if (polyRadius > 200) b = 0.9f
        if (polyRadius < 100) b = 1.1f

        polyRadius *= b
    }

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { DummyBox(modifier = Modifier.clip(PolyShape(polySides, polyRadius))) }
        item { DummyBox(modifier = Modifier.clip(PolyShape(polySides, polyRadius))) }
        item { DummyBox(modifier = Modifier.clip(PolyShape(polySides, polyRadius))) }
        item { DummyBox(modifier = Modifier.clip(PolyShape(polySides, polyRadius))) }
        item { DummyBox(modifier = Modifier.clip(PolyShape(polySides, polyRadius))) }
        item { DummyBox(modifier = Modifier.clip(PolyShape(polySides, polyRadius))) }
        item { Button(onClick = {}, modifier = Modifier
            .background(buttonColors)
            .size(200.dp), shape = PolyShape(polySides, polyRadius)) {
            Text(text = "이건 버튼이에요")
        } }
        item {
            val red = Random.nextInt(256)
            val green = Random.nextInt(256)
            val blue = Random.nextInt(256)
            val randomColor = Color(red, green, blue)
            Button(onClick = {
                isButtonPressed = !isButtonPressed
            }, modifier = Modifier
                .size(200.dp)
                .clip(PolyShape(polySides, polyRadius)),
            colors = ButtonDefaults.buttonColors(if (isButtonPressed) randomColor else Color.Black),
            ) {
                Text(
                    text = "날 클릭해봐!",
                    fontSize = 20.sp
                )
            }
        }
    }
}

class PolyShape(private val sides: Int, private val radius: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(path = Path().apply { this.polygon(sides, radius, size.center) })
    }
}


fun Path.polygon(sides: Int, radius: Float, center: Offset) {
    val angle = 2.0 * Math.PI / sides
    moveTo(
        x = center.x + (radius * kotlin.math.cos(0.0)).toFloat(),
        y = center.y + (radius * kotlin.math.sin(0.0)).toFloat()
    )
    for (i in 1 until sides) {
        lineTo(
            x = center.x + (radius * cos(angle * i)).toFloat(),
            y = center.y + (radius * sin(angle * i)).toFloat()
        )
    }
    close()
}

@Composable
fun RepeatedTask(intervalMillis: Long, task: () -> Unit) {
    val handler = remember { Handler(Looper.getMainLooper()) }

    DisposableEffect(Unit) {
        val runnable = object : Runnable {
            override fun run() {
                task()
                handler.postDelayed(this, intervalMillis)
            }
        }

        handler.postDelayed(runnable, intervalMillis)

        onDispose {
            handler.removeCallbacks(runnable)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShapeTheme {
        ShapeContainer()
    }
}