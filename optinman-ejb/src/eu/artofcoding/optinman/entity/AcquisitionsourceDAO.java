/*
 * optinman
 * optinman-ejb
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/30/12 6:19 PM
 */
package eu.artofcoding.optinman.entity;

import eu.artofcoding.optinman.entity.AcquisitionsourceEntity;
import eu.artofcoding.optinman.entity.GenericDAO;
import eu.artofcoding.optinman.user.AcquisitionsourceDAORemote;

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
public class AcquisitionsourceDAO extends GenericDAO<AcquisitionsourceEntity> implements AcquisitionsourceDAORemote {

    /**
     * Constructor.
     */
    public AcquisitionsourceDAO() {
        super(AcquisitionsourceEntity.class);
    }

    @Override
    public List<String> findSourceOfAcquisitionByName(String query) {
        List<String> _list = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", query + "%");
        List<AcquisitionsourceEntity> entities = findAll("Acquisitionsource.findByName", params);
        if (null != entities) {
            for (AcquisitionsourceEntity e : entities) {
                _list.add(e.getAcquisitionsourceName());
            }
        }
        return _list;
    }

}
