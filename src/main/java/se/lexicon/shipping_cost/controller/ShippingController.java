package se.lexicon.shipping_cost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.shipping_cost.entity.Box;
import se.lexicon.shipping_cost.repository.BoxRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    BoxRepository boxRepository;

    @Autowired
    public void setBoxRepository(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }


    @GetMapping("/addForm")
    public String showBoxForm(Model model) {
        Box box = new Box();
        model.addAttribute("box", box);
        return "addBoxForm";

    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Box> boxes = new ArrayList<>();
        Iterator<Box> iterator = boxRepository.findAll().iterator();
        iterator.forEachRemaining(boxes::add);
        model.addAttribute("boxes", boxes);
        return "showBoxList";
    }

    @PostMapping("/add")
    public String addBox(@ModelAttribute("box") @Valid Box box, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("box = " + box);
        if (bindingResult.hasErrors()) {
            return "addBoxForm";
        }
        boxRepository.save(box);//send data to db
        redirectAttributes.addFlashAttribute("message", "Operations is done");
        redirectAttributes.addFlashAttribute("alertClass", "alert-successes");

        return "redirect:/shipping/";

    }
}




