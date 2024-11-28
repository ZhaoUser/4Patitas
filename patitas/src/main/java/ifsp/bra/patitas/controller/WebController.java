package ifsp.bra.patitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/{path:[^\\.]*}") // Redireciona tudo que não contenha "."
    public String redirect() {
        return "forward:/index.html";
    }
}
