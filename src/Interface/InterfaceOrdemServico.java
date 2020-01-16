/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classe.OrdemDeServico;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public interface InterfaceOrdemServico {

    void cadastrarOrdemServico(OrdemDeServico ordemDeServico) throws Exception;
    void removerOrdemServico(OrdemDeServico ordemDeServico) throws Exception;
    void editarOrdemServico(OrdemDeServico ordemDeServico) throws Exception;
    ArrayList<OrdemDeServico> listarOrdemServicos(OrdemDeServico ordemDeServico) throws Exception;
    ArrayList<OrdemDeServico> listarOrdemServicosEmAberto(OrdemDeServico ordemDeServico) throws Exception;
    void cancelarOrdemServico(OrdemDeServico ordemDeServico) throws Exception;
    void solucionarOrdemServico(OrdemDeServico ordemDeServico) throws Exception;

}
