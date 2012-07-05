/*
 * app1
 * app1ea-ejbapi
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/13/12 6:01 PM
 */
package eu.artofcoding.optinman.email;

import javax.ejb.Remote;
import java.util.Set;

/**
 *
 */
@Remote
public interface EmailerRemote {

    /**
     * @param fromAddress
     * @param recipient
     * @param subject
     * @param body
     * @param contentType
     */
    void sendMail(String fromAddress, Set<String> recipient, String subject, String body, String contentType);

    /**
     * @param fromAddress
     * @param recipient
     * @param subject
     * @param body
     */
    void sendPlainTextMail(String fromAddress, Set<String> recipient, String subject, String body);

}
