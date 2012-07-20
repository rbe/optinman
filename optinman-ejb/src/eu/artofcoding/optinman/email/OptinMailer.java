/*
 * optinman
 * optinman-ejb
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/29/12 3:37 PM
 */
package eu.artofcoding.optinman.email;

import eu.artofcoding.optinman.template.DatabaseTemplateLoader;
import eu.artofcoding.optinman.template.TemplateDAORemote;
import eu.artofcoding.optinman.template.TemplateProcessor;
import freemarker.template.TemplateException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@Stateless
public class OptinMailer implements OptinMailerRemote {

    @EJB
    private TemplateDAORemote templateDAO;
    
    @EJB
    private EmailerRemote emailer;

    @Inject
    private TemplateProcessor templateProcessor;

    @PostConstruct
    void postConstruct() {
        // Setup TemplateProcessor to load templates from database
        templateProcessor.addTemplateLoader(new DatabaseTemplateLoader(templateDAO));
    }

    /**
     * Constructor.
     */
    public OptinMailer() {
    }

    /**
     * Send mail1.
     * @param locale
     * @param from
     * @param subject
     * @param recipients
     */
    @Override
    public void sendMail1(Map<String, Object> root, Locale locale, String from, String subject, Set<String> recipients) {
        try {
            // Render template depending on request locale
            String body = templateProcessor.renderTemplateToString("tussibook_optin_mail1", locale, root);
            // Send email
            if (null != recipients) {
                emailer.sendMail(from, recipients, subject, body, "text/html; charset=utf8");
            } else {
                throw new IllegalStateException("No recipients!");
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send the first reminder to click registration link.
     * @param locale
     * @param from
     * @param subject
     * @param recipients
     */
    @Override
    public void sendReminder1(Map<String, Object> root, Locale locale, String from, String subject, Set<String> recipients) {
        try {
            // Render template depending on request locale
            String body = templateProcessor.renderTemplateToString("tussibook_optin_reminder1", locale, root);
            // Send email
            if (null != recipients) {
                emailer.sendMail(from, recipients, subject, body, "text/html; charset=utf8");
            } else {
                throw new IllegalStateException("No recipients!");
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
