package pl.coderslab.finalproject.Shop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderDTO {
    private Long customerId;
    private List<OrderItemDTO> items;


}