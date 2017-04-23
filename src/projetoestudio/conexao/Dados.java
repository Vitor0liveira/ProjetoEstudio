/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestudio.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vitor Oliveira
 */
public class Dados {

    //Propriedades da classe Dados, evitando o sql injection
    private Statement stmt;
    public Connection conn;
   
    //Conectar BD
    private java.sql.Statement conectar()throws ClassNotFoundException, 
            SQLException{
        return this.conectarSqlServer();
    }
    //Metodo desconectar BD
    private void desconectar() throws SQLException{
        conn.close();
    }
   
    private java.sql.Statement conectarSqlServer() throws 
            ClassNotFoundException, SQLException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost;DatabaseName=Estudio";
        String usuario = "projeto";
        String senha = "123";
        Class.forName(driver);
        //Obtem uma conexao com o sgbd
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }
}
