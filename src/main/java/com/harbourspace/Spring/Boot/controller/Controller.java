package com.harbourspace.Spring.Boot.controller;

import com.harbourspace.Spring.Boot.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/inbox/items")
    public List<Item> getItems(@RequestHeader(name = "x-harbour-auth")
                                   String headerParam) {
        return Arrays.asList(new Item(1, "test"), new Item(2, "some status"),
                new Item(3, "test status"));
    }

    @PostMapping("/inbox/items")
    public Item createItem(@RequestBody Item item, @RequestHeader(name = "x-harbour-auth")
    String headerParam) {
        return item;
    }
}
