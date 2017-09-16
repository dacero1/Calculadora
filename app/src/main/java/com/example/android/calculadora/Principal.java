package com.example.android.calculadora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void calcuar(View v){
        int opcion;
        double num1, num2, resultado = 0;
        if(validad()){
            res.setText("");
            opcion = operaciones.getSelectedItemPosition();
            num1 = Double.parseDouble(n1.getText().toString());
            num2 = Double.parseDouble(n2.getText().toString());
            switch (opcion){
                case 0:
                    resultado = num1 + num2;
                    break;
                case 1:
                    resultado = num1 - num2;
                    break;
                case 2:
                    resultado = num1 * num2;
                    break;
                case 3:
                    if(num2==0){
                        n2.setError(resources.getString(R.string.error_tres));
                    }else{
                        resultado = num1 / num2;
                        n2.setText("");
                        n2.requestFocus();
                    }
                    break;
            }
            res.setText(""+String.format("%.2f",resultado));
        }

    }
    public void borrar(View v){
        n1.setText("");
        n2.setText("");
        res.setText("");
        operaciones.setSelection(0);
        n1.requestFocus();
    }

    private boolean validad(){
        if(n1.getText().toString().isEmpty()){
            n1.setError(resources.getString(R.string.error_uno));
            n1.requestFocus();
            return false;
        }
        if(n2.getText().toString().isEmpty()){
            n2.setError(resources.getString(R.string.error_dos));
            n2.requestFocus();
            return false;
        }
        return true;
    }
}
