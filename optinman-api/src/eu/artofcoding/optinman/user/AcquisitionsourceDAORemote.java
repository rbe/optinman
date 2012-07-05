/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/30/12 6:20 PM
 */
package eu.artofcoding.optinman.user;

import eu.artofcoding.optinman.entity.AcquisitionsourceEntity;
import eu.artofcoding.optinman.entity.GenericDAORemote;

import javax.ejb.Remote;
import java.util.List;

/**
 *
 */
@Remote
public interface AcquisitionsourceDAORemote extends GenericDAORemote<AcquisitionsourceEntity> {

    /**
     * Find acquisition sources by name.
     * @param query
     * @return List with found acquisition source entities.
     */
    List<String> findSourceOfAcquisitionByName(String query);

}
