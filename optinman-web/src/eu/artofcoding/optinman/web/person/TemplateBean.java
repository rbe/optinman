/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/3/12 4:02 PM
 */
package eu.artofcoding.optinman.web.person;

import eu.artofcoding.optinman.entity.GenericDAOResult;
import eu.artofcoding.optinman.entity.TemplateEntity;
import eu.artofcoding.optinman.template.TemplateDAORemote;
import eu.artofcoding.optinman.web.primefaces.AbstractCrudBean;
import eu.artofcoding.optinman.web.FacesHelper;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 */
public class TemplateBean extends AbstractCrudBean<TemplateEntity> {

    private static final Logger logger = Logger.getLogger(TemplateBean.class.getName());

    @EJB
    private TemplateDAORemote templateDAO;

    private Map<String, String> templateTypes;

    public TemplateBean() {
        super("template", TemplateEntity.class);
    }

    @PostConstruct
    private void postConstruct() {
        setGenericDAO(templateDAO);
        setPrimefacesLazyDataModel(new TemplatePrimefacesDataModel(templateDAO));
    }

    public Map<String, String> getTemplateTypes() {
        return templateTypes;
    }

    public void setTemplateTypes(Map<String, String> templateTypes) {
        this.templateTypes = templateTypes;
    }

    public List<SelectItem> getTemplateTypesAsSelectItems() {
        List<SelectItem> _list = new ArrayList<>();
        for (String t : templateTypes.keySet()) {
            _list.add(new SelectItem(t, templateTypes.get(t)));
        }
        return _list;
    }

    /**
     * User wants to persist data.
     * @return Navigation case.
     */
    public String userActionPersist() {
        try {
            GenericDAOResult result = super.persist();
            if (GenericDAOResult.OK == result) {
                if (wasUpdated()) {
                    return navigate("edit");
                } else if (entityHasId()) {
                    // Show message
                    FacesHelper.addMessage("templateForm", "Aktualisiert!", "The template " + entity.getTemplateName() + " was updated!");
                    // Reset entity if it has an ID, so we consider it was saved (before)
                    if (null != entity && entityHasId()) {
                        entity = new TemplateEntity();
                    }
                    return navigate("edit");
                } else {
                    return navigate("show");
                }
            } else {
                return navigate("error");
            }
        } catch (Exception e) {
            throw new FacesException(e);
        }
    }

    public String getDirectURL() {
        return "edit_template.xhtml?id=" + entity.getId();
    }

}
