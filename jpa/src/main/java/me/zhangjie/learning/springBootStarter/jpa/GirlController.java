package me.zhangjie.learning.springBootStarter.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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



    @RequestMapping("/girlsByPage")
    public Page<GirlEntity> girlsByPage(@RequestParam("page") Integer pageNo,@RequestParam("size") Integer size) {
        Page<GirlEntity> page = girlRepository.findAll(new PageRequest(pageNo,size));
        return page;
    }

/*    @RequestMapping("/allGirls")
    public Page<GirlEntity> allGirls(){

    }*/


    @RequestMapping("/findByName")
    public List<GirlEntity> findByName(@RequestParam("name") String name){
        List<GirlEntity> girlEntities = girlRepository.findByName(name);
        return girlEntities;
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

    @RequestMapping("/delGirl")
    public String delGirl(@RequestParam("id") Integer id){
        String errorMessage = " success ";
        try {
            girlRepository.delete(id);
        }catch (EmptyResultDataAccessException e){
            errorMessage = "record " + id + " no exist!";
            return errorMessage;
        }
        catch (Exception e) {
            errorMessage = " error ";
            e.printStackTrace();
        }
        errorMessage = "del " + id + " success !";
        return errorMessage;
    }

}
