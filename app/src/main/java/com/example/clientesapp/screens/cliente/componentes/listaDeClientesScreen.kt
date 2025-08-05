package com.example.clientesapp.screens.cliente.componentes

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clientesapp.screens.cliente.componentes.components.BarraDeTitulo
import com.example.clientesapp.screens.cliente.componentes.components.BarraInferior
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun ListaDeClientes(modifier: Modifier = Modifier) {
    Scaffold (

        topBar = {
            BarraDeTitulo()
        },
        bottomBar = {
            BarraInferior()
        },
        floatingActionButton = {
            Button(
                onClick = {}
            ) {
                Text(text = "botao")
            }
        },
        content = {
            Column (
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ){  }
        }
    )

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ListaDeCLientesPreview(){
    ClientesAppTheme {
        ListaDeClientes()
    }
}