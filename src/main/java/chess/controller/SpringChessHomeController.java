package chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringChessHomeController {

    @GetMapping("/chess/home")
    public String routeGetMethod() {
        return "index";
    }
}
