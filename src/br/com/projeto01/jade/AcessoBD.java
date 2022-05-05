package br.com.projeto01.jade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.postgresql.core.ConnectionFactory;

public class AcessoBD {

    public void save(Pessoa pessoa){



        String sql = "INSERT INTO pessoa(nome,nascimento,cpf)" +
                " VALUES(?,?,?)";


        PreparedStatement pstm = null;
        Connection con = new  Conexao().getCon();
        try {
            //Cria uma conexão com o banco



            //PreparedStatment é comando sql pré pronto sem as variaveis
            //Cria um PreparedStatment, classe usada para executar a query
            pstm = con.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, pessoa.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setDate(2,new Date( pessoa.getNascimento().getTime()));
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setLong(3,(pessoa.getCpf()));

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }finally{

            //Fecha as conexões

            try{
                if(pstm != null){

                    pstm.close();
                }

                if(con != null){
                    con.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }

    public void removeById(int id){

        String sql = "DELETE FROM pessoa WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            Connection con = new  Conexao().getCon();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{

            try{
                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }

    public void update(Pessoa pessoa){

        String sql = "UPDATE pessoa SET nome = ?, nascimento = ?, cpf = ?" +
                " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            Connection con = new  Conexao().getCon();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, pessoa.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setDate(2, new java.sql.Date(pessoa.getNascimento().getTime()));
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setLong(3,(pessoa.getCpf()));

            pstm.setInt(4, pessoa.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        }finally{

            //Fecha as conexões

            try{
                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }

    public List<Pessoa> getPessoa(){

        String sql = "SELECT * FROM pessoa";

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            Connection con = new  Conexao().getCon();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while(rset.next()){

                Pessoa pessoa = new Pessoa();

                //Recupera o id do banco e atribui ele ao objeto
                pessoa.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                pessoa.setNome(rset.getString("nome"));

                //Recupera a idade do banco e atribui ele ao objeto
                pessoa.setNascimento(rset.getDate("idade"));

                //Recupera a data do banco e atribui ela ao objeto
                pessoa.setCpf(rset.getInt("CPF"));

                //Adiciono o contato recuperado, a lista de contatos
                pessoas.add(pessoa);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }finally{

            try{

                if(rset != null){

                    rset.close();
                }

                if(pstm != null){

                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }

        return pessoas;
    }
}