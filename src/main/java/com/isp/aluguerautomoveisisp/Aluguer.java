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

    public Cliente getCliente() {
        return cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        return "Aluguer{" +
                "cliente=" + cliente.getNome() +
                ", automovel=" + automovel.getMatricula() +
                ", de=" + dataInicio +
                ", até=" + dataFim +
                '}';
    }
}
