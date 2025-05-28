package com.isp.aluguerautomoveisisp;

public class Cliente {
    private String nome;
    private String nif;
    private String cartaConducao;

    public Cliente(String nome, String nif, String cartaConducao) {
        this.nome = nome;
        this.nif = nif;
        this.cartaConducao = cartaConducao;
    }

    public String getNome() {
        return nome;
    }

    public String getNif() {
        return nif;
    }

    public String getCartaConducao() {
        return cartaConducao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", NIF='" + nif + '\'' +
                ", carta de condução='" + cartaConducao + '\'' +
                '}';
    }
}
