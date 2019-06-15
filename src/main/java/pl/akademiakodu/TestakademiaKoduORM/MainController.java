package pl.akademiakodu.TestakademiaKoduORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String showIndex(ModelMap modelMap){

        modelMap.put("user", userRepo.findAll());

        return "index";
    }

    @PostMapping("/add")
    public String addNewUser (@RequestParam String name,
                              @RequestParam String email, ModelMap modelMap) {

        userRepo.save(new User(name, email));
        modelMap.put("user", userRepo.findAll());

        return "index";
    }

    @PostMapping("/edit/{id}")
    public String editUserComment(@PathVariable int id, @RequestParam String text, ModelMap modelMap){

        User user = userRepo.findById(id).get();
        user.setComment(text);
        userRepo.save(user);

        modelMap.put("user", userRepo.findAll());

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable int id, ModelMap modelMap){

        User user = userRepo.findById(id).get();
        user.setComment("");
        userRepo.save(user);

        modelMap.put("user", userRepo.findAll());

        return "index";
    }

    @GetMapping("/find")
    public String findUserByName(@RequestParam String name, ModelMap modelMap){

        modelMap.put("user", userRepo.fainUserByName(userRepo.findAll(), name));

        return "index";
    }
}
