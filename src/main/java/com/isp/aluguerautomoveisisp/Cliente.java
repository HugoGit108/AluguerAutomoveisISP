package com.rentcar.gestaoaluguer;

public class Cliente {
    private String nome;
    private String morada;
    private String cc;
    private String cartaConducao;
    
    public void setNome(String nome) { this.nome = nome; }
    public void setMorada(String morada) { this.morada = morada; }
    public void setCc(String cc) { this.cc = cc; }
    public String getNome() { return nome; }
    public String getCc() { return cc; }
    public String getCartaConducao() { return cartaConducao; }



    public Cliente(String nome, String morada, String cc, String cartaConducao) {
        this.nome = nome;
        this.morada = morada;
        this.cc = cc;
        this.cartaConducao = cartaConducao;
    }

    @Override
    public String toString() {
        return nome + " - CC: " + cc + " - Carta: " + cartaConducao;
    }
}
