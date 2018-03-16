package me.zhangjie.learning.springBootStarter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fangan1 on 2018/3/16.
 */
public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {
}
