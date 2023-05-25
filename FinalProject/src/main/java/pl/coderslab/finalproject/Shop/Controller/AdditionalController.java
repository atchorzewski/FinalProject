package pl.coderslab.finalproject.Shop.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/additional")
public class AdditionalController {
    @GetMapping("/endpoint1")
    public String additionalEndpoint1() {
        // Implement additional endpoint 1 logic
        return "Endpoint 1 response";
    }

    @GetMapping("/endpoint2")
    public String additionalEndpoint2() {
        // Implement additional endpoint 2 logic
        return "Endpoint 2 response";
    }
}