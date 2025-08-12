package com.example.clientesapp.screens.cliente.componentes.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun BarraInferior() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        NavigationBarItem(
            onClick = {
                
            },
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text(text = "home")
            }
        )
        NavigationBarItem(
            onClick = {},
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            },
            label = {
                Text(text = "Favorito")
            }
        )
        NavigationBarItem(
            onClick = {},
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "MeuPerfil"
                )
            },
            label = {
                Text(text = "Meu perfil")
            }
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