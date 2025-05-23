package com.isp.aluguerautomoveisisp;

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

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getCor() { return cor; }
    public int getCilindrada() { return cilindrada; }
    public int getAno() { return ano; }
    public String getMatricula() { return matricula; }
    public double getValorDia() { return valorDia; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCor(String cor) { this.cor = cor; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
    public void setAno(int ano) { this.ano = ano; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setValorDia(double valorDia) { this.valorDia = valorDia; }
}
