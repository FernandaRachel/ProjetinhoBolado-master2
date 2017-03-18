package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClienteAdapter extends BaseAdapter {

    Cliente[] clientes;
    Activity context;

    public ClienteAdapter(Activity context, Cliente[] clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return clientes.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < clientes.length) {
            return clientes[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.linha_cliente, viewGroup, false);

        ImageView fotoCliente = (ImageView) view1.findViewById(R.id.foto_cliente);
        TextView nomeCliente = (TextView) view1.findViewById(R.id.nome_cliente);
        TextView detalheCliente = (TextView) view1.findViewById(R.id.detalhe_cliente);

        nomeCliente.setText(clientes[i].getNome());
        detalheCliente.setText(clientes[i].getFone() + "  -  " + clientes[i].getEmail());

        return view1;
    }
}
