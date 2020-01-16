/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Classe.ClassificacaoProblema;
import Dados.DadosClassificacaoProblema;
import Interface.InterfaceClassificacaoProblema;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class NegocioClassificacaoProblema implements InterfaceClassificacaoProblema {

    @Override
    public void cadastrarClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception {

        if (classificacaoProblema == null) {
            throw new Exception("Informe a Classificação Problema");
        }

        // Tratamento do Nome
        if (classificacaoProblema.getNome() == null || classificacaoProblema.getNome().trim().equals("")) {
            throw new Exception("Informe o nome da Classificação Problema");
        }
        if (classificacaoProblema.getNome().length() > 30) {
            throw new Exception("O nome da classificação problema excedeu o limete de caracteres");
        }

        // Tratamento Descrição
        if (classificacaoProblema.getDescricao().length() > 255) {
            throw new Exception("A descrição excedeu o número de caracteres");
        }
        if (classificacaoProblema.getDescricao().trim().equals("") || classificacaoProblema.getDescricao() == null) {
            throw new Exception("Insira uma descrição");
        }
        // Dados

        Dados.DadosClassificacaoProblema dados = new DadosClassificacaoProblema();
        dados.cadastrarClassificacaoProblema(classificacaoProblema);
    }

    @Override
    public void removerClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception {

        if (verificarOcorrencia(classificacaoProblema) == true) {
            throw new Exception("A Classificação Problema não pode ser removida \n Pois esta vinculada a uma ordem de Serviço");
        }

        //Dados
        Dados.DadosClassificacaoProblema dados = new DadosClassificacaoProblema();
        dados.removerClassificacaoProblema(classificacaoProblema);
    }

    @Override
    public void editarClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception {

        if (verificarOcorrencia(classificacaoProblema) == true)
        {
            throw new Exception("A Classificação Problema não pode ser alterada \n Pois esta vinculada a uma ordem de Serviço");
        }
        
        if (classificacaoProblema == null) {
            throw new Exception("Informe a Classificação Problema");
        }

        // Tratamento do Nome
        if (classificacaoProblema.getNome() == null || classificacaoProblema.getNome().trim().equals("")) {
            throw new Exception("Informe o nome da Classificação Problema");
        }
        if (classificacaoProblema.getNome().length() > 30) {
            throw new Exception("O nome da classificação problema excedeu o limete de caracteres");
        }

        // Tratamento Descrição
        if (classificacaoProblema.getDescricao().length() > 255) {
            throw new Exception("A descrição excedeu o número de caracteres");
        }
        if (classificacaoProblema.getDescricao().trim().equals("") || classificacaoProblema.getDescricao() == null) {
            throw new Exception("Insira uma descrição");
        }

        Dados.DadosClassificacaoProblema dados = new DadosClassificacaoProblema();
        dados.editarClassificacaoProblema(classificacaoProblema);
    }

    @Override
    public ArrayList<ClassificacaoProblema> listarClassificacaoProblemas(ClassificacaoProblema classificacaoProblema) throws Exception {

        //Dados
        Dados.DadosClassificacaoProblema dados = new DadosClassificacaoProblema();
        dados.listarClassificacaoProblemas(classificacaoProblema);
        return null;
    }

    private boolean verificarOcorrencia(ClassificacaoProblema classificacaoProblema) throws Exception {

        DadosClassificacaoProblema dados = new DadosClassificacaoProblema();
        return dados.verificarOcorrencia(classificacaoProblema);

    }

    
}
