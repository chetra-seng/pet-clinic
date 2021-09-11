package meow.springframework.petclinic.controllers;

import meow.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/", "", "/index"})
    String ownerIndex(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/owner-index";
    }
}
