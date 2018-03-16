package me.zhangjie.learning.springBootStarter.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //相当于@Controller + @ResponseBody
@RequestMapping("/")
public class DemoRestController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello world!";
    }
}
