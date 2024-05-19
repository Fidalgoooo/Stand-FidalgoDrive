package Stand;

import java.util.Date;

public class Venda {
    private int idVenda;
    private String dataVenda;
    private float PrecoCarro;
    private String nome;
    private String modelo;

    // Getters e Setters
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String DataVenda) {
        this.dataVenda = DataVenda;
    }

    public float getPrecoCarro() {
        return PrecoCarro;
    }

    public void setPrecoCarro(float precoCarro) {
        PrecoCarro = precoCarro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Venda(String DataVenda, float precoCarro, String nome, String modelo) {
        this.dataVenda = DataVenda;
        this.PrecoCarro = precoCarro;
        this.nome = nome;
        this.modelo = modelo;
    }

    public Venda(int idVenda, String DataVenda, float precoCarro, String nome, String modelo) {
        this.idVenda = idVenda;
        this.dataVenda = DataVenda;
        this.PrecoCarro = precoCarro;
        this.nome = nome;
        this.modelo = modelo;
    }
}