/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.ProjectController;

/**
 *
 * @author Mariana Rocha
 */

public static void main(String[] args) {
    
    ProjectController projectController = new ProjectController();

    Project project = new Project();
    project.setName("Projeto Teste");
    project.setDescription("description");
    projectController.save(project);

    project.setName("Novo nome do projeto");
    projectController.update(project);

    List<Project> projects = projectController.getAll();
    System.out.println("Total de Projetos = " + projects.size());
    
}