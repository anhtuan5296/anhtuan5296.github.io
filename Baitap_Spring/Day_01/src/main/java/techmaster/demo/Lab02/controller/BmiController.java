package techmaster.demo.Lab02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BmiController {

    @GetMapping("/bmi")
    public ResponseEntity<BmiResponse> calculateBmiGet(@RequestParam(name = "height") double height,
                                                       @RequestParam(name = "weight") double weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Thông tin height và weight phải lớn hơn 0");
        }

        double bmi = calculateBmi(height, weight);
        BmiResponse response = new BmiResponse(bmi);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/bmi")
    public ResponseEntity<BmiResponse> calculateBmiPost(@RequestParam(name = "height") double height,
                                                        @RequestParam(name = "weight") double weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Thông tin height và weight phải lớn hơn 0");
        }

        double bmi = calculateBmi(height, weight);
        BmiResponse response = new BmiResponse(bmi);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private double calculateBmi(double height, double weight) {
        return weight / (height * height);
    }
}
