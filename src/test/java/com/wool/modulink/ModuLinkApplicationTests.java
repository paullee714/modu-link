package com.wool.modulink;

import com.wool.modulink.model.User;
import com.wool.modulink.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModuLinkApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1SaveMember() {

        //given
        User member = new User();
        member.setAge(20);
        member.setEmail("wool@mail.com");
        member.setName("wool");
        member.setPassword("qwerqwer123");
        member.setPhone("010-1234-5678");
        userRepository.save(member);

        // when
        User retrivedMember = userRepository.findById(member.getId()).get();

        // then
        Assert.assertEquals(retrivedMember.getName(), "wool");
        Assert.assertEquals(retrivedMember.getAge(), Integer.valueOf(20));
        Assert.assertEquals(retrivedMember.getEmail(), "wool@mail.com");
        Assert.assertEquals(retrivedMember.getPhone(), "010-1234-5678");

        System.out.println(member.toString());
    }

    @Test
    public void test2ReadMember() {
        User member = userRepository.findByName("wool");
        System.out.println(member.toString());
    }

    @Test
    public void test3UpdateMember() {

        User testUser = userRepository.findByName("wool");

        testUser.setAge(100);
        testUser.setEmail("wool-update@update-mail.com");
        testUser.setPhone("010-4321-9876");
        userRepository.save(testUser);

        System.out.println(testUser.toString());
    }

    @Test
    public void test4DeleteMember() {
        User testUser = userRepository.findByName("wool");

        System.out.println(testUser.toString());
        userRepository.delete(testUser);
    }

}
