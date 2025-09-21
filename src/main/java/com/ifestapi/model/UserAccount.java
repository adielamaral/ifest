package com.ifestapi.model;

import com.ifestapi.enums.Gender;
import com.ifestapi.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String document;

    @Column(nullable = false)
    private String address;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean consentAccepted;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>();

    public boolean isUSER() { return roles.contains(Role.USER); }
    public boolean isOWNER() { return roles.contains(Role.OWNER); }
    public boolean isCLIENT() { return roles.contains(Role.CLIENT); }
    public boolean isAdmin() { return roles.contains(Role.SUPERADMIN); }

}
