package com.vedalvi.jwt_auth.repo;

import com.vedalvi.jwt_auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Role,Long> {
    Role findByRole(String admin);
}
