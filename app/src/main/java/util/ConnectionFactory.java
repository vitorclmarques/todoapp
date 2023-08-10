/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 *
 * @author vitor
 * 
 * Essa classe está criando a conexão com o banco de dados MySQL.
 * 
 */
public class ConnectionFactory {
      
    
    
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/todoapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private static Connection connection;
    //metodo para a abrir a conexão com o banco de dados 
    public ConnectionFactory() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    public static Connection getConnection() {
        return connection;
    }
    
//    public static Connection getConnection() {
//        try{
//            
//            return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
//        } catch(Exception ex){
//            throw new RuntimeException("Erro de conexão com o banco de dados", ex);
//        }
//    }
//    
    //metodo para fechar a conexão com o banco de dados
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    
    public static void closeConnection(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    //metodo para fechar a conexão com o banco de dados
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try{
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try{
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
}
