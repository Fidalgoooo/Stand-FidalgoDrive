package Stand;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Settings {

    private static Stage primaryStage;

    protected static ObservableList<Carro> listaCarro = FXCollections.observableArrayList();
    protected static ObservableList<Venda> listaVenda = FXCollections.observableArrayList();
    protected static ObservableList<Vendedor> listaVendedor = FXCollections.observableArrayList();

    private static Carro CarroEdit;
    private static Venda VendaEdit;
    private static Vendedor VendedorEdit;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Settings.primaryStage = primaryStage;
    }

    public static ObservableList<Carro> getListacarro() {
        return listaCarro;
    }

    public static ObservableList<Venda> getListaVenda() {
        return listaVenda;
    }

    public static ObservableList<Vendedor> getListaVendedor() {
        return listaVendedor;
    }

    public static Carro getcarroEdit() {
        return CarroEdit;
    }

    public static void setcarroEdit(Carro CarroEdit) {
        Settings.CarroEdit = CarroEdit;
    }

    public static Venda getVendaEdit() {
        return VendaEdit;
    }

    public static void setVendaEdit(Venda VendaEdit) {
        Settings.VendaEdit = VendaEdit;
    }

    public static Vendedor getVendedorEdit() {
        return VendedorEdit;
    }

    public static void setVendedorEdit(Vendedor VendedorEdit) {
        Settings.VendedorEdit = VendedorEdit;
    }

    public static void Listacarro() {
        // Implementar lógica de listagem de carros
    }

    public static void ListaVenda() {
        // Implementar lógica de listagem de vendas
    }

    public static void ListaVendedor() {
        // Implementar lógica de listagem de vendedores
    }
}
