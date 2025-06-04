package com.isp.aluguerautomoveisisp;

import java.time.LocalDate;

class Aluguer {
    private String cartaConducaoCliente;
    private String matriculaVeiculo;
    private LocalDate inicio;
    private LocalDate fim;
    private LocalDate dataDevolucao; 

    public Aluguer(String cartaConducaoCliente, String matriculaVeiculo, LocalDate inicio, LocalDate fim) {
        this.cartaConducaoCliente = cartaConducaoCliente;
        this.matriculaVeiculo = matriculaVeiculo;
        this.inicio = inicio;
        this.fim = fim;
        this.dataDevolucao = null;
    }

    // Getters
    public String getCartaConducaoCliente() {
        return cartaConducaoCliente;
    }

    public String getMatriculaVeiculo() {
        return matriculaVeiculo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }

    @Override
    public String toString() {
        return String.format("Aluguer: Cliente %s, Veículo %s, De %s até %s, Devolvido em: %s",
                cartaConducaoCliente, matriculaVeiculo, inicio, fim,
                (dataDevolucao != null ? dataDevolucao.toString() : "Ainda ativo"));
    }
}
