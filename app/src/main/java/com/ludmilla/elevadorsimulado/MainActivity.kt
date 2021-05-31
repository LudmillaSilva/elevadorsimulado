package com.ludmilla.elevadorsimulado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text




class MainActivity : AppCompatActivity() {


    var andar: TextView? = null
    lateinit var entrar: Button
    var descreverandar: EditText? = null
    lateinit var sair: Button
    lateinit var andarinformado: Button
    lateinit var quantidadepessoas: TextView
    lateinit var visualizarandar: TextView
    lateinit var informativo: TextView
    var quantidadeemnumero: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     andar = findViewById (R.id.txtAndar)
     entrar = findViewById(R.id.btnEntrar)
     sair = findViewById(R.id.btnSair)
     andarinformado = findViewById(R.id.btnAndarSelecionado)
     quantidadepessoas = findViewById(R.id.txtCapacidade)
     informativo = findViewById(R.id.txtInformativo)
     visualizarandar = findViewById(R.id.btnAndarSelecionado)
     descreverandar = findViewById(R.id.edtInformeAndar)



    entrar.setOnClickListener {
       var exibirquantidadePessoas: String = EntrarPessoas(quantidadepessoas)
        quantidadepessoas.text = exibirquantidadePessoas

        }
    sair.setOnClickListener {
            var exibirquantidadePessoas: String = SairPessoas(quantidadepessoas)
            quantidadepessoas.text = exibirquantidadePessoas

        }


    andarinformado.setOnClickListener {
        InformarAndar(descreverandar)
        descreverandar?.setText ("")
        }

    }
    fun EntrarPessoas (quantidadepessoas: TextView): String {
        var exibirquantidade: String = ""
        //val Quantidade = quantidadepessoas?.text.toString()

        if(quantidadeemnumero < 5) {
            quantidadeemnumero += 1
          //  if(quantidadeemnumero!=6)
            exibirquantidade= "${quantidadeemnumero.toString()} de 5 pessoas no elevador"
        }
        else {
            informativo.text="O elevador ja esta com sua quantidade máxima, por favor, tente novamente depois!"
        }

        return exibirquantidade

    }
    fun SairPessoas (quantidadepessoas: TextView): String {
        var exibirquantidade: String = ""
                if(quantidadeemnumero >0) {
            quantidadeemnumero -= 1
            exibirquantidade= "${quantidadeemnumero.toString()} de 5 pessoas no elevador"
        }
        else {
            informativo.text="Gentileza entrar no elevador para informarmos a quantidade de pessoas!"
        }

        return exibirquantidade

    }
    fun InformarAndar(descreverandar: EditText?){
         val andarinserido = descreverandar?.text.toString()
            if(quantidadeemnumero ==0) {
            informativo.text = "Favor entrar no elevador primeiro!"
        } else if(andarinserido.isNotEmpty() && andarinserido.toInt()>0 ){
              andar?.text = "$andarinserido º Andar"
        }else {
            descreverandar?.error = "Favor inserir um andar!"
        }

    }


}


