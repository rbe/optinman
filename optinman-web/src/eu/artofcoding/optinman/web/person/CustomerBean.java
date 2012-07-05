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

import eu.artofcoding.optinman.entity.GenericDAOResult;
import eu.artofcoding.optinman.entity.PersonEntity;
import eu.artofcoding.optinman.user.AcquiringprofileDAORemote;
import eu.artofcoding.optinman.user.AcquisitionsourceDAORemote;
import eu.artofcoding.optinman.user.PersonDAORemote;
import eu.artofcoding.optinman.web.AbstractCrudBean;
import eu.artofcoding.optinman.web.FacesHelper;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Manage details of a customer.
 */
public class CustomerBean extends AbstractCrudBean<PersonEntity> {

    private static final Logger logger = Logger.getLogger(CustomerBean.class.getName());

    @EJB
    private PersonDAORemote personDAO;

    @EJB
    private AcquiringprofileDAORemote acquiringprofileDAO;

    @EJB
    private AcquisitionsourceDAORemote acquisitionsourceDAO;

    private Map<String, String> salutation;

    public CustomerBean() {
        super("customer", PersonEntity.class);
    }

    @PostConstruct
    private void postConstruct() {
        setGenericDAO(personDAO);
        setPrimefacesLazyDataModel(new CustomerPrimefacesDataModel(personDAO));
    }

    @Override
    public void preRenderView() throws IllegalAccessException, InstantiationException {
        super.preRenderView();
        entity.setSalutation("Herr");
    }

    public void setSalutation(Map<String, String> salutation) {
        this.salutation = salutation;
    }

    public Map<String, String> getSalutation() {
        return salutation;
    }

    /**
     * Find acquiring profiles by nickname.
     * @param query Value entered by user.
     * @return List with found profiles.
     */
    public List<String> findAcquiringProfiles(final String query) {
        return acquiringprofileDAO.findAcquiringProfilesByName(query);
    }

    /**
     * Find sources of acquisition.
     * @param query Value entered by user.
     * @return List with found acquisition sources.
     */
    public List<String> findSourceOfAcquistion(final String query) {
        return acquisitionsourceDAO.findSourceOfAcquisitionByName(query);
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
                            "eu.artofcoding.optinman.web.person", "person_created_summary", "person_created_detail",
                            personName);
                    // Reset entity if it has an ID, so we consider it was saved (before)
                    if (null != entity && entityHasId()) {
                        PersonEntity person2 = new PersonEntity();
                        person2.setAcquiringprofile(entity.getAcquiringprofile());
                        person2.setSourceOfAcquisition(entity.getSourceOfAcquisition());
                        person2.setSalutation("Herr");
                        entity = person2;
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

    public String getShortname() {
        StringBuilder builder = new StringBuilder();
        String[] str = new String[]{entity.getFirstname() + " " + entity.getSurname(), entity.getNickname(), entity.getEmailAddress()};
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

    public void sendWelcomeEmail() {
        System.out.println("YEE-HA.");
    }
    
}
