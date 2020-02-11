//IntelliJ IDEA
//mycache
//DemoService
//2020/2/11
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.mycache.service;

import com.pyc.mycache.domain.Person;

public interface DemoService {
    public Person save(Person person);
    public void remove(Long id);
    public Person findOne(Person person);
}
