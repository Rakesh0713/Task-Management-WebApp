package com.task.taskManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {
    @GetMapping({"/", "/{path:^(?!api|static|css|js|images).*$}", "/{path:^(?!api|static|css|js|images).*$}/**"})
    public String index() {
        return "add";
    }
} 