package com.example.app;

import com.example.app.persistence.entity.PermissionEntity;
import com.example.app.persistence.entity.RoleEntity;
import com.example.app.persistence.entity.RoleEnum;
import com.example.app.persistence.entity.UserEntity;
import com.example.app.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityApp {

    public static final String TEST_PASSWORD = "$2a$10$wBcXA.40TFL91FGnWfzbZ.afCToAENuckAks.bllv72O1krz/ZLtO";

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApp.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            /* Create PERMISSIONS */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();

            /* Create ROLES */
            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission))
                    .build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();

            RoleEntity roleInvited = RoleEntity.builder()
                    .roleEnum(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();

            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, deletePermission, updatePermission, refactorPermission))
                    .build();

            /* Create USERS */
            UserEntity userSantiago = UserEntity.builder()
                    .username("santiago")
                    .password(TEST_PASSWORD)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserEntity userEma = UserEntity.builder()
                    .username("ema")
                    .password(TEST_PASSWORD)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            UserEntity userOmar = UserEntity.builder()
                    .username("omar")
                    .password(TEST_PASSWORD)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();

            UserEntity userMaria = UserEntity.builder()
                    .username("maria")
                    .password(TEST_PASSWORD)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

            userRepository.saveAll(List.of(userSantiago, userEma, userOmar, userMaria));
        };

    }
}
