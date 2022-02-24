package de.telekom.sea7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@ReponseBody --> wird aufgrund von Thymeleaf nicht mehr benötigt
public class ControllerThymeleaf {
	
	@GetMapping("/")							//templates: Hauptordner
	public String home(Model model,			//home = home.html im static-Ordner
				@RequestParam(value="name",
				required=false,
                defaultValue="World") 
				String name)
{
	
	    // String name = "Peg";
	    model.addAttribute("name", name);
	    return "home";

	}
	}


