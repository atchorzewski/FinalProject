package pl.coderslab.finalproject.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.Shop.DTO.OrderDTO;
import pl.coderslab.finalproject.Shop.Entity.Order;
import pl.coderslab.finalproject.Shop.Entity.OrderItem;
import pl.coderslab.finalproject.Shop.NotFoundException;
import pl.coderslab.finalproject.Shop.Repository.OrderRepository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class OrderService {
    private static final String ORDER_NUMBER_PREFIX = "ORD";
    private static final int ORDER_NUMBER_LENGTH = 8;

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderNumber(generateOrderNumber());


        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) throws Throwable {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElseThrow(new Supplier<Throwable>() {
            public Throwable get() {
                return new NotFoundException("Order not found");
            }
        });
    }
    // Pozostałe metody serwisu

    private String generateOrderNumber() {
        String formattedDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String uniqueOrderNumber = generateUniqueOrderNumber();

        return ORDER_NUMBER_PREFIX + formattedDate + uniqueOrderNumber;
    }

    private String generateUniqueOrderNumber() {
        String uniqueNumber = generateRandomNumber();

        while (orderRepository.existsByOrderNumber(uniqueNumber)) {
            uniqueNumber = generateRandomNumber();
        }

        return uniqueNumber;
    }

    private String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt((int) Math.pow(10, ORDER_NUMBER_LENGTH));

        return String.format("%0" + ORDER_NUMBER_LENGTH + "d", randomNumber);
    }
}