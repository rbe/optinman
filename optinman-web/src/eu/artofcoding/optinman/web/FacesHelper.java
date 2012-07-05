/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 7/3/12 1:21 PM
 */
package eu.artofcoding.optinman.web;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class FacesHelper {

    private static final Logger logger = Logger.getLogger(FacesHelper.class.getName());

    /**
     *
     */
    public void getHttpServletRequest() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
    }

    /**
     * @return
     */
    public HttpServletResponse getHttpServletResponse() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        return (HttpServletResponse) ctx.getExternalContext().getResponse();
    }

    /**
     *
     */
    public void readParameter() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, String> keymap = ctx.getExternalContext().getRequestParameterMap();
        for (String key : keymap.keySet()) {
            System.out.println("Parameter: " + key + " = " + keymap.get(key));
        }
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public Object writeToSessionMap(String key, Object value) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        return ctx.getExternalContext().getSessionMap().put(key, value);
    }

    /**
     * @param key
     * @return
     */
    public Object readSessionMap(String key) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, Object> map = ctx.getExternalContext().getSessionMap();
        return map.get(key);
    }

    /**
     * @param url
     */
    public void redirect(String url) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletResponse res = (HttpServletResponse) ctx.getExternalContext().getResponse();
        try {
            res.sendRedirect(url);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Add a JSF message for a certain component.
     * @param severity
     * @param component
     * @param resourceBundle
     * @param summaryId
     * @param detailId
     */
    public static void addMessage(FacesMessage.Severity severity, String component, String resourceBundle, String summaryId, String detailId, Object... parameters) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext.getViewRoot().getLocale();
        ResourceBundle bundle = null;
        FacesMessage facesMessage = null;
        try {
            bundle = ResourceBundle.getBundle(resourceBundle, locale);
            String summaryString = bundle.getString(summaryId);
            if (null != parameters) {
                summaryString = MessageFormat.format(summaryString, parameters);
            }
            String detailString = bundle.getString(detailId);
            if (null != parameters) {
                detailString = MessageFormat.format(detailString, parameters);
            }
            facesMessage = new FacesMessage(severity, summaryString, detailString);
        } catch (MissingResourceException e) {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getLocalizedMessage() + ": " + summaryId, detailId);
        }
        facesContext.addMessage(component, facesMessage);
    }

    /**
     * Add a JSF message for a certain component.
     * @param message
     */
    public static void addMessage(String component, String message, String detail) {
        FacesMessage facesMessage = new FacesMessage(message, detail);
        FacesContext.getCurrentInstance().addMessage(component, facesMessage);
    }

    /**
     * Simplest way to add a JSF message.
     * @param message The message.
     */
    public static void addMessage(String message) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(message));
    }

    /**
     * @param key
     * @return
     */
    public static String getMessageFromJSFBundle(String key) {
        return (String) resolveExpression("#{msgbundle['" + key + "']}");
    }

    /**
     * Find a (managed) bean in the three scopes: request, session, application.
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T findBean(String name) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        // Try to find bean in request scope
        Map<String, Object> requestMap = externalContext.getRequestMap();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        Map<String, Object> applicationMap = externalContext.getApplicationMap();
        Object bean = null;
        if (requestMap.containsKey(name)) {
            bean = requestMap.get(name);
        } else if (null == bean && sessionMap.containsKey(name)) {
            bean = sessionMap.get(name);
        } else if (null == bean && applicationMap.containsKey(name)) {
            bean = applicationMap.get(name);
        }
        return (T) bean;
    }

    /**
     * @param expression
     * @return
     */
    public static Object resolveExpression(String expression) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

}
