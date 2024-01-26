package lk.Ijse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StorageDto {
    private String id;
    private String brand;
    private String Type;
    private Double price;
    private int quantity;
    private String status;
    private String image;

}
