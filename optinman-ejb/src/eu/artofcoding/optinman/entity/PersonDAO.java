package eu.artofcoding.optinman.entity;

import eu.artofcoding.optinman.entity.GenericDAO;
import eu.artofcoding.optinman.entity.PersonEntity;
import eu.artofcoding.optinman.user.PersonDAORemote;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
@RolesAllowed({"admin"})
public class PersonDAO extends GenericDAO<PersonEntity> implements PersonDAORemote {

    /**
     * Constructor.
     */
    public PersonDAO() {
        super(PersonEntity.class);
    }

}
