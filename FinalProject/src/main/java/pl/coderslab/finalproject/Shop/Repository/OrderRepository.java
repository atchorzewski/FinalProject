package pl.coderslab.finalproject.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.Shop.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}