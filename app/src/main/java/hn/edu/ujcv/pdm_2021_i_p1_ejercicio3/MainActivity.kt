package hn.edu.ujcv.pdm_2021_i_p1_ejercicio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn00.setOnClickListener{appendOnClick(true,"00")}
        btn0.setOnClickListener{appendOnClick(true,"0")}
        btn1.setOnClickListener{appendOnClick(true,"1")}
        btn2.setOnClickListener{appendOnClick(true,"2")}
        btn3.setOnClickListener{appendOnClick(true,"3")}
        btn4.setOnClickListener{appendOnClick(true,"4")}
        btn5.setOnClickListener{appendOnClick(true,"5")}
        btn6.setOnClickListener{appendOnClick(true,"6")}
        btn7.setOnClickListener{appendOnClick(true,"7")}
        btn8.setOnClickListener{appendOnClick(true,"8")}
        btn9.setOnClickListener{appendOnClick(true,"9")}
        btnPunto.setOnClickListener{appendOnClick(true,".")}

        btnSumar.setOnClickListener{appendOnClick(false,"+")}
        btnRestar.setOnClickListener{appendOnClick(false,"-")}
        btnMultiplicacion.setOnClickListener{appendOnClick(false,"*")}
        btnDividir.setOnClickListener{appendOnClick(false,"/")}
        btnParentesisIzquierdo.setOnClickListener{appendOnClick(false,"(")}
        btnParentisisDerecho.setOnClickListener{appendOnClick(false,")")}

        btnLimpiar.setOnClickListener {
            limpiar()
        }
        btnIgual.setOnClickListener {
            calcular()
        }
    }

    private fun appendOnClick(limpiar: Boolean, texto:String){
        if (limpiar){
            txtSalida.text=""
            txtEntrada.append(texto)
        }else{
            txtEntrada.append(txtSalida.text)
            txtEntrada.append(texto)
            txtSalida.text=""
        }
    }
    private fun limpiar(){
        txtEntrada.text = ""
        txtSalida.text = ""
    }
    private fun calcular(){
        try {
            val entrada = ExpressionBuilder(txtEntrada.text.toString()).build()
            val salida = entrada.evaluate()
            val largoSalida = salida.toLong()
            if (salida == largoSalida.toDouble()){
                txtSalida.text = largoSalida.toString()
            }else{
                txtSalida.text = salida.toString()
            }
        }catch (o:Exception){
            Toast.makeText(this@MainActivity, o.message, Toast.LENGTH_LONG).show()
        }
    }
}