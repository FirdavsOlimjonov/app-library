package uz.isft.applibary.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.isft.applibary.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    boolean existsByRoleId(Integer id);
    boolean existsById(@NonNull UUID id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE User SET role = :insteadOfRoleId WHERE role = :id")
    void updateRole(Integer id, Integer insteadOfRoleId);

    boolean existsByPhoneNumber(String phoneNumber);

    List<User> findAllByDeletedFalse();

}
