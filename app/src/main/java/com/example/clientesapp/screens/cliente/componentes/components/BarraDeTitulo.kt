package com.example.clientesapp.screens.cliente.componentes.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clientesapp.R
import com.example.clientesapp.screens.cliente.componentes.ListaDeClientes
import com.example.clientesapp.ui.theme.ClientesAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraDeTitulo (modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text(text = "Carlinhos", style = MaterialTheme.typography.titleLarge)
                    Text(text = "cavalos@gmail.com", style = MaterialTheme.typography.titleSmall)
                }
                Card (
                    modifier = Modifier
                        .size(60.dp)
                        .padding(4.dp),
                    shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(R.drawable.carlinhos),
                        contentDescription = "perfil",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun BarraDeTituloPreview(){
    ClientesAppTheme {
        BarraDeTitulo()
    }
}