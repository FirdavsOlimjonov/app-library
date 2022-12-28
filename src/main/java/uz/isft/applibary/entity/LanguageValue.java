package uz.isft.applibary.entity;

import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.isft.applibary.entity.template.AbsUUIDEntity;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE language_value SET deleted=true WHERE id=?")
@Builder
public class LanguageValue extends AbsUUIDEntity {

    @JoinColumn(insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;

    @Column(name = "language_id", nullable = false)
    private UUID languageId;

    @JoinColumn(insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageKey languageKey;

    @Column(name = "language_key_id", nullable = false)
    private UUID languageKeyId;

    @Column(nullable = false)
    private String value;
}
