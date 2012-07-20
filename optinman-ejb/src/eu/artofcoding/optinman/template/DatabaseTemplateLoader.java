/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/29/12 7:17 PM
 */
package eu.artofcoding.optinman.template;

import eu.artofcoding.optinman.entity.TemplateEntity;
import eu.artofcoding.optinman.template.TemplateDAORemote;
import freemarker.cache.TemplateLoader;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Connect FreeMarker's TemplateProcessor with our database through an EJB/DAO.
 */
public class DatabaseTemplateLoader implements TemplateLoader {

    private TemplateDAORemote templateDAO;

    public DatabaseTemplateLoader(TemplateDAORemote templateDAO) {
        this.templateDAO = templateDAO;
    }

    public Object findTemplateSource(String name) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        TemplateEntity templateEntity = templateDAO.findOne("Template.findByName", map);
        return templateEntity;
    }

    public long getLastModified(Object templateSource) {
        final TemplateEntity emailTemplate = (TemplateEntity) templateSource;
        templateDAO.update(emailTemplate);
        return emailTemplate.getLastModified().getTimeInMillis();
    }

    public Reader getReader(Object templateSource, String encoding) throws IOException {
        TemplateEntity templateEntity = (TemplateEntity) templateSource;
        return new StringReader(templateEntity.getContent());
    }

    public void closeTemplateSource(Object templateSource) throws IOException {
    }

}
