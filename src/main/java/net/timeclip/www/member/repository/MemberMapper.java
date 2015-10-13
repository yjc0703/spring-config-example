package net.timeclip.www.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.timeclip.www.common.annotation.Mapper;
import net.timeclip.www.common.repository.BaseMapper;
import net.timeclip.www.member.domain.Member;

@Mapper
public interface MemberMapper extends BaseMapper<Member, Long> {
    
    @Override
    @Delete("DELETE TB_MEMBER WHERE USERIDX = #{id}")
    void delete(Long id);
    
    @Override
    @Delete("DELETE TB_MEMBER")
    void deleteAll();
    
    @Override
    @Insert("INSERT INTO TB_MEMBER(USERID, NAMEKR, USERPASS) VALUES(#{userId}, #{nameKr}, #{userPass});")
    Long save(Member t);
    
    @Override
    @Update("UPDATE TB_MEMBER SET USERID = #{userId}, NAMEKR = #{nameKr}, USERPASS = #{userPass} WHERE USERIDX = #{userIdx}")
    Long update(Member t);
    
    @Override
    @Select("SELECT * FROM TB_MEMBER")
    List<Member> findAll();
    
    @Override
    @Select("SELECT * FROM TB_MEMBER WHERE USERIDX = #{id}")
    Member findOne(Long id);
    


}
