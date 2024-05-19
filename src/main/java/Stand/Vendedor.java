package Stand;

public class Vendedor {
    private int idVendedor;
    private String nome;
    private String contacto;
    private String email;
    private String nif;
    private int numeroVendas;

    // Construtor sem ID, para criar novos vendedores sem ID inicial
    public Vendedor(String nome, String contacto, String email, String nif, int numeroVendas) {
        this.nome = nome;
        this.contacto = contacto;
        this.email = email;
        this.nif = nif;
        this.numeroVendas = numeroVendas;
    }

    // Construtor completo com ID, para criar vendedores a partir de registros do banco de dados
    public Vendedor(int idVendedor, String nome, String contacto, String email, String nif, int numeroVendas) {
        this.idVendedor = idVendedor;
        this.nome = nome;
        this.contacto = contacto;
        this.email = email;
        this.nif = nif;
        this.numeroVendas = numeroVendas;
    }

    // Getters e Setters
    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getNumeroVendas() {
        return numeroVendas;
    }

    public void setNumeroVendas(int numeroVendas) {
        this.numeroVendas = numeroVendas;
    }

}