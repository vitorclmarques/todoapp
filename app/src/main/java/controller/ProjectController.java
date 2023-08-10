/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author vitor
 */
public class ProjectController {
      public void save(Project project) {
        String sql = "INSERT INTO projects (name," 
                + "description,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?)";
        
        Connection connection = null ;
        PreparedStatement statement = null ;

        try {
            // Obtenha uma conexão com o banco de dados
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);

            
           
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto: " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        
     }
    } 
     public void update(Project project){
          String sql = "UPDATE projects SET " 
                + "name = ?," 
                + "description = ?," 
                + "createdAt = ?," 
                + "updatedAt = ?"
                + "WHERE id = ?";
          
        Connection  connection = null;
        PreparedStatement statement = null;
        try {
            //estabelecendo a conexão com o banco de dados
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando valores 
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
            //executando a query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao atualizar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
            System.out.println("tarefa concluida");
        }
         
     
     }
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects"; 
        
        List<Project> projects = new ArrayList<>();
                
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
       try {
            
            //Criando a conexão 
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Valor retornado pela execução da query 
            resultSet = statement.executeQuery();
            
            //enquanto houver valores na variavel resultSet 
            while(resultSet.next()){
                
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAT"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                projects.add(project);
                
            }
            
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao listar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        
        return projects;
    }
    
     public void removeById(int idProject) {
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecendo a conexão com o banco de dados
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando valores 
            statement.setInt(1, idProject);
            
            //executando a query
            statement.execute();      
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao deletar a tarefa");
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
     }
}
