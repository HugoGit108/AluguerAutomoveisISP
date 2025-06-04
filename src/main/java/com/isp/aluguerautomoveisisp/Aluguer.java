package com.isp.aluguerautomoveisisp;

import java.time.LocalDate;

class Aluguer {
    private String cartaConducaoCliente;
    private String matriculaVeiculo;
    private LocalDate inicio;
    private LocalDate fim;
    private boolean devolvido;

    public Aluguer(String cartaConducaoCliente, String matriculaVeiculo, LocalDate inicio, LocalDate fim) {
        this.cartaConducaoCliente = cartaConducaoCliente;
        this.matriculaVeiculo = matriculaVeiculo;
        this.inicio = inicio;
        this.fim = fim;
        this.devolvido = false;
    }

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

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    @Override
    public String toString() {
        return String.format("Aluguer: Cliente %s, Veículo %s, De %s até %s, Devolvido: %s",
                cartaConducaoCliente, matriculaVeiculo, inicio, fim, devolvido ? "Sim" : "Não");
    }
}1