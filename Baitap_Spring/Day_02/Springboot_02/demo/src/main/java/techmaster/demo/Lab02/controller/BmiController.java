package techmaster.demo.Lab02.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BmiController {

    @GetMapping("/bmi")
    public ResponseEntity<String> calculateBmiGet(@RequestParam("height") double height, @RequestParam("weight") double weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Height and weight must be greater than 0");
        }

        double bmi = calculateBmi(height, weight);
        return ResponseEntity.ok(String.format("Your BMI is: %.2f", bmi));
    }

    @PostMapping("/bmi")
    public ResponseEntity<String> calculateBmiPost(@RequestBody BmiRequest bmiRequest) {
        double height = bmiRequest.getHeight();
        double weight = bmiRequest.getWeight();

        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Height and weight must be greater than 0");
        }

        double bmi = calculateBmi(height, weight);
        return ResponseEntity.ok(String.format("Your BMI is: %.2f", bmi));
    }

    private double calculateBmi(double height, double weight) {

        return weight / (height * height);
    }
}
