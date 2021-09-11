package meow.springframework.petclinic.controllers;

import meow.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "vets/index"})
    String vetIndex(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/vet-index";
    }
}
