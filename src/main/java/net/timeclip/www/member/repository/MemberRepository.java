package net.timeclip.www.member.repository;

import org.springframework.stereotype.Repository;

import net.timeclip.www.common.repository.BaseRepository;
import net.timeclip.www.member.domain.Member;

@Repository
public class MemberRepository extends BaseRepository<Member, Long, MemberMapper> {

    @Override
    public Member save(Member t) {
        
        if(t.getUserIdx() == null && super.findOne(t.getUserIdx()) == null) {
            Long id = super.saveAndGetId(t);
            t.setUserIdx(id);
        } else {
            update(t);
        }
        
        return t;
    }
}
