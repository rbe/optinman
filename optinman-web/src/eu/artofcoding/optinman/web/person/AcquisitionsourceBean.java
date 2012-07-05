/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/2/12 8:42 AM
 */
package eu.artofcoding.optinman.web.person;

import eu.artofcoding.optinman.entity.AcquisitionsourceEntity;
import eu.artofcoding.optinman.entity.GenericDAOResult;
import eu.artofcoding.optinman.user.AcquisitionsourceDAORemote;
import eu.artofcoding.optinman.web.AbstractCrudBean;
import eu.artofcoding.optinman.web.FacesHelper;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;

/**
 *
 */
public class AcquisitionsourceBean extends AbstractCrudBean<AcquisitionsourceEntity> {

    private static final Logger logger = Logger.getLogger(AcquisitionsourceBean.class.getName());

    @EJB
    private AcquisitionsourceDAORemote acquisitionsourceDAO;

    public AcquisitionsourceBean() {
        super("acquisitionsource", AcquisitionsourceEntity.class);
    }

    @PostConstruct
    public void postConstruct() {
        setGenericDAO(acquisitionsourceDAO);
        setPrimefacesLazyDataModel(new AquisitionsourcePrimefacesDataModel(acquisitionsourceDAO));
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
                    final String name = entity.getAcquisitionsourceName();
                    FacesHelper.addMessage(FacesMessage.SEVERITY_INFO, "acquisitionsourceForm",
                            "eu.artofcoding.optinman.web.person",
                            "person_created_summary", "person_created_detail", name);
                    // Reset entity
                    entity = new AcquisitionsourceEntity();
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

}
