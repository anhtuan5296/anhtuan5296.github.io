package techmaster.demo.Lab01.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ColorController {

    @GetMapping("/random-color")
    public String getRandomColor(@RequestParam("type") int type) {
        if (type < 1 || type > 3) {
            throw new IllegalArgumentException("Type không hợp lệ");
        }

        Random random = new Random();

        if (type == 1) {
            String[] colorNames = {"black", "blue", "red", "green"};
            return colorNames[random.nextInt(colorNames.length)];
        } else if (type == 2) {
            return String.format("#%06x", random.nextInt(0xFFFFFF + 1));
        } else {
            return String.format("rgb(%d, %d, %d)", random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
    }
}
