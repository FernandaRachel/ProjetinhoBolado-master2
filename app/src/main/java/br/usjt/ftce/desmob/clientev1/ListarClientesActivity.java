package br.usjt.ftce.desmob.clientev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarClientesActivity extends AppCompatActivity {
    ListView listView;
    Cliente[] lista;
    public static final String CLIENTE = "br.usjt.ftce.desmob.clientev1.nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);
        listView = (ListView) findViewById(R.id.lista_de_clientes);
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = Data.buscaClientes(chave);
        BaseAdapter adapter = new ClienteAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Intent intent1 = new Intent(ListarClientesActivity.this, DetallheClienteActivity.class);
                intent1.putExtra(CLIENTE, lista[posicao]);
                startActivity(intent1);

            }
        });
    }

}