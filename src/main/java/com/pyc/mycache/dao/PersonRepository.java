//IntelliJ IDEA
//mycache
//PersonRepository
//2020/2/11
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mycache.dao;

import com.pyc.mycache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
