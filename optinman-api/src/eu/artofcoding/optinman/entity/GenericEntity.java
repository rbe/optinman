/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/30/12 3:05 PM
 */
package eu.artofcoding.optinman.entity;

import java.io.Serializable;

/**
 *
 */
public interface GenericEntity extends Serializable {
    
    public Long getId();
    
    public Long getVersion();
    
}
