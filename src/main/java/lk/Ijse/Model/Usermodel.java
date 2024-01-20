package lk.Ijse.Model;

import javafx.scene.text.Text;
import lk.Ijse.Dbconnection.Dbconnection;
import lk.Ijse.Dto.CusDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usermodel {

    public boolean saveUser(CusDto cusDto) throws SQLException {
        Connection connection =Dbconnection.getDbconnection().getConnection();
        String sql = "insert into user values (?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1,cusDto.getId());
        pstm.setString(2,cusDto.getUsername());
        pstm.setString(3,cusDto.getPassword());
        pstm.setString(4,cusDto.getEmail());
        pstm.setInt(5,cusDto.getNumber());

        return pstm.executeUpdate()>0;
    }

    public CusDto CheckData(String name) throws SQLException {
        Connection connection = Dbconnection.getDbconnection().getConnection();
        String sql = "SELECT * FROM user WHERE name = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, name);

            ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {

        }
//        id int(225)primary key,
//        name varchar(100)not null,
//                password varchar(100)not null,
//                email varchar(100)not null,
//                tel int(10)not null

            return new CusDto(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getInt("tel")
                    );
        }

}
