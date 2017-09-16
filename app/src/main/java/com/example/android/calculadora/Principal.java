package com.example.android.calculadora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private TextView res;
    private EditText n1,n2;
    private Spinner operaciones;
    private String op[];
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate -- metodo principal
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res = (TextView) findViewById(R.id.lblResultado);
        n1 = (EditText) findViewById(R.id.txtNumero1);
        n2 = (EditText) findViewById(R.id.txtNumero2);
        operaciones = (Spinner) findViewById(R.id.cmbOperaciones);
        resources = this.getResources();
        op = resources.getStringArray(R.array.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op);
        operaciones.setAdapter(adapter);
    }
}
