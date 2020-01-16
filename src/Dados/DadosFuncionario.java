/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Classe.Funcionario;
import Interface.InterfaceFuncionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class DadosFuncionario extends ConexcaoJDBC implements InterfaceFuncionario {

    //Metódos da Classe
    public boolean verificarOcorrencia(Funcionario funcionario) throws Exception {

        super.abrirConexao();
        boolean retorno = false;

        String sql = " SELECT DISTINCT Matricula_Funcionario FROM ordemServico WHERE Matricula_Funcionario = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);
        instrucaoSQL.setInt(1, funcionario.getMatricula());
        instrucaoSQL.executeQuery();
        ResultSet resultSet = instrucaoSQL.getResultSet();
        while (resultSet.next()) {
            retorno = true;
            break;
        }

        super.fecharConexao();
        return retorno;

    }

    public int verificarExistencia(Funcionario funcionario) throws Exception {
        super.abrirConexao();

        String sql = " SELECT COUNT(cpf) AS existe FROM funcionario WHERE Cpf = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, funcionario.getCpf());

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
    public void cadastrarFuncionario(Funcionario funcionario) throws Exception {

        super.abrirConexao();

        String sql = " INSERT INTO Funcionario (Nome , Cpf , Rg ,  Salario) ";
        sql += "VALUES ( ? , ? , ? , ? )";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, funcionario.getNome());
        instrucaoSQL.setString(2, funcionario.getCpf());
        instrucaoSQL.setString(3, funcionario.getRg());
        instrucaoSQL.setFloat(4, funcionario.getSalario());

        instrucaoSQL.execute();

        super.fecharConexao();

    }

    @Override
    public void removerFuncionario(Funcionario funcionario) throws Exception {

        super.abrirConexao();

        String sql = " DELETE FROM Funcionario WHERE Matricula = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setInt(1, funcionario.getMatricula());

        instrucaoSQL.execute();
        super.fecharConexao();

    }

    @Override
    public void editarFuncionario(Funcionario funcionario) throws Exception {

        super.abrirConexao();

        String sql = " UPDATE Funcionario SET Nome = ?, ";
        sql += " Cpf = ? , ";
        sql += " Rg = ? , ";
        sql += " Salario = ?  ";
        sql += " WHERE Matricula = ? ";

        PreparedStatement instrucaoSQL = super.conn.prepareStatement(sql);

        instrucaoSQL.setString(1, funcionario.getNome());
        instrucaoSQL.setString(2, funcionario.getCpf());
        instrucaoSQL.setString(3, funcionario.getRg());
        instrucaoSQL.setFloat(4, funcionario.getSalario());
        instrucaoSQL.setInt(5, funcionario.getMatricula());

        instrucaoSQL.execute();

        super.fecharConexao();

    }

    @Override
    public ArrayList<Funcionario> listarFuncionarios(Funcionario funcionario) throws Exception {

        super.abrirConexao();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        String sql = " SELECT nome , cpf , rg , matricula , salario FROM Funcionario Where 0 = 0 ";

        if (funcionario.getNome() != null && funcionario.getNome().trim().equals("") == false) {
            sql += " AND nome LIKE ? ";
        }
        if (funcionario.getCpf() != null && funcionario.getCpf().trim().equals("") == false) {
            sql += " AND cpf LIKE ? ";
        }
        if (funcionario.getRg() != null && funcionario.getRg().trim().equals("") == false) {
            sql += " AND rg LIKE ? ";
        }
        if (funcionario.getMatricula() != 0) {
            sql += " AND matricula = ? ";
        }
        if (funcionario.getSalario() != 0) {
            sql += "AND salario = ? ";
        }

        PreparedStatement instrucaoSQL = conn.prepareStatement(sql);

        int contadorPosicao = 1;

        if (funcionario.getNome() != null && funcionario.getNome().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + funcionario.getNome() + "%");
            contadorPosicao++;
        }
        if (funcionario.getCpf() != null && funcionario.getCpf().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + funcionario.getCpf() + "%");
            contadorPosicao++;

        }
        if (funcionario.getRg() != null && funcionario.getRg().trim().equals("") == false) {
            instrucaoSQL.setString(contadorPosicao, "%" + funcionario.getRg() + "%");
            contadorPosicao++;
        }
        if (funcionario.getMatricula() != 0) {
            instrucaoSQL.setInt(contadorPosicao, funcionario.getMatricula());
            contadorPosicao++;
        }
        if (funcionario.getSalario() != 0) {
            instrucaoSQL.setFloat(contadorPosicao, funcionario.getSalario());
            contadorPosicao++;
        }

        ResultSet resultSet = instrucaoSQL.executeQuery();

        while (resultSet.next()) {

            Funcionario f = new Funcionario();

            f.setMatricula(resultSet.getInt("Matricula"));
            f.setNome(resultSet.getString("Nome"));
            f.setCpf(resultSet.getString("Cpf"));
            f.setRg(resultSet.getString("Rg"));
            f.setSalario(resultSet.getFloat("Salario"));

            funcionarios.add(f);

        }

        super.fecharConexao();
        return funcionarios;

    }

}
