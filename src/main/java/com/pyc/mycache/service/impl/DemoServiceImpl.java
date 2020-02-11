//IntelliJ IDEA
//mycache
//DemoServiceImpl
//2020/2/11
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mycache.service.impl;

import com.pyc.mycache.dao.PersonRepository;
import com.pyc.mycache.domain.Person;
import com.pyc.mycache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    // 缓存新增的或更新的数据到缓存，缓存名称为 people，数据的 key 时 person 的 id
    // Caching new or updated data to the cache,
    //the cache name is people, and the key of the data is the person's id
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id，key 为：" + p.getId() + "的数据做了缓存");
        return p;
    }

    @Override
    // 从缓存 people 中删除 key 为 id 的数据
    // delete the data from cache called people where key value equal of the parameter id
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id， key 为" + id + "的数据缓存");
        personRepository.delete(id);
    }

    @Override
    // 缓存 key 为 person.id 的数据到缓存 people 中
    // Caching the data that key is parameter person's id into cache called people
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为 id，key 为" + p.getId() + "的数据做了缓存");
        return p;
    }
}
