package com.isp.aluguerautomoveisisp;

public class Cliente {
    private String nome;
    private String morada;
    private String cc;
    private String cartaConducao;
    private String nif;

    // Construtor
    public Cliente(String nome, String morada, String cc, String cartaConducao, String nif) {
        this.nome = nome;
        this.morada = morada;
        this.cc = cc;
        this.cartaConducao = cartaConducao;
        this.nif = nif;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCc() {
        return cc;
    }
    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCartaConducao() {
        return cartaConducao;
    }
    public void setCartaConducao(String cartaConducao) {
        this.cartaConducao = cartaConducao;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String Nif) {
        this.nif = Nif;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "Nome='" + nome + '\'' +
                ", Morada='" + morada + '\'' +
                ", CC='" + cc + '\'' +
                ", Nif='" + nif + '\'' +
                ", Carta de Conducao='" + cartaConducao + '\'' +
                '}';
    }
}
