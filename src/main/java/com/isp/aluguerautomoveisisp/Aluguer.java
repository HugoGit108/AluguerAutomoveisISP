package com.isp.aluguerautomoveisisp;

import java.time.LocalDate;

public class Aluguer {
    private Cliente cliente;
    private Automovel automovel;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Aluguer(Cliente cliente, Automovel automovel, LocalDate dataInicio, LocalDate dataFim) {
        this.cliente = cliente;
        this.automovel = automovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Cliente getCliente() { return cliente; }
    public Automovel getAutomovel() { return automovel; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }

    public long getDuracaoDias() {
        return dataInicio.until(dataFim).getDays();
    }

    public double getValorTotal() {
        return getDuracaoDias() * automovel.getValorDia();
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + " | Automóvel: " + automovel.getMarca() + " " + automovel.getModelo() +
               " | Matrícula: " + automovel.getMatricula() +
               " | Início: " + dataInicio +
               " | Fim: " + dataFim +
               " | Total: " + getValorTotal() + "€";
    }
}