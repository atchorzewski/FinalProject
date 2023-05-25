package pl.coderslab.finalproject.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.Shop.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}