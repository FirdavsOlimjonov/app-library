package uz.isft.applibary.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.isft.applibary.entity.template.AbsUUIDEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Language extends AbsUUIDEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String code;

    private boolean active;
}
