package uz.isft.applibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.isft.applibary.entity.LanguageValue;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LanguageValueRepository extends JpaRepository<LanguageValue, UUID> {
    Optional<LanguageValue> findFirstByLanguageIdAndLanguageKeyId(UUID languageId, UUID languageKeyId);

    List<LanguageValue> findAllByLanguage_Code(String language_code);


    @Query(value = "select cast(jsonb_object_agg(lk.key, lv.value) as varchar)\n" +
            "from language_key lk\n" +
            "         left join language_value lv\n" +
            "                   on lk.id = lv.language_key_id and\n" +
            "                      lv.language_id = (select id from language where deleted = false and code = :language)", nativeQuery = true)
    String getValuesByLang(@Param("language") String language);


    @Query(value = "select * from get_string_result_of_query(:query)", nativeQuery = true)
    List<String> getValuesByLangByQueryForId(@Param("query") String query);


    @Query(value = "select * from get_string_result_of_query(:query)", nativeQuery = true)
    String getValuesByLangByQueryForRow(@Param("query") String query);

}
