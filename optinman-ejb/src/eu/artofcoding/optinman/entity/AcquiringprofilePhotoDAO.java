/*
 * optinman
 * optinman-ejb
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/26/12 5:18 PM
 */
package eu.artofcoding.optinman.entity;

import eu.artofcoding.optinman.entity.AcquiringprofilePhotoEntity;
import eu.artofcoding.optinman.entity.GenericDAO;
import eu.artofcoding.optinman.user.AcquiringprofilePhotoDAORemote;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
@RolesAllowed({"admin"})
public class AcquiringprofilePhotoDAO extends GenericDAO<AcquiringprofilePhotoEntity> implements AcquiringprofilePhotoDAORemote {

    /**
     * Constructor.
     */
    public AcquiringprofilePhotoDAO() {
        super(AcquiringprofilePhotoEntity.class);
    }

}
