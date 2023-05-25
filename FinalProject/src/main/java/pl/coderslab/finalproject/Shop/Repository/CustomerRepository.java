package pl.coderslab.finalproject.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.Shop.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}