package Stand;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    public static int addVendedor(Vendedor vendedor){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        int idVendedor = 0;

        String sql = "INSERT INTO vendedores(nome, contacto, email, nif, numeroVendas) VALUES (?, ?, ?, ?, ?);";

        try{
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getContacto());
            stmt.setString(3, vendedor.getEmail());
            stmt.setString(4, vendedor.getNif());
            stmt.setInt(5, vendedor.getNumeroVendas());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                idVendedor = rs.getInt(1);
            }
            System.out.println("Vendedor adicionado com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao adicionar novo vendedor: "+ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
        return idVendedor;
    }

    public static ObservableList<Vendedor> listVendedores(){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<Vendedor> vendedores = Settings.getListaVendedor();

        String sql = "SELECT * FROM vendedores;";

        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idVendedor");
                String nome = rs.getString("nome");
                String contacto = rs.getString("contacto");
                String email = rs.getString("email");
                String nif = rs.getString("nif");
                int numeroVendas = rs.getInt("numeroVendas");
                Vendedor vendedor = new Vendedor(id, nome, contacto, email, nif, numeroVendas);
                vendedores.add(vendedor);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao listar os vendedores: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt, rs);
        }
        return vendedores;
    }

    public static Vendedor searchForID(int id) {
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;

        String sql = "SELECT * FROM vendedores WHERE idVendedor = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String contacto = rs.getString("contacto");
                String email = rs.getString("email");
                String nif = rs.getString("nif");
                int numeroVendas = rs.getInt("numeroVendas");
                vendedor = new Vendedor(id, nome, contacto, email, nif, numeroVendas);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao pesquisar o vendedor: "+ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt, rs);
        }
        return vendedor;
    }

    public static void removeVendedor(int id){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM vendedores WHERE idVendedor = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Vendedor eliminado com sucesso");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao eliminar vendedor: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
    }

    public static void updateVendedor(Vendedor vendedor){
        Connection conn = ConexaoBD.abrirBD();
        PreparedStatement stmt = null;

        String sql = "UPDATE vendedores SET nome = ?, contacto = ?, email = ?, nif = ?, numeroVendas = ? WHERE idVendedor = ?;";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getContacto());
            stmt.setString(3, vendedor.getEmail());
            stmt.setString(4, vendedor.getNif());
            stmt.setInt(5, vendedor.getNumeroVendas());
            stmt.setInt(6, vendedor.getIdVendedor());
            stmt.executeUpdate();
            System.out.println("Vendedor atualizado com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar vendedor: " + ex);
        }
        finally {
            ConexaoBD.fecharBD(stmt);
        }
    }
}
