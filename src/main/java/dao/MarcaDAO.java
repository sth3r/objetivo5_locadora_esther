package dao;

import model.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MarcaDAO extends BaseDAO{
    public static List<Marca> listarMarcas() {
        final String sql = "SELECT * FROM Marcas ORDER BY descricao";
        try //try-witch-resource
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery()
                )
        {
            List<Marca> marcas = new ArrayList<>();
            while(rs.next()) {
                marcas.add(resultsetToMarca(rs));
            }
            return marcas;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
