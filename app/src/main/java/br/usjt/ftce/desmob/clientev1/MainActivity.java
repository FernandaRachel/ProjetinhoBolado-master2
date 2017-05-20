package br.usjt.ftce.desmob.clientev1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText textNome;
    ArrayList<Cliente> lista;
    ClienteRequester clienteRequester;
    Intent intent;
    String chave;
    Context contexto;

    public static final String LISTA = "br.usjt.ftce.desmob.clientev1.lista";
    public static final String CHAVE = "br.usjt.ftce.desmob.clientev1.busca";
    public static final String SERVIDOR = "http://10.71.4.28:8080";
    public static final String APPSTRING = "/arqdesis_poetas";
    public static final String RECURSO = "/cliente";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contexto = this;
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.buscar_clientes);
    }

    public void buscarCliente(View view) {
        // Intent intent = new Intent(this, ListarClientesActivity.class);
        intent = new Intent(this, ListarClientesActivity.class);
        //String nome = textNome.getText().toString();
        chave = textNome.getText().toString();
        //intent.putExtra(CHAVE, nome);
        clienteRequester = new ClienteRequester();
        String alo = SERVIDOR + APPSTRING + RECURSO;
        System.out.println("ALO: " + alo);
        if (clienteRequester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        lista = clienteRequester.get(SERVIDOR + APPSTRING + RECURSO, chave);
                        ClientesDb banco = new ClientesDb(contexto);
                        banco.insereCliente(lista);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel. Carregando clientes do armazenados localmentes", Toast.LENGTH_LONG);
            toast.show();

            new CarregaClientesDoBanco().execute(ClientesDb.CLIENTE);

            // TODO CARREGAR CLIENTE IMAGEM
        }

    }

    private class CarregaClientesDoBanco extends AsyncTask<String, Void, ArrayList<Cliente>> {

        @Override
        protected ArrayList<Cliente> doInBackground(String... strings) {
            //teste rapido
            //Cliente teste = new Cliente(0, "Teste_sem_Conexao", "123456789", "teste@conexao.sem");
            //ArrayList<Cliente> testes = new ArrayList<>();
            //testes.add(teste);
            //fim teste
            ClientesDb banco = new ClientesDb(contexto);
            //banco.insereCliente(testes);

            ArrayList<Cliente> clientes = banco.selecionaClientes();

                return clientes;
        }

        public void onPostExecute(ArrayList<Cliente> result) {
            intent.putExtra(LISTA, lista);
            startActivity(intent);
        }
    }
}
