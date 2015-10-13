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
import net.timeclip.www.member.repository.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, MybatisConfig.class })
public class MemberMapperTest {
    
    @Autowired
    private MemberMapper memberMapper;
    
    @Test
    public void before() {
        memberMapper.deleteAll();
        memberMapper.save(new Member("test", "test", "test"));
    }
    

    @Test
    public void findAllMemberTest() {
        
        List<Member> members = memberMapper.findAll();
        assertThat(members).hasSize(1);
        
        Member listMember = members.get(0);
        
        Member oneMember = memberMapper.findOne(listMember.getUserIdx());
        
        assertThat(listMember).isEqualTo(oneMember);
        
        
        
    }

}
