package de.neuefische.herokutest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class Controller {

    @GetMapping("/{name}")
    public String greet(@PathVariable String name){
        return "Hallo" + name;
    }


}
