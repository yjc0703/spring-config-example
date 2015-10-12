package net.timeclip.www;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
public class MemberDaoTest {
    
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test() {
        
        Integer value = 3;
        Integer test = memberRepository.test(value);
        assertThat(test).isEqualTo(value);
    }
    
    @Test
    public void findAllMemberTest() {
        
        List<Member> members = memberRepository.findAll();
        assertThat(members).hasSize(1);
        
        Member listMember = members.get(0);
        
        Member oneMember = memberRepository.findOne(listMember.getUserIdx());
        
        assertThat(listMember).isEqualTo(oneMember);
        
        
        
    }

}
