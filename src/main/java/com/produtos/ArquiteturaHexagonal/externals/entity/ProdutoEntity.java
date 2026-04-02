package com.produtos.ArquiteturaHexagonal.externals.entity;

import com.produtos.ArquiteturaHexagonal.core.product.entity.Produto;
import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private Long clienteId;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Long id, String nome, Double preco, Integer quantidade, Long clienteId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.clienteId = clienteId;
    }

    public Produto toDomain() {
        return new Produto(
                this.id,
                this.nome,
                this.preco,
                this.quantidade,
                this.clienteId
        );
    }

    public static ProdutoEntity fromDomain(Produto domain) {
         ProdutoEntity entity = new ProdutoEntity(
                domain.getId(),
                domain.getNome(),
                domain.getPreco(),
                domain.getQuantidade(),
                domain.getClienteId()
        );

        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}


