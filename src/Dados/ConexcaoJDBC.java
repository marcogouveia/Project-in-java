/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pichau
 */
public class ConexcaoJDBC {

    public Connection conn;

    private final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private final String LOCAL_SERVIDOR = "localhost";
    private final String BANCO_DE_DADOS = "projetoOsPoo";
    private final String PORTA_BANCO = "3306";
    private final String USUARIO = "root";
    private final String SENHA = "";

    public void abrirConexao() throws Exception {

        Class.forName(DRIVER_MYSQL).newInstance();

        String url = "jdbc:mysql://" + LOCAL_SERVIDOR + ":" + PORTA_BANCO + "/" + BANCO_DE_DADOS;

        conn = (Connection) DriverManager.getConnection(url, USUARIO, SENHA);
    }

    public void fecharConexao() throws Exception {

        conn.close();
    }

}
