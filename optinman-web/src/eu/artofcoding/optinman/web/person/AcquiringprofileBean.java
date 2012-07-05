/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/4/12 6:56 PM
 */
package eu.artofcoding.optinman.web.person;

import eu.artofcoding.optinman.entity.AcquiringprofileEntity;
import eu.artofcoding.optinman.entity.GenericDAOResult;
import eu.artofcoding.optinman.user.AcquiringprofileDAORemote;
import eu.artofcoding.optinman.web.AbstractCrudBean;
import eu.artofcoding.optinman.web.FacesHelper;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import java.util.logging.Logger;

/**
 * Manage details of a acquiring profile.
 */
public class AcquiringprofileBean extends AbstractCrudBean<AcquiringprofileEntity> {

    private static final Logger logger = Logger.getLogger(AcquiringprofileBean.class.getName());

    @EJB
    private AcquiringprofileDAORemote acquiringprofileDAO;

    public AcquiringprofileBean() {
        super("acquiringprofile", AcquiringprofileEntity.class);
    }

    @PostConstruct
    private void postConstruct() {
        setGenericDAO(acquiringprofileDAO);
        setPrimefacesLazyDataModel(new AcquiringprofilePrimefacesDataModel(acquiringprofileDAO));
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
                    final String personName = entity.getNickname() + ", " + entity.getFirstname() + " " + entity.getSurname();
                    FacesHelper.addMessage(FacesMessage.SEVERITY_INFO, "customerForm",
                            "eu.artofcoding.optinman.web.person",
                            "person_created_summary", "person_created_detail", personName);
                    // Reset entity
                    entity = new AcquiringprofileEntity();
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

    public String getShortname() {
        StringBuilder builder = new StringBuilder();
        String[] str = new String[]{entity.getNickname(), entity.getEmailAddress()};
        for (String s : str) {
            if (null != s) {
                if (builder.length() > 0) {
                    builder.append(", ");
                }
                builder.append(s);
            }
        }
        return builder.toString();
    }

}
