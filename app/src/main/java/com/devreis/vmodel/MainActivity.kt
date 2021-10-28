package com.devreis.vmodel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var txtContador: EditText
    private lateinit var btDados: Button
    private lateinit var btMostrar: Button
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtContador = findViewById(R.id.txtContador)
        btDados = findViewById(R.id.btDados)
        btMostrar = findViewById(R.id.btmostrar)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.mContador.observe(this, { txtContador.setText(it) })
        btDados.setOnClickListener { mViewModel.rodaContador() }
        btMostrar.setOnClickListener { Toast.makeText(applicationContext, "Valor contador ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show() }
    }
}