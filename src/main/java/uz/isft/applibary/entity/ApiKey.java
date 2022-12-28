package uz.isft.applibary.entity;

import javax.persistence.*;
import lombok.*;
import uz.isft.applibary.entity.template.AbsIntegerEntity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey extends AbsIntegerEntity {

    private Integer problemCrudLastDayOfMonth = 15;

    private Byte numberOfStoremenForEachStation = 3;

}
