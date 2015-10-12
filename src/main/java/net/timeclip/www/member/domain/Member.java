package net.timeclip.www.member.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(of = "userIdx")
public class Member {
    private Integer userIdx;
    private String userId;
    private String nameKr;
    private String userPass;
}
