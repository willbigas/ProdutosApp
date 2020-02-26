package br.com.strixteam.produtosapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.strixteam.produtosapp.R;
import br.com.strixteam.produtosapp.model.Produto;

public class AdapterListaProdutos extends BaseAdapter {

    private Context context;
    private List<Produto> produtoList;

    public AdapterListaProdutos(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return produtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.produtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void removerProduto(int posicao) {
        this.produtoList.remove(posicao);
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(this.context, R.layout.layout_produto, null);

        TextView tvNomeProduto = (TextView) v.findViewById(R.id.tvNomeProduto);
        TextView tvPrecoProduto = (TextView) v.findViewById(R.id.tvPrecoProduto);
        TextView tvEstoqueProduto = (TextView) v.findViewById(R.id.tvEstoqueProduto);

        tvNomeProduto.setText(this.produtoList.get(position).getNome());
        tvPrecoProduto.setText(String.valueOf(this.produtoList.get(position).getPreco()));
        tvEstoqueProduto.setText(String.valueOf(this.produtoList.get(position).getQuantidadeEmEstoque()));

        return v;
    }
}
