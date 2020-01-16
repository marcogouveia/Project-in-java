/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Classe.ClassificacaoProblema;
import Interface.InterfaceClassificacaoProblema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class DadosClassificacaoProblema extends ConexcaoJDBC implements InterfaceClassificacaoProblema {

    public boolean verificarOcorrencia(ClassificacaoProblema classificacaoProblema) throws Exception {

        super.abrirConexao();
        boolean retorno = false;

        String sql = " SELECT DISTINCT codigo_classificacao FROM ordemServico WHERE codigo_classificacao = ?";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);
        instrucaoSQL.setInt(1, classificacaoProblema.getCodigo());
        instrucaoSQL.executeQuery();
        ResultSet resultSet = instrucaoSQL.getResultSet();
        while (resultSet.next()) {
            retorno = true;
            break;
        }

        super.fecharConexao();
        return retorno;

    }

    @Override
    public void cadastrarClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception {

        super.abrirConexao();

        String sql = " INSERT INTO ClassificacaoProblema (Nome , Descricao) ";
        sql += "VALUES ( ? , ?)";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, classificacaoProblema.getNome());
        instrucaoSQL.setString(2, classificacaoProblema.getDescricao());

        instrucaoSQL.execute();
        super.fecharConexao();

    }

    @Override
    public void removerClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception {

        super.abrirConexao();

        String sql = " DELETE FROM ClassificacaoProblema WHERE Codigo = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setInt(1, classificacaoProblema.getCodigo());

        instrucaoSQL.execute();
        super.fecharConexao();

    }

    @Override
    public void editarClassificacaoProblema(ClassificacaoProblema classificacaoProblema) throws Exception {

        super.abrirConexao();

        String sql = " UPDATE  ClassificacaoProblema SET nome = ? , ";
        sql += " descricao = ? ";
        sql += " WHERE codigo = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, classificacaoProblema.getNome());
        instrucaoSQL.setString(2, classificacaoProblema.getDescricao());
        instrucaoSQL.setInt(3, classificacaoProblema.getCodigo());

        instrucaoSQL.execute();
        super.fecharConexao();

    }

    @Override
    public ArrayList<ClassificacaoProblema> listarClassificacaoProblemas(ClassificacaoProblema classificacaoProblema) throws Exception {

        super.abrirConexao();

        ArrayList<ClassificacaoProblema> retorno = new ArrayList<>();

        String sql = "SELECT codigo , descricao , nome FROM ClassificacaoProblema WHERE 0 = 0";

        if (classificacaoProblema.getNome() != null && classificacaoProblema.getNome().trim().equals("") == false) {
            sql += " AND nome LIKE ? ";
        }
        if (classificacaoProblema.getDescricao() != null && classificacaoProblema.getDescricao().trim().equals("") == false) {
            sql += " AND descricao LIKE ? ";
        }
        if (classificacaoProblema.getCodigo() != 0) {
            sql += " AND codigo = ? ";
        }

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        int contadorPosicao = 1;

        if (classificacaoProblema.getNome() != null && classificacaoProblema.getNome().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + classificacaoProblema.getNome() + "%");
            contadorPosicao++;
        }
        if (classificacaoProblema.getDescricao() != null && classificacaoProblema.getDescricao().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + classificacaoProblema.getDescricao() + "%");
        }
        if (classificacaoProblema.getCodigo() != 0) {
            instrucaoSQL.setInt(contadorPosicao, classificacaoProblema.getCodigo());
        }

        ResultSet resultSet = instrucaoSQL.executeQuery();

        while (resultSet.next()) {

            ClassificacaoProblema c = new ClassificacaoProblema();

            c.setCodigo(resultSet.getInt("Codigo"));
            c.setDescricao(resultSet.getString("Descricao"));
            c.setNome(resultSet.getString("Nome"));

            retorno.add(c);

        }

        super.fecharConexao();
        return retorno;

    }

}
