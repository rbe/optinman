/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/2/12 10:04 PM
 */
package eu.artofcoding.optinman.web.person;

import eu.artofcoding.optinman.entity.TemplateEntity;
import eu.artofcoding.optinman.template.TemplateDAORemote;
import eu.artofcoding.optinman.web.AbstractPrimefacesLazyDataModel;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 */
public class TemplatePrimefacesDataModel extends AbstractPrimefacesLazyDataModel<TemplateEntity> {

    private static final Logger logger = Logger.getLogger(TemplatePrimefacesDataModel.class.getName());

    public TemplatePrimefacesDataModel(TemplateDAORemote templateDAO) {
        super(templateDAO);
    }

    @Override
    public TemplateEntity getRowData(String rowKey) {
        logger.info("getRowData(" + rowKey + ")");
        Map<String, Object> map = new HashMap<>();
        map.put("name", rowKey + "%");
        return genericDAO.findOne("Template.findByName", map);
    }

}
