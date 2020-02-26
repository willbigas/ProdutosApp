package br.com.strixteam.produtosapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.strixteam.produtosapp.R;
import br.com.strixteam.produtosapp.controller.ProdutoController;
import br.com.strixteam.produtosapp.dbHelper.ConexaoSQLite;
import br.com.strixteam.produtosapp.model.Produto;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtIdProduto;
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtPrecoProduto;

    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);


        // ATRIBUI OS COMPONENTES DO LAYOUT A UM COMPONENTE JAVA
        edtIdProduto = (EditText) findViewById(R.id.edtIdProduto);
        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        edtPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

        this.clickNoBotaoSalvarListener();

    }

    private void clickNoBotaoSalvarListener() {

        this.btnSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Produto produtoParaCadastrar = getDadosProdutoDoFormulario();

                if (produtoParaCadastrar != null) {

                    ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityProduto.this));

                    long idProduto = produtoController.salvarProdutoController(produtoParaCadastrar);

                    if (idProduto > 0) {
                        Toast.makeText(ActivityProduto.this, "Produto salvo com sucesso!", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(ActivityProduto.this, "Produto não pode ser salvo!", Toast.LENGTH_LONG).show();
                    }


                } else {
                    Toast.makeText(ActivityProduto.this, "Todos os campos são obrigatórios!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    private Produto getDadosProdutoDoFormulario() {

        // CAPTURA OS DADOS VINDO DA INTERFACE

        this.produto = new Produto();

        if (!this.edtIdProduto.getText().toString().isEmpty()) {
            long id = Long.parseLong(this.edtIdProduto.getText().toString());

            this.produto.setId(id);
        } else {
            return null;
        }


        if (!this.edtNomeProduto.getText().toString().isEmpty()) {
            this.produto.setNome(this.edtNomeProduto.getText().toString());
        } else {
            return null;
        }


        if (!this.edtQuantidadeProduto.getText().toString().isEmpty()) {
            int quantidade = Integer.parseInt(this.edtQuantidadeProduto.getText().toString());
            this.produto.setQuantidadeEmEstoque(quantidade);
        } else {
            return null;
        }

        if (!this.edtPrecoProduto.getText().toString().isEmpty()) {
            double preco = Double.parseDouble(this.edtPrecoProduto.getText().toString());
            this.produto.setPreco(preco);
        } else {
            return null;
        }

        return produto;

    }

}
