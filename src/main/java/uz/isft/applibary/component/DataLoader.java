package uz.isft.applibary.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.isft.applibary.entity.LanguageKey;
import uz.isft.applibary.entity.Role;
import uz.isft.applibary.entity.User;
import uz.isft.applibary.entity.enums.MessagesEnum;
import uz.isft.applibary.entity.enums.PageEnum;
import uz.isft.applibary.entity.enums.PermissionEnum;
import uz.isft.applibary.repository.ApiKeyRepository;
import uz.isft.applibary.repository.LanguageKeyRepository;
import uz.isft.applibary.repository.RoleRepository;
import uz.isft.applibary.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final LanguageKeyRepository languageKeyRepository;
    private final ApiKeyRepository apiKeyRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.phoneNumber}")
    private String adminPhoneNumber;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String modeType;

    @Value("${spring.datasource.username}")
    private String dbName;

    @Override
    public void run(String... args) {
        if (Objects.equals("create", modeType)) {
            addAdmin();
        }
        addNewLanguageKeys();
//        addApiKeys();

    }

    private void addNewLanguageKeys() {
        Set<String> alreadySaved = languageKeyRepository.findAllByKeyIn(
                Arrays.stream(MessagesEnum.values()).map(Enum::name).collect(Collectors.toList())
        ).stream().map(LanguageKey::getKey).collect(Collectors.toSet());


        List<LanguageKey> languageKeys = Arrays.stream(MessagesEnum.values())
                .filter(messagesEnum -> !alreadySaved.contains(messagesEnum.name()))
                .map(messagesEnum ->
                        new LanguageKey(
                                messagesEnum.name()
                        ))
                .collect(Collectors.toList());

        languageKeyRepository.saveAll(languageKeys);
    }

//    private void addApiKeys() {
//        ApiKey apiKey = apiKeyRepository
//                .findFirstByIdIsNotNull()
//                .orElseGet(ApiKey::new);
//        apiKeyRepository.save(apiKey);
//    }

    private void addAdmin() {
        userRepository.save(
                User.builder()
                        .firstName("Admin")
                        .lastName("")
                        .phoneNumber(adminPhoneNumber)
                        .password(passwordEncoder.encode(adminPassword))
                        .role(addAdminRole())
                        .enabled(true)
                        .build());
    }

    private Role addAdminRole() {
        return roleRepository.save(
                new Role("ADMIN",
                        "System owner",
                        PageEnum.ROLE,
                        Set.of(PermissionEnum.values())
                )
        );
    }

}
