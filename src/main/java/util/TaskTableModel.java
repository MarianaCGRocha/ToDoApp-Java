/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author Mariana Rocha
 */
public class TaskTableModel extends AbstractTableModel {

    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList();

    @Override
    //Método Abstrato que diz quantos projetos existem cadastrados
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    //Método Abstrato que diz quantas colunas existem
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Método pertencente à classe Pai AbstractTableModel que indica que, a partir do
        //index de uma coluna ou linha, aquela linha ou coluna passa a ser editável ou não
        return columnIndex == 3;
//        Abaixo temos a forma mais verbosa de fazer esse processo, acima a mais otimizada
//        if(columnIndex == 3) {
//            return true;
//        } else {
//            return false;
//        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //Método da Classe Pai AbstractTableModel que retorna o tipo de dados
        //armazenados em cada coluna (String, int, boolean, etc)
        if(tasks.isEmpty()) {
        //Verifica se a lista de tarefas é vazia e retorna a lista de tarefas
        //como um object
            return Object.class;
        }
        //Se a lista NÃO estiver vazia: chama o método getValueAt() > pega a
        //primeira linha (ex: name - String) e retorna a classe daquele dado
        return this.getValueAt(0, columnIndex).getClass();
        //Analisamos apenas a Row 0 pois todos os dados nas outras Rows são do
        //mesmo tipo da coluna 0
    }

    @Override
    //Método Abstrato quais valores devem ser exibidos nas colunas e linhas
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();

            case 1:
                return tasks.get(rowIndex).getDescription();

            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadLine());

            case 3:
                return tasks.get(rowIndex).isIsCompleted();

            case 4:
                return " ";

            case 5:
                return " ";

            default:
                return "Dados não encontrados";
        }

    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
