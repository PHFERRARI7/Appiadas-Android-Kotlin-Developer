package br.com.pedroferrari.appiadas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pedroferrari.appiadas.ui.theme.AppiadasTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppiadasTheme {

                Scaffold() { innerPadding ->
                    AppiadasScreen(Modifier.padding(innerPadding))

                }

            }
        }
    }
}

@Composable
fun AppiadasScreen(modifier: Modifier = Modifier) {

    val jokers = listOf<String>(
        "Por que a aranha é o animal mais carente do mundo?\n Porque ela é um aracneedyou",
        "Por que o pinheiro não se perde na floresta?\n Porque ele tem uma pinha",
        "O que um pagodeiro foi fazer na igreja?\n Foi cantar Pá GOD",

        )

    // var é mutável
    var jokerSelected by remember { mutableStateOf("Aqui será exibida uma piada") }

    fun tellJoker() {
        // val é imutável
        val numberSelected = Random.nextInt(jokers.size)
        jokerSelected = jokers[numberSelected]
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background_joker),
            contentDescription = "Imagem de fundo com o rosto do Coringa",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                jokerSelected,
                color = Color(0xFFFFA726),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                lineHeight = 30.sp

            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    tellJoker()
                },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text("Nova piada")
            }
        }
    }
}


@Preview
@Composable
private fun AppiadasScreenPreview() {

    AppiadasTheme {
        AppiadasScreen()
    }

}


