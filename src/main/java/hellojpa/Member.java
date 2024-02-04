package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name") //필드와 매핑할 테이블 컬럼 이름
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {
    }

}
