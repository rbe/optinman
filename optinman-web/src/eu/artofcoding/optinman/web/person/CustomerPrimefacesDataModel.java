/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/1/12 1:13 PM
 */
package eu.artofcoding.optinman.web.person;

import eu.artofcoding.optinman.entity.PersonEntity;
import eu.artofcoding.optinman.user.PersonDAORemote;
import eu.artofcoding.optinman.web.AbstractPrimefacesLazyDataModel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 */
public class CustomerPrimefacesDataModel extends AbstractPrimefacesLazyDataModel<PersonEntity> {

    private static final Logger logger = Logger.getLogger(CustomerPrimefacesDataModel.class.getName());

    public CustomerPrimefacesDataModel(PersonDAORemote personDAO) {
        super(personDAO);
    }

    @Override
    public PersonEntity getRowData(String rowKey) {
        logger.info("getRowData(" + rowKey + ")");
        Map<String, Object> map = new HashMap<>();
        map.put("name", rowKey + "%");
        return genericDAO.findOne("Person.findByName", map);
    }

}
