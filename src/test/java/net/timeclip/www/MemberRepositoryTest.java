package net.timeclip.www;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.timeclip.www.config.MybatisConfig;
import net.timeclip.www.config.RootConfig;
import net.timeclip.www.member.domain.Member;
import net.timeclip.www.member.repository.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, MybatisConfig.class })
public class MemberRepositoryTest {
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Before
    public void before() {
        memberRepository.deleteAll();
    }

    @Test
    public void insertTest() {
        
        Member member = new Member("user1", "user1", "user1");
        Member returnedMember = memberRepository.save(member);
        
        assertThat(member).isSameAs(returnedMember);
        assertThat(member.getUserIdx()).isNotNull();
    }

}
