/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class Funcionario extends Pessoa {

   

    private int matricula;
    private float salario;

    // Contrutor vazio
    public Funcionario() {

    }

    // Construtor com Todos os Dados;
    public Funcionario(ArrayList<OrdemDeServico> ordemServicos, int matricula, float salario) {
        
        this.matricula = matricula;
        this.salario = salario;
    }

    // Getters & Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    

}
