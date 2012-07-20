/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/6/12 9:00 AM
 */
package eu.artofcoding.optinman.web.primefaces;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 */
public class MenuCategory implements Category, Serializable {

    private String name;

    private Collection<Category> children;

    public MenuCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<Category> getChildren() {
        return children;
    }

    public void setChildren(Collection<Category> children) {
        this.children = children;
    }

}
