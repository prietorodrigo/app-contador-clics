package com.example.contadorclicks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // A partir daqui vem a lógica

        txt = findViewById(R.id.txtContador);

        if(savedInstanceState != null) {
            String s = savedInstanceState.getString("cont");
            txt.setText(s);
        }

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String conttxt = txt.getText().toString();
                int contador = Integer.parseInt(conttxt);
                contador = contador + 1;
                String resultado = String.valueOf(contador);
                txt.setText(resultado);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String str = txt.getText().toString();
        outState.putString("cont", str);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String str = savedInstanceState.getString("cont");
        txt.setText(str);
    }
}