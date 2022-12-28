package uz.isft.applibary.entity;


import javax.persistence.*;
import lombok.*;
import uz.isft.applibary.entity.enums.PageEnum;
import uz.isft.applibary.entity.enums.PermissionEnum;
import uz.isft.applibary.entity.template.AbsIntegerEntity;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbsIntegerEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private PageEnum defaultPage;

    @CollectionTable(name = "role_permission",
            joinColumns =
            @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "permission", nullable = false)
    private Set<PermissionEnum> permissions;
}
