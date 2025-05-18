package com.rentcar.gestaoaluguer;

public class Automovel {
    private String marca;
    private String modelo;
    private String cor;
    private int cilindrada;
    private int ano;
    private String matricula;
    private double valorDia;

    public Automovel(String marca, String modelo, String cor, int cilindrada, int ano, String matricula, double valorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.cilindrada = cilindrada;
        this.ano = ano;
        this.matricula = matricula;
        this.valorDia = valorDia;
    }
    
}
