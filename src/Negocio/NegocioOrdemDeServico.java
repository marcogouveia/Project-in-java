/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Classe.OrdemDeServico;
import Dados.DadosOrdemDeServico;
import Interface.InterfaceOrdemServico;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class NegocioOrdemDeServico implements InterfaceOrdemServico {

    @Override
    public void cadastrarOrdemServico(OrdemDeServico ordemServico) throws Exception {

        if (ordemServico == null) {
            throw new Exception("Ordem de Serviço invalida");
        }

        //Descrição
        if (ordemServico.getDescricaoProblema().length() > 255) {
            throw new Exception("Número de Caracteres excedido");
        }

        //Data
        if (ordemServico.getDataCadastro() == null) {
            throw new Exception("Insira a Data");
        }
        if (ordemServico.getDataCadastro().toString().length() != 10){
            throw new Exception("Insira a Data");
        }

        //Cpf
        if (ordemServico.getCliente().getCpf() == null || ordemServico.getCliente().getCpf().trim().equals("")) {
            throw new Exception("Informe Cpf");
        }

        //Matricula
        if (ordemServico.getFuncionario().getMatricula() <= 0) {
            throw new Exception("Informe a Matricula");
        }

        //Código
        if (ordemServico.getClassificacaoProblema().getCodigo() <= 0) {
            throw new Exception("Informe o Código");
        }

        // Dados
        DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.cadastrarOrdemServico(ordemServico);
    }

    @Override
    public void removerOrdemServico(OrdemDeServico ordemServico) throws Exception {

        //Dados

        Dados.DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.removerOrdemServico(ordemServico);

    }

    @Override
    public void editarOrdemServico(OrdemDeServico ordemServico) throws Exception {

        if (ordemServico == null) {
            throw new Exception("Ordem de Serviço invalida");
        }

        //Descrição
        if (ordemServico.getDescricaoProblema().length() > 255) {
            throw new Exception("Número de Caracteres excedido");
        }

        //Cpf
        if (ordemServico.getCliente().getCpf() == null || ordemServico.getCliente().getCpf().trim().equals("")) {
            throw new Exception("Informe Cpf");
        }

        //Matricula
        if (ordemServico.getFuncionario().getMatricula() <= 0) {
            throw new Exception("Informe a Matricula");
        }

        //Código
        if (ordemServico.getClassificacaoProblema().getCodigo() <= 0) {
            throw new Exception("Informe o Código");
        }

        // Dados
        DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.editarOrdemServico(ordemServico);
    }

    @Override
    public ArrayList<OrdemDeServico> listarOrdemServicos(OrdemDeServico ordemServico) throws Exception {

        //Dados
        DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.listarOrdemServicos(ordemServico);
        return null;
    }

    @Override
    public ArrayList<OrdemDeServico> listarOrdemServicosEmAberto(OrdemDeServico ordemDeServico) throws Exception {

        //Dados
        DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.listarOrdemServicosEmAberto(ordemDeServico);
        return null;
    }

    @Override
    public void cancelarOrdemServico(OrdemDeServico ordemDeServico) throws Exception {
        
        //Tramento Data
        
        if (ordemDeServico.getDataCancelamento() == null || ordemDeServico.getDataCancelamento().equals("")){
            throw new Exception ("Informe a data de cancelamento ");
        }
        
        //Tratamento de Motivo 
        
        if (ordemDeServico.getMotivoCancelamento() == null || ordemDeServico.getMotivoCancelamento().equals("")){
            throw new Exception ("Informe o motivo do cancelamento ");
        }
        if (ordemDeServico.getMotivoCancelamento().length() > 255){
            throw new Exception ("Número de caracteres excedido no motivo de cancelamento ");
        }
       
        //Dados

        DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.cancelarOrdemServico(ordemDeServico);

    }

    @Override
    public void solucionarOrdemServico(OrdemDeServico ordemDeServico) throws Exception {

        //Tratamento Data
        
        if (ordemDeServico.getDataSolucao() == null || ordemDeServico.getDataSolucao().equals("")){
            throw new Exception ("Informe a data de cancelamento ");
        }
        
        
        //Tratamento Descrição
        if (ordemDeServico.getDescricaoServico() == null || ordemDeServico.getDescricaoServico().trim().equals("")){
            throw new Exception ("Informe a descrição do serviço ");
        }
        if (ordemDeServico.getDescricaoServico().length() > 255){
            throw new Exception ("Número de caracteres excedidos na descrição");
        }

        //Dados
        DadosOrdemDeServico dados = new DadosOrdemDeServico();
        dados.solucionarOrdemServico(ordemDeServico);
    }

}
