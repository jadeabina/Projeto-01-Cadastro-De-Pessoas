package br.com.projeto01.jade;


import com.sun.jdi.connect.Connector;
import org.sonatype.guice.plexus.config.Strategies;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

    class BancoDeDados {


        private DatabaseMetaData JDBCUtils;
        Conexao conexao = new Conexao( );

        public void inserir() {
            Scanner scanner = new Scanner(System.in);
            PersistenciaPessoa persistenciaPessoa = new PersistenciaPessoa( );
            Pessoa pessoa = new Pessoa( );


            System.out.println("Digite seu nome:");
            var nome = (scanner.nextLine( ));


            System.out.println("Digite a sua data de nascimento: ");
            var nascimento = (scanner.nextLine( ));


            System.out.println("Digite o seu cpf: ");
            long cpf = Long.parseLong((scanner.nextLine( )));


            try {
                Date nascimento1 = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
                pessoa.setNascimento(nascimento1);
            } catch (ParseException e) {
                e.printStackTrace( );
            }
            System.out.println(nascimento + "\t" + nascimento);


            //casting pesquisar

            pessoa.setCpf(cpf);
            pessoa.setNome(nome);


           persistenciaPessoa.executaSQL("insert into pessoa (nome,nascimento,cpf) values ('"+nome+"','"+nascimento+"','"+cpf+"')");


            System.out.println("cadastrado com sucesso");


        }


        public void listar() {


            List<Pessoa> pessoas = new ArrayList<Pessoa>( );


            ResultSet rs = null;
            Conexao conexao = new Conexao( );

            try {

                Statement sql = (Statement) conexao.getCon( ).createStatement( );

                rs = sql.executeQuery("select * from pessoa");

                while (rs.next( )) {

                    Pessoa pessoa1 = new Pessoa( );
                    pessoa1.setNome(rs.getString("nome"));
                    pessoa1.setNascimento(rs.getDate("nascimento"));
                    pessoa1.setId(rs.getInt("id"));

                    pessoas.add(pessoa1);

                }

            } catch (SQLException e) {

                e.printStackTrace( );

            }
            for (Pessoa p : pessoas) {
                System.out.println(p.getNome( ) + " | " + p.getId());
            }

        }


        public void deletar() {

            String sql = "DELETE FROM pessoa WHERE id = ?";

            Connection conn = null;
            PreparedStatement pstm = null;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o Id da pessoa: ");

            int i = (scanner.nextInt( ));;


            System.out.println("Digite seu nome:");
            try {
                conn = new Conexao( ).getCon( );

                pstm = conn.prepareStatement(sql);


                pstm.setInt(1, i);

                pstm.execute( );

            } catch (Exception e) {

                e.printStackTrace( );
            } finally {

                try {
                    if (pstm != null) {

                        pstm.close( );
                    }

                    if (conn != null) {
                        conn.close( );
                    }

                } catch (Exception e) {

                    e.printStackTrace( );
                }
            }
        }
        private Date stringToDate (String nascimento){
            Date date= null;
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
            }catch (Exception e){
                e.printStackTrace();
            }
            return date;
        }
    public void update() {
        Scanner scanner = new Scanner(System.in);



        String sql = "update pessoas set nome=?, cpf=?,"
                    + "nascimento=?, where id=?";

            try { Pessoa p= new Pessoa();

                System.out.println("Digite o Id da pessoa que deseja atualizar os dados : ");
                p.setId(scanner.nextInt());
                System.out.println("Digite o novo nome: ");
                p.setNome(scanner.next());
                System.out.println("Digite o novo cpf: ");
                p.setCpf(scanner.nextLong());
                System.out.println("Digite a novo Nascimento: ");
                p.setNascimento( stringToDate(scanner.nextLine()));


                Connection conn = null;
                PreparedStatement ps = null;
                conn = new Conexao( ).getCon( );

                ps = conn.prepareStatement(sql);

                ps.setString(1, p.getNome());
                ps.setLong(2, p.getCpf());
                ps.setDate(3, new java.sql.Date(p.getNascimento().getTime()));
                ps.setInt(4, p.getId());

                ps.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        }
