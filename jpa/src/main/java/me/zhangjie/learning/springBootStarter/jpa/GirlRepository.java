package me.zhangjie.learning.springBootStarter.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fangan1 on 2018/3/16.
 */
public interface GirlRepository extends JpaRepository<GirlEntity,Integer> {
    public List<GirlEntity> findByName(String name);
    public Page<GirlEntity> allGirls(Pageable pageable);

}
