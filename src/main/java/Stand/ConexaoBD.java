package Stand;

import java.sql.*;

public class ConexaoBD {
    private static String driverJDBC = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/standb";
    private static Connection conn = null;

    public static Connection abrirBD() {
        //Driver do MySQL
        try {
            Class.forName(driverJDBC);
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro na ligação à base de dados!!!: " + ex);
        }
        return conn;
    }

    public static void fecharBD(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a Ligação à base de dados: "+ex);
        }
    }
    public static void fecharBD(Statement stmt){
        fecharBD();
        try {
            if(stmt != null){
                stmt.close();
            }
        }catch (SQLException ex){
            System.out.println("Erro ao fechar a Ligação à base de dados: "+ex);
        }
    }
    public static void fecharBD(Statement stmt, ResultSet rs){
        fecharBD(stmt);
        try {
            if(rs != null){
                rs.close();
            }
        }catch(SQLException ex){
            System.out.println("Erro ao fechar a Ligação à base de dados: "+ex);
        }
    }
}