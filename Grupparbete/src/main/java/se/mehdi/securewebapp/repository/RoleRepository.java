//Mehdi
package se.mehdi.securewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mehdi.securewebapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
