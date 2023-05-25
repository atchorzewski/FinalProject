package pl.coderslab.finalproject.Shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.Shop.DTO.DTOConverter;
import pl.coderslab.finalproject.Shop.DTO.ProductDTO;
import pl.coderslab.finalproject.Shop.Entity.Product;
import pl.coderslab.finalproject.Shop.Service.ProductService;
import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final DTOConverter dtoConverter;

    @Autowired
    public ProductController(ProductService productService, DTOConverter dtoConverter) {
        this.productService = productService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return dtoConverter.convertToDTO(product);
    }


    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return ResponseEntity.ok("Product created successfully");
    }
}