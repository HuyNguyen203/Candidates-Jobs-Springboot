package vn.iuh.edu.fit.labweek05.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("your-profile")
public class YourProfileController {

    @GetMapping("")
    public String yourProfile() {
        return "yourProfile/index";
    }
}
