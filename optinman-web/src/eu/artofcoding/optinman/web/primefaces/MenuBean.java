/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/6/12 8:59 AM
 */
package eu.artofcoding.optinman.web.primefaces;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MenuBean implements Serializable {

    private CategoryMenuModel menuModel = new CategoryMenuModel();

    public MenuBean() {
        try {
            MenuCategory computers = new MenuCategory("Computers");
            List<Category> computerChildren = new ArrayList<>();
            computerChildren.add(new MenuCategory("Hello"));
            computers.setChildren(computerChildren);
            menuModel.setCategory(computers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CategoryMenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(CategoryMenuModel menuModel) {
        this.menuModel = menuModel;
    }

}
