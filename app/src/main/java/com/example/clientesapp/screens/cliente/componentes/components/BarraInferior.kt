package com.example.clientesapp.screens.cliente.componentes.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun BarraInferior(){
    NavigationBar (
        containerColor = MaterialTheme
            .colorScheme.primaryContainer

    ){
        NavigationBar (

        )
    }
}

@Preview
@Composable
private fun BarraInferiorPreview(){
    ClientesAppTheme {
        BarraInferior()
    }
}