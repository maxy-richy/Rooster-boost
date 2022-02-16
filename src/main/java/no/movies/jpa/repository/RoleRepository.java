package no.movies.jpa.repository;

import no.movies.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
public Role findByRole(String role);
}