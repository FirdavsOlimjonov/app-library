package uz.isft.applibary.entity.template;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class AbsAuditingEntity extends AbsTimestampEntity {

    @CreatedBy
    @Column(updatable = false)
    private UUID createdById;

    @LastModifiedBy
    private UUID updatedById;
}
