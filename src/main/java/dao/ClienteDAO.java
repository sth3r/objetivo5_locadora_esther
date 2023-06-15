package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAO extends BaseDAO {
    public static List<Cliente> selectClientes() {
        final String sql = "SELECT * FROM Clientes ORDER BY nome_cli";
        try // try-witch-resource
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery()
                )
        {
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                clientes.add(resultsetToCliente(rs));
            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Cliente> selectClientesByName(String nome_cli) {
        final String sql = "SELECT * FROM Clientes WHERE nome_cli LIKE ? ORDER BY nome_cli";
        try // try-witch-resource
                (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome_cli.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            List<Cliente> Clientes = new ArrayList<>();
            while (rs.next()) {
                Clientes.add(resultsetToCliente(rs));
            }
            return Clientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cliente selectClienteById(Long id) {
        final String sql = "SELECT * FROM Clientes WHERE cli_id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            Cliente cliente = null;
            if (rs.next()) {
                cliente = resultsetToCliente(rs);
            }
            rs.close();
            return cliente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertCliente(Cliente cliente) {
        final String sql = "INSERT INTO Clientes (cpf_cli, nome_cli, end_cli, tel_cli, email_cli) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        )
        {
            pstmt.setString(1, cliente.getNom_cliente());
            pstmt.setLong(2, cliente.getCpf_cliente());
            pstmt.setString(3, cliente.getEnd_cliente());
            pstmt.setString(4, cliente.getEmail_cliente());
            pstmt.setString(5, cliente.getEnd_cliente());
            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCliente(Cliente cliente) {
        /*VE ISSO DE USAR O ID PRA PESQUISAR O CLIENTE ELE É AUTO INCREMENT*/
        final String sql = "UPDATE Clientes SET nome_cli=?, cpf_cli=?, end_cli=?, tel_cli=?, email_cli=? WHERE cli_id=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        )
        {
            pstmt.setString(1, cliente.getNom_cliente());
            pstmt.setLong(2, cliente.getCpf_cliente());
            pstmt.setString(3, cliente.getEnd_cliente());
            pstmt.setString(4, cliente.getEmail_cliente());
            pstmt.setString(5, cliente.getEnd_cliente());
            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*  O MEU NAO TEM SITUACAO, TEM QUE VE ISSO TMB
        public static boolean softDeleteCliente(long id, boolean situacao) {
        final String sql = "UPDATE clientes SET situacao=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, situacao);
            pstmt.setLong(2, id);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    public static boolean hardDeleteCliente(long id) {
        final String sql = "DELETE FROM Clientes WHERE cli_id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // método utilitário, converte ResultSet na classe de modelo (nesse caso, Cliente)
    private static Cliente resultsetToCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
//        c.setCli_id(rs.getLong("id"));
        c.setNom_cliente(rs.getString("nome"));
        c.setCpf_cliente(rs.getLong("CPF"));
        c.setEnd_cliente(rs.getString("enedreço"));
        c.setTel_cliente(rs.getString("telefone"));
        c.setEmail_cliente(rs.getString("email"));

        return c;
    }

    public static void main(String[] args) {
       /* System.out.println("\nLista de Clientes");
        System.out.println(ClienteDAO.selectClientes());

        System.out.println("\nCliente pelo id");
        System.out.println(ClienteDAO.selectClienteById(1L));

        System.out.println("\nClientes pelo nome");
        System.out.println(ClienteDAO.selectClientesByName("a"));

        System.out.println("\nCliente pela situação");
        System.out.println(ClienteDAO.selectClientesBySituacao(true));

        System.out.println("\nCriando um Clente");
        Cliente cliente = new Cliente(3L,"Aline", "Dias", false, null);
        System.out.println(ClienteDAO.insertCliente(cliente));
        System.out.println("\nCliente INSERIDO na base de dados: " + ClienteDAO.selectClienteById(3L));

        System.out.println("\nAlterando um cliente (o criado recentemente)");
        cliente = selectClienteById(3L);
        cliente.setNome("Aline Marisa");
        cliente.setSobrenome("Vaz");
        System.out.println(ClienteDAO.updateCliente(cliente));
        System.out.println("\nCliente ALTERADO na base de dados: " + ClienteDAO.selectClienteById(3L));

        System.out.println("\nDeletando um cliente (o criado recentemente)");
        System.out.println(softDeleteCliente(3, false));
        System.out.println("\nCliente EXCLUÍDO na base de dados: " + ClienteDAO.selectClienteById(3L));*/
    }

}