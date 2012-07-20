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

import eu.artofcoding.optinman.entity.AcquisitionsourceEntity;
import eu.artofcoding.optinman.entity.GenericDAORemote;
import eu.artofcoding.optinman.web.primefaces.AbstractPrimefacesLazyDataModel;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AquisitionsourcePrimefacesDataModel extends AbstractPrimefacesLazyDataModel<AcquisitionsourceEntity> {

    protected AquisitionsourcePrimefacesDataModel(GenericDAORemote<AcquisitionsourceEntity> genericDAO) {
        super(genericDAO);
    }

    @Override
    public AcquisitionsourceEntity getRowData(String rowKey) {
        System.out.println("getRowData(" + rowKey + ")");
        Map<String, Object> map = new HashMap<>();
        map.put("name", rowKey + "%");
        return genericDAO.findOne("Acquisitionsource.findByName", map);
    }

}
