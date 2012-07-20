/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/6/12 8:27 AM
 */
package eu.artofcoding.optinman.web.primefaces;

import java.util.Collection;

/**
 *
 */
public interface Category {

    String getName();

    Collection<Category> getChildren();

}
