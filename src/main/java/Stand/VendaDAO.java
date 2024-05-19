package Stand;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAO {

    public static int addVenda(Venda venda){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        int idVenda = 0;

        String sql = "INSERT INTO vendas(dataVenda, precoCarro, nome, modelo) VALUES (?, ?, ?, ?);";

        try{
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, venda.getDataVenda());
            stmt.setFloat(2, venda.getPrecoCarro());
            stmt.setString(3, venda.getNome());
            stmt.setString(4, venda.getModelo());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                idVenda = rs.getInt(1);
            }
            System.out.println("Venda adicionada com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao adicionar nova venda: "+ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
        return idVenda;
    }

    public static ObservableList<Venda> listVendas(){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<Venda> vendas = Settings.getListaVenda();

        String sql = "SELECT * FROM vendas;";

        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVenda = rs.getInt("idVenda");
                String dataVenda = rs.getString("dataVenda");
                float precoCarro = rs.getFloat("PrecoCarro");
                String nome = rs.getString("nome");
                String modelo = rs.getString("modelo");
                Venda venda = new Venda(idVenda, dataVenda, precoCarro, nome, modelo);
                vendas.add(venda);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao listar as vendas: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt, rs);
        }
        return vendas;
    }

    public static Venda searchForID(int id){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venda venda = null;

        String sql = "SELECT * FROM vendas WHERE idVenda = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                String dataVenda = rs.getString("dataVenda");
                float precoCarro = rs.getFloat("PrecoCarro");
                String nome = rs.getString("nome");
                String modelo = rs.getString("modelo");
                venda = new Venda(id, dataVenda, precoCarro, nome, modelo);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao pesquisar a venda: "+ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt, rs);
        }
        return venda;
    }

    public static void removeVenda(int id){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM vendas WHERE idVenda = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Venda eliminada com sucesso");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao eliminar venda: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
    }

    public static void updateVenda(Venda venda){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;

        String sql = "UPDATE vendas SET dataVenda = ?, precoCarro = ?, nome = ?, modelo = ? WHERE idVenda = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, venda.getDataVenda());
            stmt.setFloat(2, venda.getPrecoCarro());
            stmt.setString(3, venda.getNome());
            stmt.setString(4, venda.getModelo());
            stmt.setInt(5, venda.getIdVenda());
            stmt.executeUpdate();
            System.out.println("Venda atualizada com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar venda: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
    }
}
