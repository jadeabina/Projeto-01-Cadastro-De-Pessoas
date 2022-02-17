package br.com.projeto01.jade;

//metodos dentro do banco de dados, alterar dados do banco de dados.


import java.sql.Connection;
import java.sql.Statement;

public class PersistenciaPessoa {


     Connection con = new  Conexao().getCon();
        public int executaSQL(String sql) {
                try {
                        Statement stm = con.createStatement();
                        int res = stm.executeUpdate(sql);
                        con.close();
                        return res;

                } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                }

        }
}





