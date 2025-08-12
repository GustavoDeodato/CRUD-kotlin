package com.example.clientesapp.screens.cliente.componentes

import android.content.res.Configuration
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clientesapp.screens.cliente.componentes.New.ClienteForm
import com.example.clientesapp.screens.cliente.componentes.components.BarraDeTitulo
import com.example.clientesapp.screens.cliente.componentes.components.BarraInferior
import com.example.clientesapp.screens.cliente.componentes.components.BotaoFlutuante
import com.example.clientesapp.screens.cliente.componentes.components.Conteudo
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun ListaDeClientes(modifier: Modifier = Modifier) {

    var controleNavegacao = rememberNavController()
    Scaffold (

        topBar = {
            BarraDeTitulo()
        },
        bottomBar = {
            BarraInferior()
        },
        floatingActionButton = {
          BotaoFlutuante()
        },
        content = { padding ->
            NavHost(
                navController = controleNavegacao,
                startDestination = "Lista"
            )
            {
                composable(route = "conteudo"){ Conteudo(padding) }
                composable(route = "cadastro"){ ClienteForm(padding) }
        }
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