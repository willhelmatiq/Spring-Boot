package com.harbourspace.Spring.Boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/grade/{letter}")
    public int gradeLetter(@PathVariable String letter) {
        if (("A".equals(letter))) {
            return 100;
        } else if ("B".equals(letter)) {
            return 90;
        } else {
            return 0;
        }

    }
}
