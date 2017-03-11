package br.usjt.ftce.desmob.clientev1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textNome;
    public static final String CHAVE = "br.usjt.ftce.desmob.clientev1.busca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.buscar_clientes);
    }

    public void buscarCliente(View view) {
        Intent intent = new Intent(this, ListarClientesActivity.class);
        String nome = textNome.getText().toString();
        intent.putExtra(CHAVE, nome);
        startActivity(intent);
    }
}
