package pl.rpgprojekt.dao;

import org.springframework.stereotype.Repository;
import pl.rpgprojekt.entities.Role;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Override
    public Role findByName (String name) {
        return null;
    }
}
