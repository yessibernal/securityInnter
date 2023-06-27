package com.innter.pos.securityInnter.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fi_id")
    private Long id;

    @Column(name = "fb_enabled")
    private short enabled;

    @Column(name = "fc_password")
    private String password;

    @Column(name = "fc_username")
    private String username;

    @Column(name = "fc_name")
    private String name;

    @Column(name = "fc_last_name")
    private String lastName;

    @Column(name = "fc_email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_users_rols",
            joinColumns = @JoinColumn(name = "fi_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fi_rol_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"fi_user_id", "fi_rol_id"})})
    private List<RolEntity> rols = new ArrayList<>();
}
