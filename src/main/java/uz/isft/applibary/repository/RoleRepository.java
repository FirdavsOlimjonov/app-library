package uz.isft.applibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isft.applibary.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByName(String name);

    List<Role> findAllByIdIsNot(Integer id);

    Optional<Role> findByNameContainsIgnoreCase(String name);
}
