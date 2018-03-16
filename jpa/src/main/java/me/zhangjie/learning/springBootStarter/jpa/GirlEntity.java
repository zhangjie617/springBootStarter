package me.zhangjie.learning.springBootStarter.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //不指定表名时自动生成表名为girl_entity
public class GirlEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer age;

    public GirlEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
