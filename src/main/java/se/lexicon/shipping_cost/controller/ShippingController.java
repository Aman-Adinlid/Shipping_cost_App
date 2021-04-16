package se.lexicon.shipping_cost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    @GetMapping("/addForm")
    public String showBoxForm() {
        return "addBoxForm";

    }

    @GetMapping("/")
    public String getAll() {
        return "showBoxList";
    }
    @PostMapping()
    public String addBox(){
        return "redirect:/shipping/";
    }
}
