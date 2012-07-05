/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/29/12 6:42 PM
 */
package eu.artofcoding.optinman.template;

import eu.artofcoding.optinman.entity.GenericDAORemote;
import eu.artofcoding.optinman.entity.TemplateEntity;

import javax.ejb.Remote;

/**
 *
 */
@Remote
public interface TemplateDAORemote extends GenericDAORemote<TemplateEntity> {
}
