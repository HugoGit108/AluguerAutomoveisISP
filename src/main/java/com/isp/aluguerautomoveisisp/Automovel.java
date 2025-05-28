package com.isp.aluguerautomoveisisp;

public class Automovel {
    private static final double VALOR_DIA = 30.0;

    private String matricula;
    private String marca;
    private String modelo;
    private String cor;
    private int cilindrada;
    private int ano;

    public Automovel(String matricula, String marca, String modelo, String cor, int cilindrada, int ano) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.cilindrada = cilindrada;
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

    public String getCor() {
        return cor;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getAno() {
        return ano;
    }

    public double getValorDia() {
        return VALOR_DIA;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula +
               " | Marca: " + marca +
               " | Modelo: " + modelo +
               " | Cor: " + cor +
               " | Cilindrada: " + cilindrada + "cc" +
               " | Ano: " + ano +
               " | Valor/dia: " + VALOR_DIA + "€";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Automovel)) return false;
        Automovel outro = (Automovel) obj;
        return this.matricula.equalsIgnoreCase(outro.matricula);
    }

    @Override
    public int hashCode() {
        return this.matricula.toLowerCase().hashCode();
    }
}
