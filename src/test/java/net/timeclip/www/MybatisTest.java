package net.timeclip.www;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.timeclip.www.config.MybatisConfig;
import net.timeclip.www.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, MybatisConfig.class })
public class MybatisTest {
    
    @Autowired
    private SqlSession session;

    @Test
    public void test() {
        Integer test = session.selectOne("net.timeclip.www.member.test");
        assertThat(test).isEqualTo(1);
    }

}
