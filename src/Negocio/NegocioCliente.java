/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Classe.Cliente;
import Dados.DadosCliente;
import Interface.InterfaceCliente;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class NegocioCliente implements InterfaceCliente {

    @Override
    public void cadastrarCliente(Cliente cliente) throws Exception {

        if (verificarExistencia(cliente) == 1) {
            throw new Exception("O Cliente já cadastrado ");
        }
        

        //Tratamento do objeto
        if (cliente == null) {
            throw new Exception("Informe os dados do cliente ");
        }

        // Tratamento de Nome
        if (cliente.getNome().trim().equals("") || cliente.getNome() == null) {

            throw new Exception("Insira o nome do cliente ");

        }
        if (cliente.getNome().length() > 100) {
            throw new Exception("Número de caracteres excedidos");
        }

        // Tratamento Cpf
        if (cliente.getCpf().length() != 11) {
            throw new Exception("O Cpf deve conter 11 números");
        }

        if (cliente.getCpf() == null) {
            throw new Exception("Informe o Cpf");
        }

        if (cliente.getCpf().trim().equals("")) {
            throw new Exception("Informe o Cpf");
        }

        //Tratamento Rg
        if (cliente.getRg().length() < 6 || cliente.getRg().length() > 10) {
            throw new Exception("O Rg deve conter 6 a 10 digitos");
        }

        if (cliente.getRg() == null) {
            throw new Exception("Informe o Rg");
        }

        if (cliente.getRg().trim().equals("")) {
            throw new Exception("Informe o Rg");
        }
        //Dados
        DadosCliente dados = new DadosCliente();
        dados.cadastrarCliente(cliente);
    }

    @Override
    public void removerCliente(Cliente cliente) throws Exception {

        if (verificarOcorrencia(cliente) == true) {
            throw new Exception("Cliente Não Pode ser removido \n Pois Existe Ordem De Serviço Atrelada ao mesmo ");
        }
        if (verificarExistencia(cliente) == 0) {
            throw new Exception("O cliente não existe");
        }
        // Dados

        DadosCliente dados = new DadosCliente();
        dados.removerCliente(cliente);
    }

    @Override
    public void editarCliente(Cliente clienteNovo, Cliente clienteVelho) throws Exception {
        
        if (verificarOcorrencia(clienteVelho) == true) {
            throw new Exception("Cliente Não Pode ser alterado \n Pois Existe Ordem De Serviço Atrelada ao mesmo ");
        }
        
        if (clienteNovo == null) {
            throw new Exception("Insira os dados do novo cliente");
        }

        //Tratamento de nome
        if (clienteNovo.getNome() == null || clienteNovo.getNome().trim().equals("")) {
            throw new Exception("Insira o novo nome do cliente");
        }

        if (clienteNovo.getNome().trim().length() > 100) {
            throw new Exception("O novo nome do cliente excedeu o limite de caracteres");
        }

        //Tratamento de Cpf
        if (clienteNovo.getCpf() == null || clienteNovo.getCpf().trim().equals("")) {
            throw new Exception("Insira o novo Cpf");
        }

        if (clienteNovo.getCpf().length() != 11) {
            throw new Exception("O Cpf deve conter 11 números");
        }

        //Tratamento de Rg
        if (clienteNovo.getRg() == null || clienteNovo.getRg().trim().equals("")) {
            throw new Exception("Insira o novo Rg");
        }
        if (clienteNovo.getRg().length() < 6 || clienteNovo.getRg().length() > 10) {
            throw new Exception("O Rg deve conter 6 a 10 digitos");
        }

        //Dados
        DadosCliente dados = new DadosCliente();
        dados.editarCliente(clienteNovo, clienteVelho);
    }

    @Override
    public ArrayList<Cliente> listarClientes(Cliente cliente) throws Exception {

        //Dados
        DadosCliente dados = new DadosCliente();
        dados.listarClientes(cliente);
        return null;
    }

    
    private boolean verificarOcorrencia(Cliente cliente) throws Exception {

        DadosCliente dados = new DadosCliente();
        return dados.verificarOcorrencia(cliente);

    }

    private int verificarExistencia(Cliente cliente) throws Exception {
        DadosCliente dados = new DadosCliente();
        return dados.verificarExistencia(cliente);

    }

}
