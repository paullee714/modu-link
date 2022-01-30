package com.wool.modulink;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(false)
public class ConfiguerationAnnotationTests {

    @Value("${myspring.test.name}")
    private String mySpringTestName;

    @Value("${myspring.test.age}")
    private int mySpringTestAge;

    @Value("${myspringListTest}")
    private String[] mySpringArray;

    @Value("#{'${myspringListTest}'.split(',')}")
    private List<String> mySpringList;

    @Test
    public void valueAnnotationTest(){
        Assert.assertEquals(mySpringTestName, "wool");
        Assert.assertEquals(mySpringTestAge, 20);

        Assert.assertEquals(mySpringArray[0],"banana");
        Assert.assertEquals(mySpringArray[1],"orange");
        Assert.assertEquals(mySpringArray[2],"apple");

        Assert.assertEquals(mySpringList.get(0),"banana");
        Assert.assertEquals(mySpringList.get(1),"orange");
        Assert.assertEquals(mySpringList.get(2),"apple");

    }

}
