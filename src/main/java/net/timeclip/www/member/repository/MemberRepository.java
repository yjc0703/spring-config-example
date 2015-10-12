package net.timeclip.www.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import net.timeclip.www.member.domain.Member;

@Repository
public interface MemberRepository {
    
    @Select(value = "SELECT #{value}")
    Integer test(Integer value);
    
    @Select(value = "SELECT * FROM TB_MEMBER")
    List<Member> findAll();
    
    @Select(value = "SELECT * FROM TB_MEMBER WHERE USERIDX = #{id}")
    Member findOne(Integer integer);
}
