/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classe.ClassificacaoProblema;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public interface InterfaceClassificacaoProblema {

    void cadastrarClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception;
    void removerClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception;
    void editarClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception;
    ArrayList<ClassificacaoProblema> listarClassificacaoProblemas(ClassificacaoProblema classificacaoProblema) throws Exception;

}
