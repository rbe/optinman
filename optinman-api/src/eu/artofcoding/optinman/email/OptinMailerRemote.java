/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/29/12 3:54 PM
 */
package eu.artofcoding.optinman.email;

import javax.ejb.Remote;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@Remote
public interface OptinMailerRemote {

    /**
     * Send mail1.
     * @param locale
     * @param from
     * @param subject
     * @param recipient
     */
    void sendMail1(Map<String, Object> root, Locale locale, String from, String subject, Set<String> recipient);

    /**
     * Send mail1.
     * @param locale
     * @param from
     * @param subject
     * @param recipients
     */
    void sendReminder1(Map<String, Object> root, Locale locale, String from, String subject, Set<String> recipients);

}
