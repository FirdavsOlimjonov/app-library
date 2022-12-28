package uz.isft.applibary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.isft.applibary.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE language_key SET deleted=true WHERE id=?")
public class LanguageKey extends AbsUUIDEntity {

    @Column(nullable = false, unique = true)
    private String key;

    private boolean deleted;

    public LanguageKey(String key) {
        this.key = key;
    }
}
