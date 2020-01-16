/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.Date;

/**
 *
 * @author Pichau
 */
public class OrdemDeServico {

    private int numero;
    private String motivoCancelamento, descricaoProblema, descricaoServico, Status;
    private Date dataCancelamento, dataCadastro, dataSolucao;

    private Funcionario funcionario;
    private Cliente cliente;
    private ClassificacaoProblema classificacaoProblema;

    //Construtor 
    public OrdemDeServico() {
        this.funcionario = new Funcionario();
        this.cliente = new Cliente();
        this.classificacaoProblema = new ClassificacaoProblema();
    }

    public String Status() {
        String retorno = "Aberta";

        if (this.dataCancelamento != null) {
            retorno = "Cancelada";
        } else if (this.dataSolucao != null) {
            retorno = "Solucionada";
        }

        return retorno;

    }

    // Getters & Setters
    public String getStatus() {
        return Status();
    }

    public void setStatus(String Status) {
        this.Status = Status();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataSolucao() {
        return dataSolucao;
    }

    public void setDataSolucao(Date dataSolucao) {
        this.dataSolucao = dataSolucao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClassificacaoProblema getClassificacaoProblema() {
        return classificacaoProblema;
    }

    public void setClassificacaoProblema(ClassificacaoProblema classificacaoProblema) {
        this.classificacaoProblema = classificacaoProblema;
    }

}
