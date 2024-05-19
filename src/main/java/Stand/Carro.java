package Stand;

public class Carro {
    private int idCarro;
    private String modelo;
    private int ano;
    private String cor;
    private float Preco;
    private String estado;
    private String numero_chassi;
    private String numero_serie;

    // Getters e Setters
    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero_chassi() {
        return numero_chassi;
    }

    public void setNumero_chassi(String numero_chassi) {
        this.numero_chassi = numero_chassi;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }


    public Carro(int idCarro) {
        this.idCarro = idCarro;
    }

    public Carro(int idCarro, String modelo, int ano, String cor, float Preco, String estado, String numero_chassi, String numero_serie) {
        this.idCarro = idCarro;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.Preco = Preco;
        this.estado = estado;
        this.numero_chassi = numero_chassi;
        this.numero_serie = numero_serie;
    }

    public Carro(String modelo, int ano, String cor, float preco, String estado, String numero_chassi, String numero_serie) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.Preco = preco;
        this.estado = estado;
        this.numero_chassi = numero_chassi;
        this.numero_serie = numero_serie;
    }
}
