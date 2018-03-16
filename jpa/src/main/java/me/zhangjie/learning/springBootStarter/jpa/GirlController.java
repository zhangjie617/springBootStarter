package me.zhangjie.learning.springBootStarter.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @RequestMapping("/girls")
    public List<GirlEntity> girlList() {
        List<GirlEntity> girlEntitys = girlRepository.findAll();
        return girlEntitys;
    }

    @RequestMapping("/addGirl")
    public GirlEntity addGirl(@RequestParam("name") String name,
                              @RequestParam("age") Integer age){
        GirlEntity girlEntity = new GirlEntity();
        girlEntity.setName(name);
        girlEntity.setAge(age);
        girlRepository.save(girlEntity);
        return girlEntity;
    }

    @RequestMapping("/girlDetails")
    public GirlEntity girlDetails(@RequestParam("id") Integer id){
        GirlEntity girlEntity = girlRepository.findOne(id);
        return girlEntity;
    }

}
