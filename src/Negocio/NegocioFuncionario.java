/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Classe.Funcionario;
import Dados.DadosFuncionario;
import Interface.InterfaceFuncionario;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class NegocioFuncionario implements InterfaceFuncionario {

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws Exception {

        if (verificarExistencia(funcionario) == 1) {
            throw new Exception("Funcionario já Cadastrado");
        }

        //Tratamento do objeto
        if (funcionario == null) {
            throw new Exception("Insira os dados do Funcionário");
        }

        //Tratamento nome
        if (funcionario.getNome().trim().equals("") || funcionario.getNome() == null) {
            throw new Exception("Insira o nome do funcionário");
        }

        if (funcionario.getNome().length() > 100) {
            throw new Exception("O nome excedeu o número de caracteres");
        }

        //Tratamento CPF  
        if (funcionario.getCpf().length() != 11) {
            throw new Exception("O CPF precisa conter 11 digitos");
        }
        if (funcionario.getCpf().trim().equals("") || funcionario.getCpf() == null) {
            throw new Exception("Informe o CPF do funcionário");
        }

        //Tratamento RG
        if (funcionario.getRg().trim().equals("") || funcionario.getRg() == null) {
            throw new Exception("Informe o RG do funcionário");
        }
        if (funcionario.getRg().length() < 6 || funcionario.getRg().length() > 10) {
            throw new Exception("O Rg deve conter 6 a 10 digitos");
        }

        //Tratamento Salário 
        if (funcionario.getSalario() == 0) {
            throw new Exception("Preencha o Salário");
        }
        if (funcionario.getSalario() < 0) {
            throw new Exception("Salário inválido");
        }
        if (funcionario.getSalario() > 99999999) {
            throw new Exception("Limite do salário excedido");
        }

        // Dados
        DadosFuncionario dados = new DadosFuncionario();
        dados.cadastrarFuncionario(funcionario);
    }

    @Override
    public void removerFuncionario(Funcionario funcionario) throws Exception {

        if (verificarOcorrencia(funcionario) == true) {
            throw new Exception("Funcionario Não Pode ser removido \n Pois Existe Ordem De Serviço Atrelada ao mesmo ");
        }
        if (verificarExistencia(funcionario) == 1) {
            throw new Exception("O funcionario não existe");
        }

        //Dados
        DadosFuncionario dados = new DadosFuncionario();
        dados.removerFuncionario(funcionario);
    }

    @Override
    public void editarFuncionario(Funcionario funcionario) throws Exception {
        
        if (verificarOcorrencia(funcionario) == true){
            throw new Exception("Funcionario Não Pode ser alterado \n Pois Existe Ordem De Serviço Atrelada ao mesmo ");
        }
        if (funcionario == null) {
            throw new Exception("Informe os dados do funcionário");
        }
        

        //Tratamento Nome
        if (funcionario.getNome().trim().equals("") || funcionario.getNome() == null) {
            throw new Exception("Informe o nome do funcionário");
        }
        if (funcionario.getNome().length() > 100) {
            throw new Exception("O nome excedeu o limite de caracteres");
        }
        //Tratamento CPF
        if (funcionario.getCpf().trim().equals("") || funcionario.getCpf() == null) {
            throw new Exception("Infome o CPF do funcionário");
        }
        if (funcionario.getCpf().length() != 11) {
            throw new Exception("O CPF precisa conter 11 digitos");
        }
        //Tratamento RG
        if (funcionario.getRg().trim().equals("") || funcionario.getRg() == null) {
            throw new Exception("Informe o RG do funcionário.");
        }
        if (funcionario.getRg().length() < 6 || funcionario.getRg().length() > 10) {
            throw new Exception("O Rg deve conter 6 a 10 digitos");
        }
        //Tratamento Salario
        if (funcionario.getSalario() <= 0) {
            throw new Exception("Salário inválido");
        }
        if (funcionario.getSalario() > 99999999) {
            throw new Exception("Limite do salário excedido");
        }

        //Dados
        DadosFuncionario dados = new DadosFuncionario();
        dados.editarFuncionario(funcionario);
    }

    @Override
    public ArrayList<Funcionario> listarFuncionarios(Funcionario funcionario) throws Exception {

        //Dados
        DadosFuncionario dados = new DadosFuncionario();
        dados.listarFuncionarios(funcionario);
        return null;
    }

    private boolean verificarOcorrencia(Funcionario funcionario) throws Exception {

        DadosFuncionario dados = new DadosFuncionario();
        return dados.verificarOcorrencia(funcionario);

    }

    private int verificarExistencia(Funcionario funcionario) throws Exception {
        DadosFuncionario dados = new DadosFuncionario();
        return dados.verificarExistencia(funcionario);

    }

}
