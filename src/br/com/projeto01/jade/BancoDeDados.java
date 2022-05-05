package br.com.projeto01.jade;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BancoDeDados {

    private DatabaseMetaData JDBCUtils;


    public void inserir(){
        Scanner scanner = new Scanner(System.in);
        PersistenciaPessoa persistenciaPessoa = new PersistenciaPessoa();
        Pessoa pessoa = new Pessoa();
        AcessoBD acessoBD = new AcessoBD();

        System.out.println("Digite seu nome:");
        var nome= (scanner.nextLine());


        System.out.println("Digite a sua data de nascimento: ");
        var nascimento= (scanner.nextLine());


        System.out.println("Digite o seu cpf: ");
        long cpf = Long.parseLong((scanner.nextLine()));


        try {
            Date nascimento1 =new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
            pessoa.setNascimento(nascimento1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(nascimento+"\t"+nascimento);


        //casting pesquisar

        pessoa.setCpf(cpf);
        pessoa.setNome(nome);
        acessoBD.save(pessoa);


        //persistenciaPessoa.executaSQL("insert into pessoa (nome,nascimento,cpf) values ('"+nome+"','"+nascimento+"','"+cpf+"')");





        System.out.println("cadastrado com sucesso");



    }



    public void listar() {


        List<Pessoa> pessoas = new ArrayList<Pessoa>( );


        ResultSet rs = null;
        AcessoBD acessoBD = new AcessoBD( );


        try {

            PreparedStatement sql = (PreparedStatement) rs.getArray("select * from pessoa");

            rs = sql.executeQuery( );

            while (rs.next( )) {

                Pessoa pessoa1 = new Pessoa( );

                pessoa1.setNome(rs.getString("nome"));

                pessoa1.setNascimento(rs.getDate("nascimento"));

                pessoas.add(pessoa1);

            }

        } catch (SQLException e) {

            e.printStackTrace( );

        }
        for (Pessoa p: pessoas) {
            System.out.println(p.getNome());
        }

    }
}
//
//
//
//
//
//
//    public void apagar() {
//
//        String  = "DELETE FROM pessoa WHERE id = ?";
//
//
//            // Etapa 1: Estabelecendo uma conexão
//        try (AcessoBD acessoBD = new AcessoBD();
//
//             // Step 2:Create a statement using connection object
//             Statement statement = acessoBD.getPessoa().listIterator().next().getId();
//
//            // Step 3: Execute the query or update query
//            int result = statement.executeUpdate(DELETE_PESSOA_SQL);
//            System.out.println("Number of records affected :: " + result);
//        } catch (SQLException e) {
//
//            // print SQL exception information
//         catch (Exception e) {
//                e.printStackTrace();
//        }
//
//        // Step 4: try-with-resource statement will auto close the connection.
//    }
//
//
//                }
//            }
//
//
//    public void Atualizar(){
//
//        String sql = "UPDATE pessoa SET nome = ?, nascimento = ?, cpf = ?" +
//                " WHERE id = ?";
//
//        public void updateRecord()throws SQLException {
//                System.out.println(sql);
//
//                // Etapa 1: Estabelecendo uma conexão
//                AcessoBD acessoBD = new AcessoBD( );
//
//
//                // Etapa 2: Criar uma instrução usando o objeto de conexão
//                PreparedStatement preparedStatement = acessoBD.update(sql);
//                preparedStatement.setArray(1, "Ram");
//                preparedStatement.setArray(2, 8);
//
//                // Etapa 3: Execute a consulta ou atualize a consulta
//
//                // print SQL exception information
//            }catch (Exception e) {
//                    e.printStackTrace();
//            }
//
//            // Etapa 4: a instrução try-with-resource fechará automaticamente a conexão.
//        }
//    }
//    }




