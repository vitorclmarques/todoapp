/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.ProjectController;
import controller.TaskController;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;


/**
 *
 * @author vitor
 */
public class TesteController {
    
    public static void main(String[] args){
        
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        task.setIdProject(2);
        task.setName("Teste tarefa no projeto 2");
        task.setDescription("Description teste");
        task.setNotes("Sem notas");
        task.setIsCompleted(true);
        task.setDeadline(new Date());
        
        taskController.save(task);
        

//        task.setName("Teste tarefa alterada no projeto 2");
//        task.setId(2);
//        task.setIdProject(2);
//        taskController.update(task);
        
        
        
        
        
//     ProjectController projectController = new ProjectController();
//
//        // Crie uma instância de Project com os dados adequados
//        Project project = new Project();
//        project.setName("Projeto teste");
//        project.setDescription("Description");
//        project.setCreatedAt(new java.util.Date());
//        project.setUpdatedAt(new java.util.Date());
//        
//        projectController.save(project);
//        
//        
//        project.setName("Projeto teste");
//        project.setId(2);
//        projectController.update(project);
//
//        
//        
//        
//       ProjectController projectController = new ProjectController();
//       
//       Project project  =  new Project();
//       
//      project.setName("Projeto Teste");
//       project.setDescription("description");
//       projectController.save(project);
//        List<Project> projects = projectController.getAll();
//        System.out.println("Total de projetos = " + projects.size());
    }
    
    }
