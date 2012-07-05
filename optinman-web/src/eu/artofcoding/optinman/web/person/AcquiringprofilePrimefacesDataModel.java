/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/1/12 1:17 PM
 */
package eu.artofcoding.optinman.web.person;

import eu.artofcoding.optinman.entity.AcquiringprofileEntity;
import eu.artofcoding.optinman.user.AcquiringprofileDAORemote;
import eu.artofcoding.optinman.web.AbstractPrimefacesLazyDataModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AcquiringprofilePrimefacesDataModel extends AbstractPrimefacesLazyDataModel<AcquiringprofileEntity> {

    public AcquiringprofilePrimefacesDataModel(AcquiringprofileDAORemote acquiringprofileDAO) {
        super(acquiringprofileDAO);
    }

    @Override
    public AcquiringprofileEntity getRowData(String rowKey) {
        System.out.println("getRowData(" + rowKey + ")");
        Map<String, Object> map = new HashMap<>();
        map.put("name", rowKey + "%");
        return genericDAO.findOne("Acquiringprofile.findByName", map);
    }

}
