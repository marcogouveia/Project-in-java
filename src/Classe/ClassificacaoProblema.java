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
public class ClassificacaoProblema {

    

    private int codigo;
    private String descricao;
    private String nome;

    // Construtor vazio
    public ClassificacaoProblema() {

    }

    // Construtor com Todos os Dados
    public ClassificacaoProblema(ArrayList<OrdemDeServico> ordemServicos, int codigo, String nome) {
        
        this.codigo = codigo;
        this.nome = nome;
    }

    // Getters & Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
