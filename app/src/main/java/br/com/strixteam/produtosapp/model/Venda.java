package br.com.strixteam.produtosapp.model;

import java.util.Date;

public class Venda {

    private long id;
    private Produto produtoVendido;
    private Date dataDaVenda;
    private String nomeCliente;


    public Venda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", produtoVendido=" + produtoVendido +
                ", dataDaVenda=" + dataDaVenda +
                ", nomeCliente='" + nomeCliente + '\'' +
                '}';
    }
}
