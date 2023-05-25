package pl.coderslab.finalproject.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.Shop.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByOrderNumber(String orderNumber);
}