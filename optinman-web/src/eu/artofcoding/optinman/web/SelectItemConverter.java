/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/3/12 3:42 PM
 */
package eu.artofcoding.optinman.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class SelectItemConverter implements Converter {
    
    private Map<String, SelectItem> map;
    
    public SelectItemConverter() {
        map=new HashMap<>();
        map.put("freemarker", new SelectItem("freemarker", "FreeMarker.org"));
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("getAsObject(value="+value);
        return map.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("getAsString(value="+value);
        SelectItem i = (SelectItem) value;
        return (String) i.getValue();
    }
    
}
