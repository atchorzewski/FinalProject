package pl.coderslab.finalproject;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.coderslab.finalproject.Shop.Controller.ProductController;
import pl.coderslab.finalproject.Shop.DTO.DTOConverter;
import pl.coderslab.finalproject.Shop.DTO.ProductDTO;
import pl.coderslab.finalproject.Shop.Product;
import pl.coderslab.finalproject.Shop.Service.ProductService;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private DTOConverter dtoConverter;

    @Test
    public void testGetProductById() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Product 1");
        product.setPrice(10.99);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Product 1");
        productDTO.setPrice(10.99);

        when(productService.getProductById(1L)).thenReturn(product);
        when(dtoConverter.convertToDTO(product)).thenReturn(productDTO);

        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Product 1"))
                .andExpect(jsonPath("$.price").value(10.99));

        verify(productService, times(1)).getProductById(1L);
        verify(dtoConverter, times(1)).convertToDTO(product);
    }

}