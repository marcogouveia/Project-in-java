/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Classe.OrdemDeServico;
import Interface.InterfaceOrdemServico;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class DadosOrdemDeServico extends ConexcaoJDBC implements InterfaceOrdemServico {

    @Override
    public void cadastrarOrdemServico(OrdemDeServico ordemDeServico) throws Exception {

        super.abrirConexao();

        String sql = " INSERT INTO ordemservico ( descricaoproblema , datacadastro , cpf_cliente , matricula_funcionario , codigo_classificacao )  ";
        sql += " Values ( ? , ? , ?  , ? , ? ) ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, ordemDeServico.getDescricaoProblema());
        instrucaoSQL.setDate(2, (Date) ordemDeServico.getDataCadastro());
        instrucaoSQL.setString(3, ordemDeServico.getCliente().getCpf());
        instrucaoSQL.setInt(4, ordemDeServico.getFuncionario().getMatricula());
        instrucaoSQL.setInt(5, ordemDeServico.getClassificacaoProblema().getCodigo());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();
    }

    @Override
    public void removerOrdemServico(OrdemDeServico ordemDeServico) throws Exception {

        super.abrirConexao();

        String sql = "DELETE FROM OrdemServico WHERE numero = ? AND DataCancelamento IS NULL AND DataSolucao IS NULL ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setInt(1, ordemDeServico.getNumero());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();

    }

    @Override
    public void editarOrdemServico(OrdemDeServico ordemDeServico) throws Exception {
        super.abrirConexao();

        String sql = " UPDATE ordemservico SET descricaoproblema = ? , matricula_funcionario = ? ";
        sql += " , cpf_cliente = ? , codigo_classificacao = ? ";
        sql += " WHERE numero = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, ordemDeServico.getDescricaoProblema());
        instrucaoSQL.setInt(2, ordemDeServico.getFuncionario().getMatricula());
        instrucaoSQL.setString(3, ordemDeServico.getCliente().getCpf());
        instrucaoSQL.setInt(4, ordemDeServico.getClassificacaoProblema().getCodigo());
        instrucaoSQL.setInt(5, ordemDeServico.getNumero());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();

    }

    @Override
    public ArrayList<OrdemDeServico> listarOrdemServicos(OrdemDeServico ordemDeServico) throws Exception {

        super.abrirConexao();

        String sql = " SELECT Os.numero as numeroOrdem , Os.descricaoproblema as descricaoproblemaOrdem , Os.datacadastro as datacadastroOrdem ,"
                + " Os.datacancelamento as datacancelamentoOrdem , Os.datasolucao as datasolucaoOrdem , Os.descricaoservico as descricaoservicoOrdem ,"
                + " Os.motivocancelamento as motivocancelamentoOrdem , funcionario.matricula as 'matriculafuncionario' , funcionario.nome as nomefuncionario ,"
                + " funcionario.salario as salariofuncionario , funcionario.rg as rgfuncionario , funcionario.cpf as cpffuncionario , cliente.cpf as cpfcliente ,"
                + " cliente.rg as rgcliente , cliente.nome as nomecliente , classificacaoproblema.codigo as codigoclassificacaoproblema ,\n"
                + "classificacaoproblema.nome as nomeclassificacaoproblema , classificacaoproblema.descricao as descricaoclassificacaoproblema\n"
                + "\n"
                + "FROM ordemservico as Os\n"
                + "Join cliente on Os.cpf_cliente = cliente.cpf\n"
                + "join funcionario on Os.matricula_funcionario = funcionario.matricula\n"
                + "join classificacaoproblema on Os.codigo_classificacao = classificacaoproblema.codigo"
                + " WHERE 0 = 0";

        if (ordemDeServico.getNumero() != 0) {
            sql += " AND Os.numero = ? ";
        }
        if (ordemDeServico.getDescricaoProblema() != null && ordemDeServico.getDescricaoProblema().trim().equals("") == false) {
            sql += " AND Os.descricaoproblema LIKE ? ";
        }
        if (ordemDeServico.getDataCadastro() != null) {
            sql += " AND Os.datacadastro LIKE ? ";
        }
        if (ordemDeServico.getDataCancelamento() != null) {
            sql += " AND Os.datacancelamento LIKE ? ";
        }
        if (ordemDeServico.getDataSolucao() != null) {
            sql += " AND Os.datasolucao LIKE ? ";
        }
        if (ordemDeServico.getDescricaoServico() != null && ordemDeServico.getDescricaoServico().trim().equals("") == false) {
            sql += " AND Os.descricacaoservico LIKE ? ";
        }
        if (ordemDeServico.getMotivoCancelamento() != null && ordemDeServico.getMotivoCancelamento().trim().equals("") == false) {
            sql += " AND Os.motivocancelamento LIKE ? ";
        }
        if (ordemDeServico.getFuncionario().getMatricula() != 0) {
            sql += " AND Os.matricula_funcionario = ? ";
        }
        if (ordemDeServico.getCliente().getCpf() != null && ordemDeServico.getCliente().getCpf().trim().equals("") == false) {
            sql += " AND Os.cpf_cliente LIKE ? ";
        }
        if (ordemDeServico.getClassificacaoProblema().getCodigo() != 0) {
            sql += " AND Os.codigo_classificacao = ? ";
        }

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        int contadorPosicao = 1;

        if (ordemDeServico.getNumero() != 0) {
            instrucaoSQL.setInt(contadorPosicao, ordemDeServico.getNumero());
            contadorPosicao++;

        }
        if (ordemDeServico.getDescricaoProblema() != null && ordemDeServico.getDescricaoProblema().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + ordemDeServico.getDescricaoProblema() + "%");
            contadorPosicao++;
        }
        if (ordemDeServico.getDataCadastro() != null) {
            instrucaoSQL.setDate(contadorPosicao, (Date) ordemDeServico.getDataCadastro());
            contadorPosicao++;
        }
        if (ordemDeServico.getDataCancelamento() != null) {
            instrucaoSQL.setDate(contadorPosicao, (Date) ordemDeServico.getDataCancelamento());
            contadorPosicao++;

        }
        if (ordemDeServico.getDataSolucao() != null) {
            instrucaoSQL.setDate(contadorPosicao, (Date) ordemDeServico.getDataSolucao());
            contadorPosicao++;

        }
        if (ordemDeServico.getDescricaoServico() != null && ordemDeServico.getDescricaoServico().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + ordemDeServico.getDescricaoServico() + "%");
            contadorPosicao++;
        }
        if (ordemDeServico.getMotivoCancelamento() != null && ordemDeServico.getMotivoCancelamento().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + ordemDeServico.getMotivoCancelamento() + "%");
            contadorPosicao++;
        }
        if (ordemDeServico.getFuncionario().getMatricula() != 0) {
            instrucaoSQL.setInt(contadorPosicao, ordemDeServico.getFuncionario().getMatricula());
            contadorPosicao++;

        }
        if (ordemDeServico.getCliente().getCpf() != null && ordemDeServico.getCliente().getCpf().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + ordemDeServico.getCliente().getCpf() + "%");
            contadorPosicao++;

        }
        if (ordemDeServico.getClassificacaoProblema().getCodigo() != 0) {
            instrucaoSQL.setInt(contadorPosicao, ordemDeServico.getClassificacaoProblema().getCodigo());
            contadorPosicao++;
        }

        ArrayList<OrdemDeServico> OrdemServicos = new ArrayList<>();

        ResultSet resultSet = instrucaoSQL.executeQuery();
        while (resultSet.next()) {

            OrdemDeServico os = new OrdemDeServico();

            os.setNumero(resultSet.getInt("numeroOrdem"));
            os.setDescricaoProblema(resultSet.getString("descricaoproblemaOrdem"));
            os.setDataCadastro(resultSet.getDate("datacadastroOrdem"));
            os.setDataCancelamento(resultSet.getDate("datacancelamentoOrdem"));
            os.setDataSolucao(resultSet.getDate("datasolucaoOrdem"));
            os.setDescricaoServico(resultSet.getString("descricaoservicoOrdem"));
            os.setMotivoCancelamento(resultSet.getString("motivoCancelamentoOrdem"));

            os.getCliente().setCpf(resultSet.getString("cpfcliente"));
            os.getCliente().setNome(resultSet.getString("nomecliente"));
            os.getCliente().setRg(resultSet.getString("rgcliente"));

            os.getFuncionario().setCpf(resultSet.getString("cpffuncionario"));
            os.getFuncionario().setMatricula(resultSet.getInt("matriculafuncionario"));
            os.getFuncionario().setNome(resultSet.getString("nomefuncionario"));
            os.getFuncionario().setRg(resultSet.getString("rgfuncionario"));
            os.getFuncionario().setSalario(resultSet.getFloat("salariofuncionario"));

            os.getClassificacaoProblema().setCodigo(resultSet.getInt("codigoclassificacaoproblema"));
            os.getClassificacaoProblema().setDescricao(resultSet.getString("descricaoclassificacaoproblema"));
            os.getClassificacaoProblema().setNome(resultSet.getString("nomeclassificacaoproblema"));

            OrdemServicos.add(os);
        }

        super.fecharConexao();
        return OrdemServicos;

    }

    @Override
    public void cancelarOrdemServico(OrdemDeServico ordemDeServico) throws Exception {
        super.abrirConexao();

        String sql = " UPDATE ordemservico SET datacancelamento = ? , motivocancelamento = ? WHERE numero = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setDate(1, (Date) ordemDeServico.getDataCancelamento());
        instrucaoSQL.setString(2, ordemDeServico.getMotivoCancelamento());
        instrucaoSQL.setInt(3, ordemDeServico.getNumero());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();

    }

    @Override
    public void solucionarOrdemServico(OrdemDeServico ordemDeServico) throws Exception {
        super.abrirConexao();

        String sql = " UPDATE ordemservico SET datasolucao = ? , descricaoservico = ? WHERE numero = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setDate(1, (Date) ordemDeServico.getDataSolucao());
        instrucaoSQL.setString(2, ordemDeServico.getDescricaoServico());
        instrucaoSQL.setInt(3, ordemDeServico.getNumero());

        instrucaoSQL.executeUpdate();

        super.fecharConexao();
    }

    @Override
    public ArrayList<OrdemDeServico> listarOrdemServicosEmAberto(OrdemDeServico ordemDeServico) throws Exception {
        super.abrirConexao();

        String sql = " SELECT Os.numero as numeroOrdem , Os.descricaoproblema as descricaoproblemaOrdem , Os.datacadastro as datacadastroOrdem ,"
                + " Os.datacancelamento as datacancelamentoOrdem , Os.datasolucao as datasolucaoOrdem , Os.descricaoservico as descricaoservicoOrdem ,"
                + " Os.motivocancelamento as motivocancelamentoOrdem , funcionario.matricula as 'matriculafuncionario' , funcionario.nome as nomefuncionario ,"
                + " funcionario.salario as salariofuncionario , funcionario.rg as rgfuncionario , funcionario.cpf as cpffuncionario , cliente.cpf as cpfcliente ,"
                + " cliente.rg as rgcliente , cliente.nome as nomecliente , classificacaoproblema.codigo as codigoclassificacaoproblema ,\n"
                + "classificacaoproblema.nome as nomeclassificacaoproblema , classificacaoproblema.descricao as descricaoclassificacaoproblema\n"
                + "\n"
                + "FROM ordemservico as Os\n"
                + "Join cliente on Os.cpf_cliente = cliente.cpf\n"
                + "join funcionario on Os.matricula_funcionario = funcionario.matricula\n"
                + "join classificacaoproblema on Os.codigo_classificacao = classificacaoproblema.codigo"
                + " WHERE Os.datasolucao IS NULL AND Os.datacancelamento IS NULL AND Os.motivocancelamento IS NULL AND Os.descricaoservico IS NULL ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        ArrayList<OrdemDeServico> OrdemServicosEmAberto = new ArrayList<>();

        instrucaoSQL.executeQuery();

        ResultSet resultSet = instrucaoSQL.getResultSet();

        while (resultSet.next()) {

            OrdemDeServico os = new OrdemDeServico();

            os.setNumero(resultSet.getInt("numeroOrdem"));
            os.setDescricaoProblema(resultSet.getString("descricaoproblemaOrdem"));
            os.setDataCadastro(resultSet.getDate("datacadastroOrdem"));
            os.setDataCancelamento(resultSet.getDate("datacancelamentoOrdem"));
            os.setDataSolucao(resultSet.getDate("datasolucaoOrdem"));
            os.setDescricaoServico(resultSet.getString("descricaoservicoOrdem"));
            os.setMotivoCancelamento(resultSet.getString("motivoCancelamentoOrdem"));

            os.getCliente().setCpf(resultSet.getString("cpfcliente"));
            os.getCliente().setNome(resultSet.getString("nomecliente"));
            os.getCliente().setRg(resultSet.getString("rgcliente"));

            os.getFuncionario().setCpf(resultSet.getString("cpffuncionario"));
            os.getFuncionario().setMatricula(resultSet.getInt("matriculafuncionario"));
            os.getFuncionario().setNome(resultSet.getString("nomefuncionario"));
            os.getFuncionario().setRg(resultSet.getString("rgfuncionario"));
            os.getFuncionario().setSalario(resultSet.getFloat("salariofuncionario"));

            os.getClassificacaoProblema().setCodigo(resultSet.getInt("codigoclassificacaoproblema"));
            os.getClassificacaoProblema().setDescricao(resultSet.getString("descricaoclassificacaoproblema"));
            os.getClassificacaoProblema().setNome(resultSet.getString("nomeclassificacaoproblema"));

            OrdemServicosEmAberto.add(os);

        }

        super.fecharConexao();
        return OrdemServicosEmAberto;
    }

}
