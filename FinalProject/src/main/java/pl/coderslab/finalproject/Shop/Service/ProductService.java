package pl.coderslab.finalproject.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.Shop.DTO.ProductDTO;
import pl.coderslab.finalproject.Shop.Product;
import pl.coderslab.finalproject.Shop.Repository.ProductRepository;
import pl.coderslab.finalproject.Shop.Validator;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Validator Validator;
    @Autowired
    public ProductService(ProductRepository productRepository, pl.coderslab.finalproject.Shop.Validator validator) {
        this.productRepository = productRepository;
        Validator = validator;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void createProduct(ProductDTO productDTO) {
        Validator.validator.validate(productDTO);

    }
}