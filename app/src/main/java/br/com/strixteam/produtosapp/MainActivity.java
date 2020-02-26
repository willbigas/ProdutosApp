package br.com.strixteam.produtosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.strixteam.produtosapp.activities.ActivityListarProdutos;
import br.com.strixteam.produtosapp.activities.ActivityProduto;
import br.com.strixteam.produtosapp.dbHelper.ConexaoSQLite;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProduto;
    private Button btnListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CHAMA INSTANCIA DO BANCO SQL LITE
        ConexaoSQLite.getInstancia(this);


        this.btnCadastroProduto = (Button) findViewById(R.id.btnCadastroProduto);
        this.btnListarProdutos = (Button) findViewById(R.id.btnListarProduto);


        // CHAMADA DE CLICK INTERNO NO BOTAO
        this.btnCadastroProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SERA EXECUTADO AO CLICAR NO BOTAO


                // OBJETO DE INTENÇÃO DE MUDANÇA DE TELA -- RECEBE 2 ACTIVITIES (Origem e Destino)
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);

                // METODO QUE STARTA A ACTIVITY
                startActivity(intent);
            }
        });


        // CHAMADA DE CLICK INTERNO NO BOTAO
        this.btnListarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActivityListarProdutos.class);
                startActivity(intent);

            }
        });
    }
}
