package pl.coderslab.finalproject.Shop;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}