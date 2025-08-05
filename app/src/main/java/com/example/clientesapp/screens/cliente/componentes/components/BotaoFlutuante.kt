package com.example.clientesapp.screens.cliente.componentes.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun BotaoFlutuante(){
    FloatingActionButton(

        onClick = {}
    ) { }
}

@Preview
@Composable
private fun BotaoFLutuantePreview(){
    ClientesAppTheme {
        BotaoFlutuante()
    }
}