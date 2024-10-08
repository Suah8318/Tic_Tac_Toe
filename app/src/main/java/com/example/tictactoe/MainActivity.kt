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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        val board = remember { mutableStateListOf("", "", "", "", "", "", "", "", "") }
        var topBarText by remember { mutableStateOf("Tic Tac Toe") }
        var currentPlayer by remember { mutableStateOf("X") }
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
                        topBarText,
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
            val t = checkBoard(board)
            if (t.bol) {
                topBarText = if (currentPlayer == "X") "O Won"
                else "X Won"
            } else {
                var f = false
                for (i in board) {
                    if (i == "") {
                        f = true
                        break
                    }
                }
                if (!f) {
                    topBarText = "Draw"
                }
            }
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
                    if (t.bol) {
                        val a = t.winPosition[0]
                        val b = t.winPosition[1]
                        val c = t.winPosition[2]
                        if (a == 0 && b == 1 && c == 2)
                            drawLine(
                                color = Color.Red,
                                start = Offset(0f, canvasHeight * 1 / 6),
                                end = Offset(canvasWidth, canvasHeight * 1 / 6),
                                strokeWidth = 10f
                            )
                        else if (a == 3 && b == 4 && c == 5)
                            drawLine(
                                color = Color.Red,
                                start = Offset(0f, canvasHeight * 3 / 6),
                                end = Offset(canvasWidth, canvasHeight * 3 / 6),
                                strokeWidth = 10f
                            )
                        else if (a == 6 && b == 7 && c == 8)
                            drawLine(
                                color = Color.Red,
                                start = Offset(0f, canvasHeight * 5 / 6),
                                end = Offset(canvasWidth, canvasHeight * 5 / 6),
                                strokeWidth = 10f
                            )
                        else if (a == 0 && b == 3 && c == 6)
                            drawLine(
                                color = Color.Red,
                                start = Offset(canvasWidth * 1 / 6, 0f),
                                end = Offset(canvasWidth * 1 / 6, canvasHeight),
                                strokeWidth = 10f
                            )
                        else if (a == 1 && b == 4 && c == 7)
                            drawLine(
                                color = Color.Red,
                                start = Offset(canvasWidth * 3 / 6, 0f),
                                end = Offset(canvasWidth * 3 / 6, canvasHeight),
                                strokeWidth = 10f
                            )
                        else if (a == 2 && b == 5 && c == 8)
                            drawLine(
                                color = Color.Red,
                                start = Offset(canvasWidth * 5 / 6, 0f),
                                end = Offset(canvasWidth * 5 / 6, canvasHeight),
                                strokeWidth = 10f
                            )
                        else if (a == 0 && b == 4 && c == 8)
                            drawLine(
                                color = Color.Red,
                                start = Offset(0f, 0f),
                                end = Offset(canvasWidth, canvasHeight),
                                strokeWidth = 10f
                            )
                        else if (a == 2 && b == 4 && c == 6)
                            drawLine(
                                color = Color.Red,
                                start = Offset(0f, canvasHeight),
                                end = Offset(canvasWidth, 0f),
                                strokeWidth = 10f
                            )
                    }
                }) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[0] == "") {
                                        board[0] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[0], fontSize = 80.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[1] == "") {
                                        board[1] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[1], fontSize = 80.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[2] == "") {
                                        board[2] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[2], fontSize = 80.sp)
                        }
                    }
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[3] == "") {
                                        board[3] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[3], fontSize = 80.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[4] == "") {
                                        board[4] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[4], fontSize = 80.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[5] == "") {
                                        board[5] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[5], fontSize = 80.sp)
                        }
                    }
                    Row(
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[6] == "") {
                                        board[6] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[6], fontSize = 80.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[7] == "") {
                                        board[7] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[7], fontSize = 80.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .clickable(
                                    enabled = !t.bol
                                ) {
                                    if (board[8] == "") {
                                        board[8] = currentPlayer
                                        currentPlayer = if (currentPlayer == "X") "O"
                                        else "X"
                                    }
                                }, contentAlignment = Alignment.Center
                        ) {
                            Text(board[8], fontSize = 80.sp)
                        }
                    }
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    topBarText = "Tic Tac Toe"
                    for (i in board.indices) // doubt: at start wouldn't on changing
                    // first element it causes recomposition which will not change other indices
                        board[i] = ""
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(200.dp),
            ) {
                Text("New Game", fontSize = 30.sp)
            }
        }
    }
}

fun checkBoard(board: List<String>): WinnerInfo {
    val winningCombinations = listOf(
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )
    for (combination in winningCombinations) {
        if (board[combination[0]] == board[combination[1]] &&
            board[combination[1]] == board[combination[2]] &&
            board[combination[0]].isNotEmpty()) {
            return WinnerInfo(true, combination)
        }
    }
    return WinnerInfo(false, listOf())
}

data class WinnerInfo(val bol: Boolean, val winPosition: List<Int>)
