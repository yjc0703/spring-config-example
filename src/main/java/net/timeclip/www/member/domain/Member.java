package net.timeclip.www.member.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data @EqualsAndHashCode(of = "userIdx")
public class Member {
    private Long userIdx;
    private String userId;
    private String nameKr;
    private String userPass;
    
    public Member(String userId, String nameKr, String userPass) {
        super();
        this.userId = userId;
        this.nameKr = nameKr;
        this.userPass = userPass;
    }
    
    
}
