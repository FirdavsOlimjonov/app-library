package uz.isft.applibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isft.applibary.entity.LanguageKey;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface LanguageKeyRepository extends JpaRepository<LanguageKey, UUID> {

    List<LanguageKey> findAllByKeyIn(Collection<String> key);

    boolean existsByKey(String value);
}
