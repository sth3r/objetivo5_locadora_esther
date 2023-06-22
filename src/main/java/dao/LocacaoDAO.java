package dao;

import model.Cliente;
import model.Locacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO extends BaseDAO{

    public static List<Locacao> selectLocacoes() {
        final String sql = "SELECT * FROM Locacoes ORDER BY loc_id";
        try // try-witch-resource
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery()
                )
        {
            List<Locacao> locacaos = new ArrayList<>();
            while (rs.next()) {
                locacaos.add(selectLocacoes(rs));
            }
            return locacaos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Locacao selectLocacaoById(int  loc_id) {
        final String sql = "SELECT * FROM Locacoes WHERE loc_id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, loc_id);
            ResultSet rs = pstmt.executeQuery();
            Locacao locacao = null;
            if (rs.next()) {
                locacao = resultsetToLocacao(rs);
            }
            rs.close();
            return locacao;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean locar(Locacao locacao) {
        final String sql = "INSERT INTO Locacoes (pego, devolucao, quilometragem, valor_caucao, valor_locacao, devolvido, aut_id, cli_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        )
        {
            pstmt.setTimestamp(1, locacao.getDt_hr_locacao());
            pstmt.setLong(5, locacao.getQuilometragem());
            pstmt.setDouble(6, locacao.getValor_custacao());
            pstmt.setDouble(7, locacao.getValor_locacao());
            pstmt.setBoolean(8, locacao.getDevolvido();
            pstmt.setInt(10, locacao.getDiasLocados());
            pstmt.setObject(9, locacao.getAutomovel());

            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




     public static void main(String[] args) {
       System.out.println("\nLista de Locações");
        System.out.println(LocacaoDAO.selectLocacoes());

        System.out.println("\nCliente pelo id");
        System.out.println(LocacaoDAO.selectLocacaoById(1));

        System.out.println("\nLocar carro");
        Locacao locacao = new Locacao(1,"Aline", "Dias", false, null);
        System.out.println(LocacaoDAO.locar(locacao));
        System.out.println("\nLocação salva na base de dados: " + LocacaoDAO.selectLocacaoById(1));
    }

}