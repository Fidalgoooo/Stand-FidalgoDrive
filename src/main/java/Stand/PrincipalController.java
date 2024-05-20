package Stand;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import static Stand.Settings.*;

public class PrincipalController implements Initializable {
    public AnchorPane TelaCarro;
    public TableView TableViewCarro;
    public TableColumn TabelaModelo;
    public TableColumn TabelaAno;
    public TableColumn TabelaCor;
    public TableColumn TabelaEstado;
    public TableColumn TabelaChassi;
    public TableColumn TabelaSerie;
    public TextField txtIdCarro;
    public TextField txtModelo;
    public TextField txtAno;
    public TextField txtCor;
    public TextField txtPrecoCarro;
    public TextField txtChassi;
    public TextField txtEstadoCarro;
    public TextField txtSerieCarro;
    public AnchorPane TelaVenda;
    public TableView TableViewVenda;
    public TableColumn TabelaIdVenda;
    public TableColumn TabelaDataVenda;
    public TableColumn TabelaPrecoVenda;
    public TableColumn TabelaIdCarro;
    public TextField txtIdVenda;
    public TextField txtDataVenda;
    public TextField txtVendedor;
    public TextField txtVenda;
    public AnchorPane TelaVendedor;
    public TableView TableViewVendedor;
    public TableColumn TabelaIdVendedor;
    public TableColumn TabelaNomeVendedor;
    public TableColumn TabelaContactoVendedor;
    public TableColumn TabelaEmailVendedor;
    public TableColumn TabelaNifVendedor;
    public TextField txtIdVendedor;
    public TextField txtNomeVendedor;
    public TextField txtContactoVendedor;
    public TextField txtEmailVendedor;
    public TextField txtVendaVendedor;
    public TextField txtNifVendedor;
    public AnchorPane TelaAcercaDe;
    public Button btnCarro;
    public Button btnVenda;
    public Button btnVendedor;
    public Button btnSobreMim;
    public Button btnSair;
    public Button btnAdicionarCarro;
    public Button btnEditarCarro;
    public Button btnEliminarCarro;
    public Button btnAdicionarVenda;
    public Button btnEditarVenda;
    public Button btnEliminarVenda;
    public Button btnAdicionarVendedor;
    public Button btnEditarVendedor;
    public Button btnEliminarVendedor;
    public TableColumn TabelaModeloVenda;
    public TableColumn TabelaNomeVenda;
    public TableColumn TabelaNumeroVendas;
    public TableColumn TabelaPrecoCarro;
    public TextField txtPreco;
    public TextField txtNameVendedor;
    public TextField txtModeloVenda;
    public TextField txtNVenda;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TabelaCarro();// Método que inicializa a tabela com as configurações necessárias
        TabelaVendedor();
        TabelaVenda();
        System.out.println(Settings.getListacarro().size());
        System.out.println(Settings.getListaVenda().size());
        System.out.println(Settings.getListaVendedor().size());
    }

    //---------------------------------------------------------------------------------------------------------------//
// Métodos relacionados ao botão de carro
    public void btnCarroEntered() {
        btnCarro.setStyle("-fx-background-color: white; -fx-text-fill: #000;");
    }

    public void btnCarroExited() {
        btnCarro.setStyle("-fx-background-color: transparent; -fx-border-color: #fff;");
    }

    // Métodos relacionados ao botão de venda
    public void btnVendaEntered() {
        btnVenda.setStyle("-fx-background-color: white; -fx-text-fill: #000;");
    }

    public void btnVendaExited() {
        btnVenda.setStyle("-fx-background-color: transparent; -fx-border-color: #fff;");
    }

    // Métodos relacionados ao botão de vendedor
    public void btnVendedorEntered() {
        btnVendedor.setStyle("-fx-background-color: white; -fx-text-fill: #000;");
    }

    public void btnVendedorExited() {
        btnVendedor.setStyle("-fx-background-color: transparent; -fx-border-color: #fff;");
    }

    // Métodos relacionados ao botão de sair
    public void btnSairEntered() {
        btnSair.setStyle("-fx-background-color: white; -fx-text-fill: #000;");
    }

    public void btnSairExited() {
        btnSair.setStyle("-fx-background-color: transparent; -fx-border-color: #fff;");
    }

    // Métodos relacionados ao botão de adicionar venda
    public void btnAdicionarVendaEntered(){
        btnAdicionarVenda.setStyle("-fx-background-color: #999999; -fx-background-radius: 4px; -fx-text-fill: #000;");
    }

    public void btnAdicionarVendaExited(){
        btnAdicionarVenda.setStyle("-fx-background-color: #333333; -fx-background-radius: 4px; -fx-text-fill: #fff;");
    }

    // Métodos relacionados ao botão de editar venda
    public void btnEditarVendaEntered() {
        btnEditarVenda.setStyle("-fx-background-color: #999999; -fx-background-radius: 4px; -fx-text-fill: #000;");
    }

    public void btnEditarVendaExited() {
        btnEditarVenda.setStyle("-fx-background-color: #333333; -fx-background-radius: 4px; -fx-text-fill: #fff;");
    }

    // Métodos relacionados ao botão de eliminar venda
    public void btnEliminarVendaEntered() {
        btnEliminarVenda.setStyle("-fx-background-color: #999999; -fx-background-radius: 4px; -fx-text-fill: #000;");
    }

    public void btnEliminarVendaExited() {
        btnEliminarVenda.setStyle("-fx-background-color: #333333; -fx-background-radius: 4px; -fx-text-fill: #fff;");
    }

    // Métodos relacionados ao botão de adicionar vendedor
    public void btnAdicionarVendedorEntered(){
        btnAdicionarVendedor.setStyle("-fx-background-color: #9794ac; -fx-background-radius: 5px; -fx-text-fill: #000;");
    }

    public void btnAdicionarVendedorExited(){
        btnAdicionarVendedor.setStyle("-fx-background-color: #919de6; -fx-background-radius: 5px; -fx-text-fill: #fff;");
    }

    // Métodos relacionados ao botão de editar vendedor
    public void btnEditarVendedorEntered(){
        btnEditarVendedor.setStyle("-fx-background-color: #9794ac; -fx-background-radius: 5px; -fx-text-fill: #000;");
    }

    public void btnEditarVendedorExited(){
        btnEditarVendedor.setStyle("-fx-background-color: #919de6; -fx-background-radius: 5px; -fx-text-fill: #fff;");
    }

    // Métodos relacionados ao botão de eliminar vendedor
    public void btnEliminarVendedorEntered(){
        btnEliminarVendedor.setStyle("-fx-background-color: #9794ac; -fx-background-radius: 5px; -fx-text-fill: #000;");
    }

    public void btnEliminarVendedorExited(){
        btnEliminarVendedor.setStyle("-fx-background-color: #919de6; -fx-background-radius: 5px; -fx-text-fill: #fff;");
    }

//---------------------------------------------------------------------------------------------------------------//

    // Métodos genéricos para eventos de mouse em botões
    public void btnEntered(MouseEvent mouseEvent) {
    }

    public void btnAcercaDeEntered(MouseEvent mouseEvent) {
    }

    public void btnAcercaDeExited(MouseEvent mouseEvent) {
    }

//---------------------------------------------------------------------------------------------------------------//
    // Métodos para ações dos botões
    public void btnVendaOnAction() {
        TelaVenda.setVisible(true);
        TelaCarro.setVisible(false);
        TelaVendedor.setVisible(false);
        TelaAcercaDe.setVisible(false);
    }
    public void btnCarroOnAction() {
        TelaVenda.setVisible(false);
        TelaCarro.setVisible(true);
        TelaVendedor.setVisible(false);
        TelaAcercaDe.setVisible(false);
    }
    public void VendedorOnAction() {
        TelaVenda.setVisible(false);
        TelaCarro.setVisible(false);
        TelaVendedor.setVisible(true);
        TelaAcercaDe.setVisible(false);
    }
    public void SobreMimOnAction(){
        TelaVenda.setVisible(false);
        TelaCarro.setVisible(false);
        TelaVendedor.setVisible(false);
        TelaAcercaDe.setVisible(true);
    }

    // Método para sair do aplicativo
    public void sair() throws Exception {
        Platform.exit();
    }

    //---------------------------------------------------------------------------------------------------------------//
    public void AdicionarAction() throws SQLException {
        if (txtModelo.getText().isEmpty()
                || txtAno.getText().isEmpty()
                || txtCor.getText().isEmpty()
                || txtPrecoCarro.getText().isEmpty()
                || txtEstadoCarro.getText().isEmpty()
                || txtChassi.getText().isEmpty()
                || txtSerieCarro.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            // Obtém os valores dos campos
            String novoModelo = txtModelo.getText();
            int novoAno = Integer.parseInt(txtAno.getText());
            String novoCor = txtCor.getText();
            Double novoPreco = Double.parseDouble(txtPrecoCarro.getText());
            String novoEstado = txtEstadoCarro.getText();
            String novoNumeroChassi = txtChassi.getText();
            String novoNumeroSerie = txtSerieCarro.getText();


            // Verifica se o ID já existe na lista
            // Pergunta se deseja realmente adicionar em um alerta
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Adicionar");
            // Mostra o que será adicionado no alerta
            alert.setHeaderText("Deseja mesmo Adicionar?" + "\n" + "Modelo: " + novoModelo
                    + "\n" + "Ano: " + novoAno + "\n" + "Cor: " + novoCor + "\n" + "Preço: " + novoPreco + "\n" + "Estado: " + novoEstado + "\n" + "Número de Chassi: "
                    + novoNumeroChassi + "\n" + "Número de Série: " + novoNumeroSerie);
            // Adiciona botões personalizados em português
            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(botaoSim, botaoNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.isPresent() && choose.get() == botaoSim) {
                // Se escolher sim, adiciona à lista e avisa que foi inserido
                Carro newCarro = new Carro(novoModelo, novoAno, novoCor, novoPreco, novoEstado, novoNumeroChassi, novoNumeroSerie);
                int novoIdCarro = CarroDAO.addCarro(newCarro);
                newCarro.setIdCarro(novoIdCarro);
                System.out.println(novoIdCarro);
                Settings.getListacarro().add(newCarro);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Informação");
                alert1.setHeaderText(null);
                alert1.setContentText("O seu Carro foi inserido");
                alert1.showAndWait();
            } else {
                // Se for cancelado, também exibe um aviso
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText(null);
                alert2.setContentText("Cancelado com Sucesso");
                alert2.showAndWait();
            }
        }
    }
    public void EditarAction() {
        if (txtModelo.getText().isEmpty()
                || txtAno.getText().isEmpty()
                || txtCor.getText().isEmpty()
                || txtPrecoCarro.getText().isEmpty()
                || txtEstadoCarro.getText().isEmpty()
                || txtChassi.getText().isEmpty()
                || txtSerieCarro.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            Carro carroEdit = null;
            int novoIdcarro = Integer.parseInt(txtIdCarro.getText());
            for (Carro c : Settings.getListacarro()) {
                if (c.getIdCarro() == novoIdcarro) {
                    carroEdit = c;
                    break;
                }
            }
            if (carroEdit != null) {
                carroEdit.setModelo(txtModelo.getText());
                carroEdit.setAno(Integer.parseInt(txtAno.getText()));
                carroEdit.setCor(txtCor.getText());
                carroEdit.setPreco(Double.parseDouble(txtPrecoCarro.getText()));
                carroEdit.setEstado(txtEstadoCarro.getText());
                carroEdit.setNumero_chassi(txtChassi.getText());
                carroEdit.setNumero_serie(txtSerieCarro.getText());


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar");
                alert.setHeaderText("Deseja mesmo Editar?");
                ButtonType botaoSim = new ButtonType("Sim");
                ButtonType botaoNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(botaoSim, botaoNao);
                Optional<ButtonType> choose = alert.showAndWait();

                if (choose.isPresent() && choose.get() == botaoSim) {
                    // Provavelmente você teria uma maneira de atualizar os dados na interface ou no armazenamento
                    // Por exemplo, TableViewCarro.refresh() para atualizar uma tabela
                    // setcarroEdit(carroEdit); // Este método não está definido no código fornecido
                    // TableViewCarro.refresh(); // Este método também não está definido
                    try{
                        Connection conn = ConexaoBD.abrirBD();
                        if(conn != null) {
                            String update = "UPDATE carros SET modelo = ?, ano = ?, cor = ?, preco = ?, estado = ?, numero_chassi = ?, numero_serie = ? WHERE idCarro = ?;";
                            PreparedStatement stmt = conn.prepareStatement(update);
                            stmt.setString(1,txtModelo.getText());
                            stmt.setInt(2, Integer.parseInt(txtAno.getText()));
                            stmt.setString(3,txtCor.getText());
                            stmt.setDouble(4, Double.parseDouble(txtPreco.getText()));
                            stmt.setString(5,txtEstadoCarro.getText());
                            stmt.setString(6,txtChassi.getText());
                            stmt.setString(7,txtSerieCarro.getText());
                            stmt.setInt(8, novoIdcarro);

                            int atualizar = stmt.executeUpdate();
                            if(atualizar > 0){
                                for(Carro c : Settings.getListacarro()){
                                    if(c.getIdCarro() == carroEdit.getIdCarro()){
                                        int index = Settings.getListacarro().indexOf(c);
                                        Settings.getListacarro().set(index, carroEdit);
                                        break;
                                    }
                                }
                            }

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Informação");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Edição bem-sucedida");
                    alert1.showAndWait();
                    Settings.setcarroEdit(null);

                    TableViewCarro.refresh();
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Informação");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Cancelado com Sucesso");
                    alert2.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Esse ID não foi encontrado");
                alert.showAndWait();
            }
        }
    }
    public void EliminarAction(){
        if (txtIdCarro.getText().isEmpty()
                || txtModelo.getText().isEmpty()
                || txtAno.getText().isEmpty()
                || txtCor.getText().isEmpty()
                || txtPrecoCarro.getText().isEmpty()
                || txtEstadoCarro.getText().isEmpty()
                || txtChassi.getText().isEmpty()
                || txtSerieCarro.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor selecione algum Carro da tabela");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar");
            alert.setHeaderText("Deseja mesmo Eliminar?"+"\n"+
                    "ID: " + txtIdCarro.getText() + "\n" +
                    "Modelo: " + txtModelo.getText() + "\n" +
                    "Ano: " + txtAno.getText() + "\n" +
                    "Cor: " + txtCor.getText()+ "\n" +
                    "Preço: " + txtPrecoCarro.getText() + "\n" +
                    "Estado: " + txtEstadoCarro.getText() + "\n" +
                    "Chassi: " + txtChassi.getText() + "\n" +
                    "Número Serie: "  + txtSerieCarro.getText());

            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(botaoSim, botaoNao);
            Optional<ButtonType> choose = alert.showAndWait();
            if (choose.get() == botaoSim) {
                int novoId = Integer.parseInt(txtIdCarro.getText());
                for (Carro c : listaCarro) {
                    if (c.getIdCarro() == novoId) {
                        listaCarro.remove(c);
                        CarroDAO.removeCarro(novoId);
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Information");
                        alert1.setHeaderText(null);
                        alert1.setContentText("O seu Carro foi Eliminado");
                        alert1.showAndWait();
                        break;
                    }
                }
            }
            else{
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText(null);
                alert2.setContentText("Cancelado com Sucesso");
                alert2.showAndWait();
            }
        }
    }
    public void TabelaCarro() {
        TabelaIdCarro.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("idCarro"));
        TabelaModelo.setCellValueFactory(new PropertyValueFactory<Carro, String>("modelo"));
        TabelaAno.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("ano"));
        TabelaCor.setCellValueFactory(new PropertyValueFactory<Carro, String>("cor"));
        TabelaPrecoCarro.setCellValueFactory(new PropertyValueFactory<Carro, Double>("preco"));
        TabelaEstado.setCellValueFactory(new PropertyValueFactory<Carro, String>("estado"));
        TabelaChassi.setCellValueFactory(new PropertyValueFactory<Carro, String>("numero_chassi"));
        TabelaSerie.setCellValueFactory(new PropertyValueFactory<Carro, String>("numero_serie"));

        TableViewCarro.setItems(CarroDAO.listCarros());
    }
    public void CarroVerInfo() {
        Carro carroData = (Carro) TableViewCarro.getSelectionModel().getSelectedItem();
        if(Objects.nonNull(carroData)) {

            txtIdCarro.setText(String.valueOf(carroData.getIdCarro()));
            txtModelo.setText(carroData.getModelo());
            txtAno.setText(String.valueOf(carroData.getAno()));
            txtCor.setText(carroData.getCor());
            txtPrecoCarro.setText(String.valueOf(carroData.getPreco()));
            txtEstadoCarro.setText(carroData.getEstado());
            txtChassi.setText(carroData.getNumero_chassi());
            txtSerieCarro.setText(carroData.getNumero_serie());
        }
    }


    //---------------------------------------------------------------------------------------------------------------//
    public void AdicionarVendaOnAction() throws SQLException {
        if (txtDataVenda.getText().isEmpty()
                || txtPrecoCarro.getText().isEmpty()
                || txtNomeVendedor.getText().isEmpty()
                || txtModelo.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            // Obtém os valores dos campos
            String novoDataVenda = txtDataVenda.getText();
            double novoPreco = Double.parseDouble(txtPrecoCarro.getText());
            String novoNomeVendedor = txtNomeVendedor.getText();
            String novoModelo = txtModelo.getText();

            // Verifica se o ID já existe na lista
            // Pergunta se deseja realmente adicionar em um alerta
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Adicionar");
            // Mostra o que será adicionado no alerta
            alert.setHeaderText("Deseja mesmo Adicionar?" + "\n" + "DataVenda: " + novoDataVenda
                    + "\n" + "Preço: " + novoPreco + "\n" + "Nome: " + novoNomeVendedor + "\n" + "Modelo: " + novoModelo);
            // Adiciona botões personalizados em português
            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(botaoSim, botaoNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.isPresent() && choose.get() == botaoSim) {
                // Se escolher sim, adiciona à lista e avisa que foi inserido
                Venda newVenda = new Venda(novoDataVenda,novoPreco,novoNomeVendedor,novoModelo);
                int novoIdVenda = VendaDAO.addVenda(newVenda);
                newVenda.setIdVenda(novoIdVenda);
                System.out.println(novoIdVenda);
                Settings.getListaVenda().add(newVenda);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Informação");
                alert1.setHeaderText(null);
                alert1.setContentText("A sua Venda foi inserido");
                alert1.showAndWait();
            } else {
                // Se for cancelado, também exibe um aviso
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText(null);
                alert2.setContentText("Cancelado com Sucesso");
                alert2.showAndWait();
            }
        }
    }
    public void EditarVendaOnAction() {
        if (txtIdVenda.getText().isEmpty() || txtDataVenda.getText().isEmpty() || txtNomeVendedor.getText().isEmpty() || txtModeloVenda.getText().isEmpty()
                || txtPrecoCarro.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            Venda vendaEdit = null;
            int novoIdVenda = Integer.parseInt(txtIdVenda.getText());

            for (Venda venda : listaVenda) {
                if (venda.getIdVenda() == novoIdVenda) {
                    vendaEdit = venda;
                    break;
                }
            }

            if (vendaEdit != null) {
                vendaEdit.setDataVenda(txtDataVenda.getText());
                vendaEdit.setNome(txtNomeVendedor.getText());
                vendaEdit.setModelo(txtModeloVenda.getText());
                vendaEdit.setPrecoCarro(Double.parseDouble(txtPrecoCarro.getText()));

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar");
                alert.setHeaderText("Deseja mesmo Editar?");
                ButtonType botaoSim = new ButtonType("Sim");
                ButtonType botaoNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(botaoSim, botaoNao);
                Optional<ButtonType> choose = alert.showAndWait();

                if (choose.isPresent() && choose.get() == botaoSim) {
                    try {
                        Connection conn = ConexaoBD.abrirBD();
                        if (conn != null) {
                            String update = "UPDATE vendas SET dataVenda = ?, precoCarro = ?, nome = ?, modelo = ? WHERE idVenda = ?;";
                            PreparedStatement stmt = conn.prepareStatement(update);
                            stmt.setString(1, txtDataVenda.getText());
                            stmt.setString(2, txtPrecoCarro.getText());
                            stmt.setString(3, txtNomeVendedor.getText());
                            stmt.setString(4, txtModeloVenda.getText());
                            stmt.setInt(5, novoIdVenda);


                            int atualizar = stmt.executeUpdate();
                            if (atualizar > 0) {
                                for (Venda v : Settings.getListaVenda()) {
                                    if (v.getIdVenda() == vendaEdit.getIdVenda()) {
                                        int index = Settings.getListaVenda().indexOf(v);
                                        Settings.getListaVenda().set(index, vendaEdit);
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Informação");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Edição bem-sucedida");
                    alert1.showAndWait();
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Informação");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Cancelado com sucesso");
                    alert2.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Esse ID de venda não foi encontrado");
                alert.showAndWait();
            }
        }
    }
    public void EliminarVendaOnAction() {
        if (txtIdVenda.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione uma venda da tabela");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar");
            alert.setHeaderText("Deseja mesmo Eliminar?" + "\n" +
                    "ID: " + txtIdVenda.getText() + "\n" +
                    "Data da Venda: " + txtDataVenda.getText() + "\n" +
                    "Nome do Vendedor: " + txtNomeVendedor.getText() + "\n" +
                    "Modelo do Carro: " + txtModelo.getText() + "\n" +
                    "Preço do Carro: " + txtPrecoCarro.getText());

            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(botaoSim, botaoNao);
            Optional<ButtonType> escolha = alert.showAndWait();

            if (escolha.isPresent() && escolha.get() == botaoSim) {
                int novoId = Integer.parseInt(txtIdVenda.getText());
                for (Venda venda : listaVenda) {
                    if (venda.getIdVenda() == novoId) {
                        listaVenda.remove(venda);
                        VendaDAO.removeVenda(novoId);

                        // Aqui você pode adicionar a lógica para remover a venda do banco de dados ou de qualquer outra estrutura de dados

                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Informação");
                        alert1.setHeaderText(null);
                        alert1.setContentText("A venda foi eliminada com sucesso");
                        alert1.showAndWait();
                        break;
                    }
                }
            } else {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText(null);
                alert2.setContentText("Operação cancelada");
                alert2.showAndWait();
            }
        }
    }
    public void TabelaVenda() {
        TabelaIdVenda.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("idVenda"));
        TabelaDataVenda.setCellValueFactory(new PropertyValueFactory<Venda, String>("dataVenda"));
        TabelaPrecoVenda.setCellValueFactory(new PropertyValueFactory<Venda, Double>("precoCarro"));
        TabelaNomeVenda.setCellValueFactory(new PropertyValueFactory<Venda, String>("nome"));
        TabelaModeloVenda.setCellValueFactory(new PropertyValueFactory<Venda, String>("modelo"));

        TableViewVenda.setItems(VendaDAO.listVendas());
    }
    public void VendaVerInfo() {
        Venda vendaData = (Venda) TableViewVenda.getSelectionModel().getSelectedItem();
        if (Objects.nonNull(vendaData)) {
            txtIdVenda.setText(String.valueOf(vendaData.getIdVenda()));
            txtDataVenda.setText(String.valueOf(vendaData.getDataVenda()));
            txtPreco.setText(String.valueOf(vendaData.getPrecoCarro()));
            txtNomeVendedor.setText(String.valueOf(vendaData.getNome()));
            txtModeloVenda.setText(String.valueOf(vendaData.getModelo()));
        }
    }



    //---------------------------------------------------------------------------------------------------------------//
    public void AdicionarVendedorOnAction() throws SQLException {
        if (txtNomeVendedor.getText().isEmpty() || txtContactoVendedor.getText().isEmpty() || txtEmailVendedor.getText().isEmpty()
                || txtNifVendedor.getText().isEmpty() || txtNVenda.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            // Obtém os valores dos campos
            String novoNome = txtNomeVendedor.getText();
            String novoContacto = txtContactoVendedor.getText();
            String novoEmail = txtEmailVendedor.getText();
            String novoNIF = txtNifVendedor.getText();
            int novoNumeroVendas = Integer.parseInt(txtNVenda.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Adicionar");
            alert.setHeaderText("Deseja mesmo Adicionar?" + "\n" + "Nome: " + novoNome
                    + "\n" + "Contacto: " + novoContacto + "\n" + "Email: " + novoEmail + "\n" + "NIF: " + novoNIF
                    + "\n" + "Número de Vendas: " + novoNumeroVendas);
            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(botaoSim, botaoNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.isPresent() && choose.get() == botaoSim) {
                Vendedor novoVendedor = new Vendedor(0, novoNome, novoContacto, novoEmail, novoNIF, novoNumeroVendas);
                int novoIdVendedor = VendedorDAO.addVendedor(novoVendedor);
                novoVendedor.setIdVendedor(novoIdVendedor);
                Settings.getListaVendedor().add(novoVendedor);

                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Informação");
                alert1.setHeaderText(null);
                alert1.setContentText("O vendedor foi inserido com sucesso");
                alert1.showAndWait();
            } else {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText(null);
                alert2.setContentText("Cancelado com sucesso");
                alert2.showAndWait();
            }
        }
    }
    public void EditarVendedorOnAction() {
        if (txtIdVendedor.getText().isEmpty() || txtNomeVendedor.getText().isEmpty() || txtContactoVendedor.getText().isEmpty()
                || txtEmailVendedor.getText().isEmpty() || txtNifVendedor.getText().isEmpty() || txtNVenda.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Atenção");
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {
            Vendedor vendedorEdit = null;
            int novoIdVendedor = Integer.parseInt(txtIdVendedor.getText());

            for (Vendedor v : Settings.getListaVendedor()) {
                if (v.getIdVendedor() == novoIdVendedor) {
                    vendedorEdit = v;
                    break;
                }
            }

            if (vendedorEdit != null) {
                vendedorEdit.setNome(txtNomeVendedor.getText());
                vendedorEdit.setContacto(txtContactoVendedor.getText());
                vendedorEdit.setEmail(txtEmailVendedor.getText());
                vendedorEdit.setNif(txtNifVendedor.getText());
                vendedorEdit.setNumeroVendas(Integer.parseInt(txtNVenda.getText()));

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Editar");
                alert.setHeaderText("Deseja mesmo Editar?");
                ButtonType botaoSim = new ButtonType("Sim");
                ButtonType botaoNao = new ButtonType("Não");
                alert.getButtonTypes().setAll(botaoSim, botaoNao);
                Optional<ButtonType> choose = alert.showAndWait();

                if (choose.isPresent() && choose.get() == botaoSim) {
                    try {
                        Connection conn = ConexaoBD.abrirBD();
                        if (conn != null) {
                            String update = "UPDATE vendedores SET nome = ?, contacto = ?, email = ?, nif = ?, numeroVendas = ? WHERE idVendedor = ?;";
                            PreparedStatement stmt = conn.prepareStatement(update);
                            stmt.setString(1, txtNomeVendedor.getText());
                            stmt.setString(2, txtContactoVendedor.getText());
                            stmt.setString(3, txtEmailVendedor.getText());
                            stmt.setString(4, txtNifVendedor.getText());
                            stmt.setInt(5, Integer.parseInt(txtNVenda.getText()));
                            stmt.setInt(6, novoIdVendedor);

                            int atualizar = stmt.executeUpdate();
                            if (atualizar > 0) {
                                for (Vendedor v : Settings.getListaVendedor()) {
                                    if (v.getIdVendedor() == vendedorEdit.getIdVendedor()) {
                                        int index = Settings.getListaVendedor().indexOf(v);
                                        Settings.getListaVendedor().set(index, vendedorEdit);
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Informação");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Edição bem-sucedida");
                    alert1.showAndWait();
                    Settings.setVendedorEdit(null);

                    TableViewVendedor.refresh();
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Informação");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Cancelado com sucesso");
                    alert2.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Esse ID não foi encontrado");
                alert.showAndWait();
            }
        }
    }
    public void EliminarVendedorOnAction() {
        if (txtIdVendedor.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um vendedor da tabela");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar");
            alert.setHeaderText("Deseja mesmo Eliminar?" + "\n" +
                    "ID: " + txtIdVendedor.getText() + "\n" +
                    "Nome: " + txtNomeVendedor.getText() + "\n" +
                    "Contacto: " + txtContactoVendedor.getText() + "\n" +
                    "Email: " + txtEmailVendedor.getText() + "\n" +
                    "NIF: " + txtNifVendedor.getText() + "\n" +
                    "Número de Vendas: " + txtNVenda.getText());

            ButtonType botaoSim = new ButtonType("Sim");
            ButtonType botaoNao = new ButtonType("Não");
            alert.getButtonTypes().setAll(botaoSim, botaoNao);
            Optional<ButtonType> choose = alert.showAndWait();

            if (choose.get() == botaoSim) {
                int novoId = Integer.parseInt(txtIdVendedor.getText());
                for (Vendedor v : Settings.getListaVendedor()) {
                    if (v.getIdVendedor() == novoId) {
                        Settings.getListaVendedor().remove(v);
                        VendedorDAO.removeVendedor(novoId);

                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Informação");
                        alert1.setHeaderText(null);
                        alert1.setContentText("O vendedor foi eliminado com sucesso");
                        alert1.showAndWait();
                        break;
                    }
                }
            } else {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Informação");
                alert2.setHeaderText(null);
                alert2.setContentText("Cancelado com sucesso");
                alert2.showAndWait();
            }
        }
    }

    public void TabelaVendedor() {
        TabelaIdVendedor.setCellValueFactory(new PropertyValueFactory<Vendedor, Integer>("idVendedor"));
        TabelaNomeVendedor.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("nome"));
        TabelaContactoVendedor.setCellValueFactory(new PropertyValueFactory<Vendedor, Integer>("contacto"));
        TabelaEmailVendedor.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("email"));
        TabelaNifVendedor.setCellValueFactory(new PropertyValueFactory<Vendedor, String>("nif"));
        TabelaNumeroVendas.setCellValueFactory(new PropertyValueFactory<Vendedor, Integer>("numeroVendas"));

        TableViewVendedor.setItems(VendedorDAO.listVendedores());
    }

    public void VendedorVerInfo() {
        Vendedor vendedorData = (Vendedor) TableViewVendedor.getSelectionModel().getSelectedItem();
        if (Objects.nonNull(vendedorData)) {
            txtIdVendedor.setText(String.valueOf(vendedorData.getIdVendedor()));
            txtNameVendedor.setText(vendedorData.getNome());
            txtContactoVendedor.setText(vendedorData.getContacto());
            txtEmailVendedor.setText(vendedorData.getEmail());
            txtNifVendedor.setText(vendedorData.getNif());
            txtNVenda.setText(String.valueOf(vendedorData.getNumeroVendas()));
        }
    }
}
