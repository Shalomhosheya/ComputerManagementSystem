package lk.Ijse.Model;

import lk.Ijse.Dbconnection.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StorageModel {
    public boolean AddTOdataDabase(String id, String brand, String type, Double price, int quanity, String status, String image) throws SQLException {
        Connection connection = Dbconnection.getDbconnection().getConnection();
        String sql ="insert into Storage values (?,?,?,?,?,?,?);";
        PreparedStatement pstm = connection.prepareStatement(sql);
       pstm.setString(1,id);
       pstm.setString(2,brand);
       pstm.setString(3,type);
       pstm.setDouble(4,price);
       pstm.setInt(5,quanity);
       pstm.setString(6,status);
       pstm.setString(7,image);

       return pstm.executeUpdate()>0;

    }
}
