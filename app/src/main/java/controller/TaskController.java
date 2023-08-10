/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author vitor
 */
public class TaskController {
    
    
    //Controler para salvar tarefas conectando com o banco de dados todoapp 
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject, " 
                + "name," 
                + "description," 
                + "notes,"
                + "completed,"
                + "deadline," 
                + "creatAt," 
                + "updateAt ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
            Connection  connection = null;
            PreparedStatement statement = null;
         
         try {
             
             //estabelecendo conexão
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5,task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa" 
                    + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
          
        }
    }
     //Controler para alterar tarefas conectando com o banco de dados todoapp 
    public void update(Task task){
          String sql = "UPDATE tasks SET " 
                + "idProject = ?, " 
                + "name = ?," 
                + "description = ?," 
                + "notes = ?,"
                + "completed = ?,"
                + "deadline = ?," 
                + "creatAt = ?," 
                + "updateAt = ? "
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
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5,task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //executando a query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao atualizar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    //Controler para remover  tarefas conectando com o banco de dados todoapp 
    public void removeById(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelecendo a conexão com o banco de dados
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando valores 
            statement.setInt(1, taskId);
            
            //executando a query
            statement.execute();      
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao deletar a tarefa");
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }    
    public List<Task> getAll (int idProject){
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?"; 
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //lista de tarefas que sera devolvida quando a chamada do metodo acontecer
        List<Task> tasks =  new ArrayList<Task>();
        
        try {
            
            //Criando a conexão 
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);
            
            //Valor retornado pela execução da query 
            resultSet = statement.executeQuery();
            
            //enquanto houver valores na variavel resultSet 
            while(resultSet.next()){
                
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCratedAt(resultSet.getDate("creatAT"));
                task.setUpdatedAt(resultSet.getDate("updateAt"));
                
                tasks.add(task);
                
            }
            
        } catch (Exception ex) {
            throw new RuntimeException ("Erro ao listar a tarefa" + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        //Lista de tarefa que foi criada e carregada no banco de dados;
        return tasks;
    }
}
