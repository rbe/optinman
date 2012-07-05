/*
 * optinman
 * optinman-ejb
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/19/12 7:10 PM
 */
package eu.artofcoding.optinman.entity;

import eu.artofcoding.optinman.entity.AcquiringprofileEntity;
import eu.artofcoding.optinman.entity.GenericDAO;
import eu.artofcoding.optinman.user.AcquiringprofileDAORemote;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Stateless
@RolesAllowed({"admin"})
public class AcquiringprofileDAO extends GenericDAO<AcquiringprofileEntity> implements AcquiringprofileDAORemote {

    /**
     * Constructor.
     */
    public AcquiringprofileDAO() {
        super(AcquiringprofileEntity.class);
    }

    @Override
    public List<String> findAcquiringProfilesByName(final String query) {
        List<String> _list = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", query + "%");
        List<AcquiringprofileEntity> entities = findAll("Acquiringprofile.findByName", params);
        if (null != entities) {
            for (AcquiringprofileEntity e : entities) {
                _list.add(e.getNickname()); //e.getFirstname() + " " + e.getSurname() + " (" + e.getNickname() + ")"
            }
        }
        return _list;
    }

}
