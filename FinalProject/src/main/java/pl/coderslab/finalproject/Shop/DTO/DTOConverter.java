package pl.coderslab.finalproject.Shop.DTO;

import org.springframework.stereotype.Component;
import pl.coderslab.finalproject.Shop.Entity.Product;

@Component
public class DTOConverter {
    public ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        return dto;
    }
}