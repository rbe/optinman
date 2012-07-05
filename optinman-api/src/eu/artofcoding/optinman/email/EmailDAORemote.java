/*
 * app1
 * app1ea-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/14/12 1:20 PM
 */

package eu.artofcoding.optinman.email;

import eu.artofcoding.optinman.entity.EmailEntity;
import eu.artofcoding.optinman.entity.GenericDAORemote;

import javax.ejb.Remote;

/**
 *
 */
@Remote
public interface EmailDAORemote extends GenericDAORemote<EmailEntity> {
}
