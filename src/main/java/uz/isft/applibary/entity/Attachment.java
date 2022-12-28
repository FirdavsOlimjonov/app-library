package uz.isft.applibary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import uz.isft.applibary.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attachment extends AbsUUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String contentType;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
