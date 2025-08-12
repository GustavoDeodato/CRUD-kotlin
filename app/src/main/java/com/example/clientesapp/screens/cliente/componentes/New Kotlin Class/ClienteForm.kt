package com.example.clientesapp.screens.cliente.componentes.New

import android.content.res.Configuration
import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun ClienteForm(padding: PaddingValues) {

    var nomeCliente by remember { mutableMapOf("") }
    var emailCliente by remember { mutableMapOf("") }
    var isNomeError by remember { mutableMapOf(false) }
    var isEmailError by remember { mutableMapOf(false) }

    fun validar(): Boolean{
        isNomeError = nomeCliente.length < 3
        isEmailError = !Patterns.EMAIL_ADDRESS.matcher()
        return
    }
    //criar um instancia da conexao com a API
    val clienteAPI
Surface (
    modifier = Modifier.fillMaxSize()
        .padding(padding)
){
    Column (

        modifier = Modifier
            .fillMaxSize()
    ){
        Row (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "person"
            )



            Text(
                text = "Novo Cliente",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Novo Cliente",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

        }
    }
}
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES

    )

@Composable
private fun ClienteFormPreview(){
    ClientesAppTheme {
        ClienteForm(PaddingValues(0.dp))
    }
}