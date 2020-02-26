package br.com.strixteam.produtosapp.controller;

import java.util.List;

import br.com.strixteam.produtosapp.dao.ProdutoDao;
import br.com.strixteam.produtosapp.dbHelper.ConexaoSQLite;
import br.com.strixteam.produtosapp.model.Produto;

public class ProdutoController {

    private final ProdutoDao produtoDao;

    public ProdutoController(ConexaoSQLite conexaoSQLite) {
        produtoDao = new ProdutoDao(conexaoSQLite);
    }

    public long salvarProdutoController(Produto produto) {
        return this.produtoDao.salvarProdutoDAO(produto);
    }

    public List<Produto> getListaProdutosController() {
        return this.produtoDao.getListaProdutosDAO();
    }
}
