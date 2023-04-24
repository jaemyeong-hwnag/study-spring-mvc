package com.study.springmvc.basic.requestmapping;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    @GetMapping
    public String user() {
        return "get user";
    }

    @GetMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable Long userId) {
        return "get userId=" + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable Long userId) {
        return "update userId=" + userId;
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return "delete userId=" + userId;
    }
}
