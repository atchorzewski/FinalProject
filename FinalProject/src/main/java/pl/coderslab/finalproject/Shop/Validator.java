package pl.coderslab.finalproject.Shop;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

@Component
public class Validator {

    public final Validator validator;

    public Validator() {
        this.validator = (Validator) Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <T> Set<ConstraintViolation<T>> validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            // Obsługa błędów walidacji
            // ...
        }
        return violations;
    }
}