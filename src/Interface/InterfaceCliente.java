/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classe.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public interface InterfaceCliente {

    void cadastrarCliente(Cliente cliente) throws Exception;
    void removerCliente(Cliente cliente) throws Exception;
    void editarCliente(Cliente clienteNovo, Cliente clienteVelho) throws Exception;
    ArrayList<Cliente> listarClientes(Cliente cliente) throws Exception;

}
