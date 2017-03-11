package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetallheClienteActivity extends Activity {
    TextView textViewnome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallhe_cliente);
        textViewnome = (TextView) findViewById(R.id.txt_cliente_nome);
        Intent intent = getIntent();
        String nome = intent.getStringExtra(ListarClientesActivity.NOME);
        textViewnome.setText(nome);
    }
}
