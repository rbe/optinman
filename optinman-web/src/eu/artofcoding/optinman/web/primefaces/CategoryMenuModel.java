/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/6/12 8:28 AM
 */
package eu.artofcoding.optinman.web.primefaces;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.MenuModel;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CategoryMenuModel implements MenuModel, ActionListener, Serializable {

    private static final long serialVersionUID = -2866930830066526910L;
    protected Category category;
    protected List<UIComponent> contents = new ArrayList<>();
    protected static UIViewRoot uiViewRoot = new UIViewRoot();

    public Category getCategory() {
        return category;
    }

    /**
     * Creates and adds the MenuItems to the Menu.
     * @param category
     * @throws IOException
     */
    public void setCategory(Category category) throws IOException {
        this.category = category;
        resetContents();
        if (null != category.getChildren()) {
            for (Category childCategory : category.getChildren()) {
                MenuItem subCategoryItem = new MenuItem();
                subCategoryItem.setValue(childCategory.getName());
                subCategoryItem.setId(uiViewRoot.createUniqueId());
                subCategoryItem.setAjax(false);
                subCategoryItem.getAttributes().put("category", childCategory);
                subCategoryItem.addActionListener(this);
                addMenuItem(subCategoryItem);
            }
        }
    }

    /**
     * Gets called when a MenuItem is clicked. The clicked MenuItem becomes the new top level MenuItem.
     * @param event
     * @throws AbortProcessingException
     */
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        if (event.getSource().getClass() == MenuItem.class) {
            MenuItem sourceItem = (MenuItem) event.getSource();
            Category newCategory = (Category) sourceItem.getAttributes().get("category");
            try {
                setCategory(newCategory);
            } catch (IOException e) {
                throw new AbortProcessingException(e);
            }
        }
    }

    @Override
    public List<UIComponent> getContents() {
        return contents;
    }

    @Override
    public void addSubmenu(Submenu submenu) {
        contents.add(submenu);
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        contents.add(menuItem);
    }

    protected void resetContents() {
        contents = new ArrayList<>();
    }

}
