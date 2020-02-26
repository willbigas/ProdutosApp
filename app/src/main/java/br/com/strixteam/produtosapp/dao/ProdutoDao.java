package br.com.strixteam.produtosapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.strixteam.produtosapp.dbHelper.ConexaoSQLite;
import br.com.strixteam.produtosapp.model.Produto;

public class ProdutoDao {

    private final ConexaoSQLite conexaoSQLite;

    public ProdutoDao(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarProdutoDAO(Produto produto) {

        // ABRINDO BANCO PARA ESCRITA
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();

            values.put("id", produto.getId());
            values.put("nome", produto.getNome());
            values.put("quantidade_em_estoque", produto.getQuantidadeEmEstoque());
            values.put("preco", produto.getPreco());

            long idProdutoInserido = db.insert("produto", null, values);

            return idProdutoInserido;

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            if (db != null) {
                db.close();
            }
        }

        return 0;
    }


    public List<Produto> getListaProdutosDAO() {

        List<Produto> listaProdutos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM produto;";

        try {

            db = conexaoSQLite.getReadableDatabase();

            cursor = db.rawQuery(query , null);

            if (cursor.moveToFirst()) {

                Produto produto = null;

                do {

                    produto = new Produto();
                    produto.setId(cursor.getLong(0));
                    produto.setNome(cursor.getString(1));
                    produto.setQuantidadeEmEstoque(cursor.getInt(2));
                    produto.setPreco(cursor.getDouble(3));
                    listaProdutos.add(produto);


                } while (cursor.moveToNext());

            }


        } catch (Exception e) {
            Log.d("ERRO LISTA PRODUTOS", "Erro ao retornar os produtos");
            return null;
        } finally {

            if (db != null) {
                db.close();
            }
        }

        return listaProdutos;

    }
}
