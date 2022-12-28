package uz.isft.applibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isft.applibary.entity.Language;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
    Optional<Language> findByCode(String code);

    List<Language> findAllByActiveIsTrue();

    boolean existsByNameAndIdNotOrCodeAndIdNot(String name, UUID id, String code, UUID id2);

    boolean existsByNameOrCode(String name, String code);
}
