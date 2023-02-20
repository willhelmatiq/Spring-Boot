package com.harbourspace.Spring.Boot.controller;

import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc/")
public class CalculatorController {

    /**
     *
     * @param a integer value
     * @param b integer value
     * @return  sum of a and b
     */
    @GetMapping("sum")
    public int sum(@RequestParam int a, @RequestParam int b, @RequestHeader(name = "x-harbour-auth")
                   String headerParam) {
        return a + b;
    }

    /**
     *
     * @param a integer value
     * @param b integer value
     * @return  product of a and b
     */
    @GetMapping("multiply")
    public int multiply(@RequestParam int a, @RequestParam int b, @RequestHeader(name = "x-harbour-auth")
            String headerParam) {
        return a * b;
    }
}
