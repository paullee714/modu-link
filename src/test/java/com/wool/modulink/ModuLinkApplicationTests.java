package com.wool.modulink;

import com.wool.modulink.model.User;
import com.wool.modulink.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(false)
class ModuLinkApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveMemberTest() {

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
    }

}
