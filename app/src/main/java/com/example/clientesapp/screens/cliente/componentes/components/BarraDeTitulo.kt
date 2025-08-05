package com.example.clientesapp.screens.cliente.componentes.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.clientesapp.R
import com.example.clientesapp.screens.cliente.componentes.ListaDeClientes
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun BarraDeTitulo (modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Row (modifier = Modifier .fillMaxWidth()){
                Column {
                    Text(text = "Carlinhos")
                    Text(text = "Carlinhos.2050cavalos@email")
                }
                Card (
                    modifier = Modifier

                ){
                    Image(
                        painter = painterResource(R.drawable.carlinhos),
                        contentDescription = "foto de perfil"
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