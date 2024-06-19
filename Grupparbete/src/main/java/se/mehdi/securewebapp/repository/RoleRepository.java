/*
info om RoleRepository, här är det samma tankar som med UserRepository men här partar vi med databasen om Roles istället.
Notera att här används inte Optional eftersom rollerna är fördefinierade!

Det ska även noteras att dessa interfaces inte gör något av sig själva utan måste "injectas" i t.ex en service klass.
 */

package se.mehdi.securewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mehdi.securewebapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
