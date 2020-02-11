//IntelliJ IDEA
//mycache
//CacheController
//2020/2/11
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mycache.web;

import com.pyc.mycache.domain.Person;
import com.pyc.mycache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person){
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id){
        demoService.remove(id);
        return "ok";
    }
}
