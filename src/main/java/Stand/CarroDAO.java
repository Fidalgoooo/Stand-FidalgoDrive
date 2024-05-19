package Stand;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.JavaFXBuilderFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    public static int addCarro(Carro c){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        int idCarro = 0;

        String sql = "INSERT INTO carros(modelo, ano, cor, preco, estado, numero_chassi, numero_serie) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try{
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, c.getModelo());
            stmt.setInt(2, c.getAno());
            stmt.setString(3, c.getCor());
            stmt.setFloat(4, c.getPreco());
            stmt.setString(5, c.getEstado());
            stmt.setString(6, c.getNumero_chassi());
            stmt.setString(7, c.getNumero_serie());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                idCarro = rs.getInt(1);
            }
            System.out.println("Carro adicionado com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao adicionar novo carro: "+ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
        return idCarro;
    }

    public static ObservableList<Carro> listCarros(){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<Carro> carros = Settings.getListacarro();
        String sql = "SELECT * FROM carros;";

        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idCarro");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                String cor = rs.getString("cor");
                float preco = rs.getFloat("preco");
                String estado = rs.getString("estado");
                String numero_chassi = rs.getString("numero_chassi");
                String numero_serie = rs.getString("numero_serie");
                Carro carro = new Carro(id, modelo, ano, cor, preco, estado, numero_chassi, numero_serie);
                carros.add(carro);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao listar os carros: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt, rs);
        }
        return carros;
    }
    public static Carro searchForID(int id) {
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Carro carro = null;

        String sql = "SELECT * FROM carros WHERE idCarro = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                String cor = rs.getString("cor");
                float preco = rs.getFloat("preco");
                String estado = rs.getString("estado");
                String numero_chassi = rs.getString("numero_chassi");
                String numero_serie = rs.getString("numero_serie");
                carro = new Carro(id, modelo, ano, cor, preco, estado, numero_chassi, numero_serie);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao pesquisar o carro: "+ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt, rs);
        }
        return carro;
    }


    public static void removeCarro(int id){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM carros WHERE idCarro = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Carro eliminado com sucesso");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao eliminar carro: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
    }
    public static void updateCarro(Carro c){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;

        String sql = "UPDATE carros SET modelo = ?, ano = ?, cor = ?, preco = ?, estado = ?, numero_chassi = ?, numero_serie = ? WHERE id = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getModelo());
            stmt.setInt(2, c.getAno());
            stmt.setString(3, c.getCor());
            stmt.setFloat(4, c.getPreco());
            stmt.setString(5, c.getEstado());
            stmt.setString(6, c.getNumero_chassi());
            stmt.setString(7, c.getNumero_serie());
            stmt.setInt(8, c.getIdCarro());
            stmt.executeUpdate();
            System.out.println("Carro atualizado com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar carro: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
    }
}