package br.com.projeto01.jade;

//metodos dentro do banco de dados, alterar dados do banco de dados.


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaPessoa {


    Connection con = new Conexao( ).getCon( );

    public int executaSQL(String sql) {

        try {
            Statement stm = con.createStatement( );

            int res = stm.executeUpdate(sql);

            con.close( );
            return res;

        } catch (Exception e) {
            e.printStackTrace( );
            return 0;
        }


    }
    public List<Pessoa>buscapessoas(String sql){

        try {
            ResultSet set;

            ArrayList <Pessoa> listPessoas = new ArrayList<>();

            Statement stm = con.createStatement( );

            set  = stm.executeQuery(sql);

            while (set.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(set.getString("nome"));
                pessoa.setCpf(set.getLong("cpf"));
                pessoa.setNascimento(set.getDate("nascimento"));
                pessoa.setId(set.getInt("id"));


            }

            con.close( );
            return null;


        } catch (Exception e) {
            e.printStackTrace( );

            return null;

        }
    }
}








