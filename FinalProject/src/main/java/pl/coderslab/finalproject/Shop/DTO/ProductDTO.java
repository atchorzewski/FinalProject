package pl.coderslab.finalproject.Shop.DTO;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Data
public class ProductDTO {
    private Long id;
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private double price;

}