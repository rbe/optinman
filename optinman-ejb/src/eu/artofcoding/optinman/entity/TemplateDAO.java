/*
 * optinman
 * optinman-ejb
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/29/12 6:43 PM
 */
package eu.artofcoding.optinman.entity;

import eu.artofcoding.optinman.template.TemplateDAORemote;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
@RolesAllowed({"admin"})
public class TemplateDAO extends GenericDAO<TemplateEntity> implements TemplateDAORemote {

    public TemplateDAO() {
        super(TemplateEntity.class);
    }

}
