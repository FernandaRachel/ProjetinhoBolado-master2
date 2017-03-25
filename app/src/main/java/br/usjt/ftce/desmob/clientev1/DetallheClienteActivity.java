package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallheClienteActivity extends Activity {
    TextView textViewNome, textViewEmail, textViewFone;
    ImageView imagemCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallhe_cliente);
        textViewNome = (TextView) findViewById(R.id.txt_cliente_nome);
        textViewFone = (TextView) findViewById(R.id.txt_cliente_fone);
        textViewEmail = (TextView) findViewById(R.id.txt_cliente_email);
        imagemCliente = (ImageView) findViewById(R.id.cliente_image_view);
        Intent intent = getIntent();
        Cliente cliente = (Cliente) intent.getSerializableExtra(ListarClientesActivity.CLIENTE);

        textViewNome.setText(cliente.getNome());
        textViewFone.setText(cliente.getFone());
        textViewEmail.setText(cliente.getEmail());
// m
        Drawable foto = Imagem.getDrawable(this, cliente.getImagem());
        imagemCliente.setImageDrawable(foto);

    }
}
