package com.rentcar.gestaoaluguer;

public class Cliente {
    private String nome;
    private String morada;
    private String cc;
    private String cartaConducao;

    public Cliente(String nome, String morada, String cc, String cartaConducao) {
        this.nome = nome;
        this.morada = morada;
        this.cc = cc;
        this.cartaConducao = cartaConducao;
    }

}
