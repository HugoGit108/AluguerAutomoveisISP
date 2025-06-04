package com.isp.aluguerautomoveisisp;

class Automovel {
    private String matricula, marca, modelo, cor;
    private int cilindrada, ano;

    public Automovel(String matricula, String marca, String modelo, String cor, int cilindrada, int ano) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.cilindrada = cilindrada;
        this.ano = ano;
    }

    // Getters
    public String getMatricula() { return matricula; }

    @Override
    public String toString() {
        return String.format("Automóvel: %s, %s %s, Cor: %s, Cilindrada: %dcc, Ano: %d",
                matricula, marca, modelo, cor, cilindrada, ano);
    }
}
