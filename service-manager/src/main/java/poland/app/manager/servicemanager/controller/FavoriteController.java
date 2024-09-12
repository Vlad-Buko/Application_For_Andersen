package poland.app.manager.servicemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vladislav Domaniewski
 */

@RestController
public class FavoriteController {
    @GetMapping("/show")
    public void showElement() {

    }
}
