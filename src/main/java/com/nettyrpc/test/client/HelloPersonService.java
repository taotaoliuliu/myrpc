package com.nettyrpc.test.client;

import java.util.List;

/**
 * Created by lsl on 2016-06-10.
 */
public interface HelloPersonService {
    List<Person> GetTestPerson(String name,int num);
}
