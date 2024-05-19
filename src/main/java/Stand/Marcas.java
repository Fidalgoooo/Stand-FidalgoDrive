package Stand;

public class Marcas {
    private int idMarca;
    private String nome_marca;
    private String pais_origem;

    // Getters e Setters
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca;
    }

    public String getPais_origem() {
        return pais_origem;
    }

    public void setPais_origem(String pais_origem) {
        this.pais_origem = pais_origem;
    }

    public Marcas(int idMarca) {
        this.idMarca = idMarca;
    }

    public Marcas(int idMarca, String nome_marca, String pais_origem) {
        this.idMarca = idMarca;
        this.nome_marca = nome_marca;
        this.pais_origem = pais_origem;
    }
}