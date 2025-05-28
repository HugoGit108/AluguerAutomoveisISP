package com.isp.aluguerautomoveisisp;

public class Automovel {
    private String matricula;
    private String marca;
    private String modelo;
    private int ano;

    public Automovel(String matricula, String marca, String modelo, int ano) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Automóvel{" +
                "matrícula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }
}
