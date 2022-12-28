package uz.isft.applibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isft.applibary.entity.ApiKey;

import java.util.Optional;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Integer> {
}
