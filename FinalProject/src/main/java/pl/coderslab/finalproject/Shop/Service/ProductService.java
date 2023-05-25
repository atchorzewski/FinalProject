package pl.coderslab.finalproject.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.Shop.DTO.ProductDTO;
import pl.coderslab.finalproject.Shop.Entity.Product;
import pl.coderslab.finalproject.Shop.Repository.ProductRepository;
import pl.coderslab.finalproject.Shop.Validator;

import java.util.List;

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

    public Product updateProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId).orElse(null);

        if (existingProduct != null) {
            // Aktualizacja pól produktu na podstawie danych z ProductDTO
            // ...

            return productRepository.save(existingProduct); // Wykonanie operacji UPDATE
        } else {
            return null;
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId); // Wykonanie operacji DELETE
    }

    public List<Product> searchProducts(String keyword) {
        // Implementacja wyszukiwania produktów na podstawie keyword
        // ...

        return matchingProducts;
    }
}