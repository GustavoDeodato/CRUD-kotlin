package com.example.clientesapp.screens.cliente.componentes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clientesapp.ui.theme.ClientesAppTheme


@Composable
fun Conteudo(paddingValues: PaddingValues) {
    Column (
        modifier = Modifier.padding(paddingValues).fillMaxSize()
    ){
        Row (
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Lista de Clientes"
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "lista de clientes"
            )
        }
        LazyColumn {
            items(10){
                Card (
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    Row (
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column {
                            Text(text = "Nome baronico")
                            Text(text = "email@baronico.com")
                        }
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "delete"
                        )
                    }
                }
            }
        }
    }
}
@Composable
@Preview
private fun conteudoPreview(){
    ClientesAppTheme {
        Conteudo(paddingValues = PaddingValues(16.dp))
    }
}