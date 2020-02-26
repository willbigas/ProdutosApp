package br.com.strixteam.produtosapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.strixteam.produtosapp.R;
import br.com.strixteam.produtosapp.adapters.AdapterListaProdutos;
import br.com.strixteam.produtosapp.controller.ProdutoController;
import br.com.strixteam.produtosapp.dbHelper.ConexaoSQLite;
import br.com.strixteam.produtosapp.model.Produto;

public class ActivityListarProdutos extends AppCompatActivity {


    private ListView lsvProdutos;
    private List<Produto> produtoList;
    private AdapterListaProdutos adapterListaProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);


        ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityListarProdutos.this));

        produtoList = produtoController.getListaProdutosController();


        this.lsvProdutos = (ListView) findViewById(R.id.lsvProdutos);

        this.adapterListaProdutos = new AdapterListaProdutos(ActivityListarProdutos.this, this.produtoList);

        this.lsvProdutos.setAdapter(this.adapterListaProdutos);

    }
}
