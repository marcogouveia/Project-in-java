/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classe.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public interface InterfaceFuncionario {

    void cadastrarFuncionario(Funcionario funcionario) throws Exception;
    void removerFuncionario(Funcionario funcionario) throws Exception;
    void editarFuncionario(Funcionario funcionario) throws Exception;
    ArrayList<Funcionario> listarFuncionarios(Funcionario funcionario) throws Exception;

}
