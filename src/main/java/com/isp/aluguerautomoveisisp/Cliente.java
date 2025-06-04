package com.isp.aluguerautomoveisisp;

class Cliente {
    private String nome, morada, cc, cartaConducao, nif;

    public Cliente(String nome, String morada, String cc, String cartaConducao, String nif) {
        this.nome = nome;
        this.morada = morada;
        this.cc = cc;
        this.cartaConducao = cartaConducao;
        this.nif = nif;
    }

    public String getCartaConducao() { return cartaConducao; }
    public void setCartaConducao(String c) { this.cartaConducao = c; }
    public String getNome() { return nome; }
    public void setNome(String n) { this.nome = n; }
    public String getMorada() { return morada; }
    public void setMorada(String m) { this.morada = m; }
    public String getCc() { return cc; }
    public void setCc(String cc) { this.cc = cc; }
    public String getNif() { return nif; }
    public void setNif(String n) { this.nif = n; }

    @Override
    public String toString() {
        return String.format("Cliente: %s, NIF: %s, Morada: %s, CC: %s, Carta: %s",
                nome, nif, morada, cc, cartaConducao);
    }
}
