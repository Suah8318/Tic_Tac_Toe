package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.TicTacToeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                New_Screen()
            }
        }
    }
}

@Composable
fun New_Screen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Card(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(2.dp),
                elevation = CardDefaults.cardElevation(30.dp),
                colors = CardDefaults.cardColors(Color.Gray),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Card(colors = CardDefaults.cardColors(Color.LightGray)) {
                        Text(
                            "Tic Tac Toe",
                            fontSize = 37.sp,
                            modifier = Modifier.padding(7.dp),
                            color = Color.Black
                        )
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(10.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Box(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
                    .drawBehind {
                        // Access to the Canvas and size
                        val canvasWidth = size.width
                        val canvasHeight = size.height

                        // Example: Drawing a simple line
                        drawLine(
                            color = Color.Black,
                            start = Offset(canvasWidth * 1 / 3, 0f),
                            end = Offset(canvasWidth * 1 / 3, canvasHeight),
                            strokeWidth = 5f
                        )
                        drawLine(
                            color = Color.Black,
                            start = Offset(canvasWidth * 2 / 3, 0f),
                            end = Offset(canvasWidth * 2 / 3, canvasHeight),
                            strokeWidth = 5f
                        )
                        drawLine(
                            color = Color.Black,
                            start = Offset(0f, canvasHeight * 1 / 3),
                            end = Offset(canvasWidth, canvasHeight * 1 / 3),
                            strokeWidth = 5f
                        )
                        drawLine(
                            color = Color.Black,
                            start = Offset(0f, canvasHeight * 2 / 3),
                            end = Offset(canvasWidth, canvasHeight * 2 / 3),
                            strokeWidth = 5f
                        )
                    }) {
                    GridBoxes()
                }

//                Canvas() { }
            }

            Box(
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(60.dp)
                        .width(200.dp),
//                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text("New Game", fontSize = 30.sp)
                }
            }
        }
    }
}

@Composable
fun GridBoxes() {

    var currentPlayer by remember { mutableStateOf("X") }
//    var count by remember { mutableIntStateOf(4) }
//    var board by remember { mutableStateOf(listOf("", "", "", "", "", "", "", "", "")) }
    val board = remember { mutableStateListOf("", "", "", "", "", "", "", "", "") }
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[0] == "") {
                            board[0] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[1] == "") {
                            board[1] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[2] == "") {
                            board[2] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[3] == "") {
                            board[3] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[4] == "") {
                            board[4] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[5] == "") {
                            board[5] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[6] == "") {
                            board[6] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[7] == "") {
                            board[7] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        if (board[8] == "") {
                            board[8] = currentPlayer
                            currentPlayer = if (currentPlayer == "X") "O"
                            else "X"
                        }
                    }
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TicTacToeTheme {
        New_Screen()
    }
}