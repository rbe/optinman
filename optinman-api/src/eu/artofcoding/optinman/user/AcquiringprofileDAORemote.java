/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/19/12 7:10 PM
 */
package eu.artofcoding.optinman.user;

import eu.artofcoding.optinman.entity.AcquiringprofileEntity;
import eu.artofcoding.optinman.entity.GenericDAORemote;

import javax.ejb.Remote;
import java.util.List;

/**
 *
 */
@Remote
public interface AcquiringprofileDAORemote extends GenericDAORemote<AcquiringprofileEntity> {

    /**
     * Find acquiring profiles by (nick)name.
     * @param query
     * @return List with found profile entities.
     */
    List<String> findAcquiringProfilesByName(String query);

}
