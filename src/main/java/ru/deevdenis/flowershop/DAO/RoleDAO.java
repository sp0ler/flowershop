package ru.deevdenis.flowershop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deevdenis.flowershop.models.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
}
