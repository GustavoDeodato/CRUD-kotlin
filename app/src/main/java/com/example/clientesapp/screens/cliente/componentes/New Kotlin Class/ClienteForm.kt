package com.example.clientesapp.screens.cliente.componentes.New

import android.content.res.Configuration
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.clientesapp.model.Cliente
import com.example.clientesapp.service.Conexao
import com.example.clientesapp.ui.theme.ClientesAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

@Composable
fun ClienteForm(padding: PaddingValues, controleNavegacao: NavHostController? ) {

    var nomeCliente by remember { mutableStateOf("") }
    var emailCliente by remember { mutableStateOf("") }
    var isNomeError by remember { mutableStateOf(false) }
    var isEmailError by remember { mutableStateOf(false) }

    fun validar(): Boolean{
        isNomeError = nomeCliente.length < 3
        isEmailError = !Patterns.EMAIL_ADDRESS.matcher(emailCliente).matches()
        return !isNomeError && !isEmailError
    }
    var mostrarMensagemSucesso by remember { mutableStateOf(false) }

    //criar um instancia da conexao com a API
    var clienteAPI = Conexao().getClienteService()


Surface (
    modifier = Modifier.fillMaxSize()
        .padding(padding)
){
    Column (

        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme
                    .colorScheme
                    .primaryContainer
            )
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

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Novo Cliente",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )

        }
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(
            value = nomeCliente,
            onValueChange = {
                nomeCliente = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            label = {
                Text(text = "Nome do cliente")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.width(16.dp))
        OutlinedTextField(
            value = emailCliente,
            onValueChange = {
                emailCliente = it
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            label = {
                Text(text = "E-mail do cliente")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            isError = isEmailError,
            supportingText = {
                if (isNomeError){
                    Text(text = "0 E-mail esta incorreto.")
                }
            }
        )
        Button(
            onClick = {
                if (validar()){
                    val cliente =  Cliente(
                        id = null,
                        nome = nomeCliente,
                        email = emailCliente
                    )
                    GlobalScope.launch (Dispatchers.IO){
                        val clienteNovo = clienteAPI
                            .cadastrarCliente(cliente)
                            .await()
                        mostrarMensagemSucesso = true
                    }

                }else{
                    println("Dados incorretos!!")
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Gravar cliente")
        }

    }
}


    if (mostrarMensagemSucesso){
        AlertDialog(
            onDismissRequest = {
                mostrarMensagemSucesso = false
            },
            title = {
                Text(text = "Sucesso")
            },
            text = { Text(text = "Cliente $nomeCliente gravado com sucesso!\n Deseja cadastrar outro cliente?") },
            confirmButton = {
                TextButton(
                    onClick = {}
                ) {
                    Text(text = "Sim")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        controleNavegacao!!.navigate("conteudo")
                    }
                ) { Text(text = "sugue meus zovo") }
            }
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES

    )

@Composable
private fun ClienteFormPreview(){
    ClientesAppTheme {
        ClienteForm(PaddingValues(0.dp), null)
    }
}