/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/2/12 10:31 AM
 */
package eu.artofcoding.optinman.web;

import eu.artofcoding.optinman.email.OptinMailerRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 */
@WebServlet(name = "MyEmailServlet", urlPatterns = {"/email"})
public class MyEmailServlet extends HttpServlet {

    @EJB
    private OptinMailerRemote optinMailer;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            // Data model for template
            final Map<String, Object> root = new HashMap<>();
            root.put("user", "Big Joe");
            root.put("shortname", "Susi Sorglos");
            root.put("acquiringprofile_platform", "http://www.blasen+pusten.de");
            root.put("registrationUrl", "http://www.example.com/registration/complete/abc123");
            // Get recipient
            String[] recipient = request.getParameterValues("recipient");
            if (null != recipient) {
                Set<String> toAddress = new HashSet<>();
                Collections.addAll(toAddress, recipient);
                // Send email
                optinMailer.sendMail1(root, request.getLocale(), "alice@example.com", "This is an email!", toAddress);
                // Write response
                out.write("Sent test mail!\n");
            } else {
                throw new IllegalStateException("No recipient!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Write response
            out.write("Error sending test mail!\n");
            out.write(e.toString());
        } finally {
            out.close();
        }
    }

}
