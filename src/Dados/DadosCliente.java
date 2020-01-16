/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Classe.Cliente;
import Interface.InterfaceCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class DadosCliente extends ConexcaoJDBC implements InterfaceCliente {

    public boolean verificarOcorrencia(Cliente cliente) throws Exception {

        super.abrirConexao();
        boolean retorno = false;

        String sql = " SELECT DISTINCT cpf_cliente FROM ordemServico WHERE cpf_cliente = ?";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);
        instrucaoSQL.setString(1, cliente.getCpf());
        instrucaoSQL.executeQuery();
        ResultSet resultSet = instrucaoSQL.getResultSet();
        while (resultSet.next()) {
            retorno = true;
            break;
        }

        super.fecharConexao();
        return retorno;

    }

    public int verificarExistencia(Cliente cliente) throws Exception {
        super.abrirConexao();

        String sql = " SELECT COUNT(cpf) AS existe FROM cliente WHERE Cpf = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, cliente.getCpf());

        instrucaoSQL.executeQuery();

        ResultSet resultSet = instrucaoSQL.getResultSet();
        int retorno = 0;

        while (resultSet.next()) {
            retorno = resultSet.getInt("existe");
        }
        super.fecharConexao();

        if (retorno != 0) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws Exception {
        super.abrirConexao();
        String sql = " INSERT INTO Cliente ( Nome , Cpf , Rg) ";
        sql += " VALUES (? , ? , ?) ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, cliente.getNome());
        instrucaoSQL.setString(2, cliente.getCpf());
        instrucaoSQL.setString(3, cliente.getRg());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();
    }

    @Override
    public void removerCliente(Cliente cliente) throws Exception {
        super.abrirConexao();

        String sql = " DELETE FROM Cliente WHERE Cpf = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, cliente.getCpf());

        instrucaoSQL.execute();

        super.fecharConexao();
    }

    @Override
    public void editarCliente(Cliente clienteNovo, Cliente clienteVelho) throws Exception {

        super.abrirConexao();

        String sql = " UPDATE Cliente SET Nome = ? , Cpf = ? , Rg = ? ";
        sql += " WHERE Cpf = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, clienteNovo.getNome());
        instrucaoSQL.setString(2, clienteNovo.getCpf());
        instrucaoSQL.setString(3, clienteNovo.getRg());
        instrucaoSQL.setString(4, clienteVelho.getCpf());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();

    }

    @Override
    public ArrayList<Cliente> listarClientes(Cliente cliente) throws Exception {

        super.abrirConexao();
        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = " SELECT nome , cpf , rg FROM Cliente Where 0 = 0 ";

        if (cliente.getNome() != null && cliente.getNome().trim().equals("") == false) {
            sql += " AND nome LIKE ? ";
        }
        if (cliente.getCpf() != null && cliente.getCpf().trim().equals("") == false) {
            sql += " AND cpf LIKE ? ";
        }
        if (cliente.getRg() != null && cliente.getRg().trim().equals("") == false) {
            sql += " AND rg LIKE ? ";
        }

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        int contadorPosicao = 1;

        if (cliente.getNome() != null && cliente.getNome().trim().equals("") == false) {
            preparedStatement.setString(contadorPosicao, "%" + cliente.getNome() + "%");
            contadorPosicao++;
        }
        if (cliente.getCpf() != null && cliente.getCpf().trim().equals("") == false) {
            preparedStatement.setString(contadorPosicao, "%" + cliente.getCpf() + "%");
            contadorPosicao++;

        }
        if (cliente.getRg() != null && cliente.getRg().trim().equals("") == false) {
            preparedStatement.setString(contadorPosicao, "%" + cliente.getRg() + "%");
            contadorPosicao++;
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            Cliente c = new Cliente();

            c.setCpf(resultSet.getString("cpf"));
            c.setNome(resultSet.getString("nome"));
            c.setRg(resultSet.getString("rg"));

            clientes.add(c);

        }

        super.fecharConexao();
        return clientes;

    }

    //@Override
    /*public Cliente listarUmCliente(Cliente cliente) throws Exception {

        super.abrirConexao();

        String sql = " SELECT nome , cpf , rg FROM Cliente WHERE Cpf = ?";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, cliente.getCpf());

        instrucaoSQL.execute();

        ResultSet resultSet = instrucaoSQL.getResultSet();

        Cliente clienteUnico = null;

        while (resultSet.next()) {

            Cliente c = new Cliente();

            c.setNome(resultSet.getString("Nome"));
            c.setCpf(resultSet.getString("Cpf"));
            c.setRg(resultSet.getString("Rg"));

            clienteUnico = c;

        }

        super.fecharConexao();
        return clienteUnico;

    }*/
}
