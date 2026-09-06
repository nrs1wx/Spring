package kz.kbtu.practice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final AppProperties appProperties;

    public HelloController(AppProperties appProperties) {
        this.appProperties =  appProperties;
    }
    @GetMapping("/hello")
    public String hello(){
        return appProperties.getGreeting() + " (max users: " + appProperties.getMaxUsers() + ")";
    }
}
