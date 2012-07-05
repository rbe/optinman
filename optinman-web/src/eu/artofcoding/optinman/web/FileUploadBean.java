/*
 * optinman
 * optinman-web
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/30/12 10:28 PM
 */
package eu.artofcoding.optinman.web;

import eu.artofcoding.optinman.entity.AcquiringprofilePhotoEntity;
import eu.artofcoding.optinman.user.AcquiringprofilePhotoDAORemote;
import eu.artofcoding.optinman.web.person.AcquiringprofileBean;
import org.primefaces.event.FileUploadEvent;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 *
 */
public class FileUploadBean {

    @EJB
    private AcquiringprofilePhotoDAORemote acquiringprofilePhotoDAO;
    
    /**
     * @param event
     */
    public String handleFileUpload(FileUploadEvent event) {
        /*
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Bean bean = (Bean) facesContext.getApplication().evaluateExpressionGet(facesContext, "#{acquiringprofileBean}", Bean.class);
        */
        String filename = event.getFile().getFileName();
        AcquiringprofileBean acquiringprofileBean = (AcquiringprofileBean) FacesHelper.findBean("acquiringprofileBean");
        String nickname = acquiringprofileBean.getEntity().getNickname();
        if (null!= nickname) {
            System.out.println(nickname + " has a new photo " + filename);
            AcquiringprofilePhotoEntity photo = new AcquiringprofilePhotoEntity();
            photo.setAcquiringprofileByAcquiringprofileId(acquiringprofileBean.getEntity());
            photo.setContent(event.getFile().getContents());
            photo.setContentType(event.getFile().getContentType());
            try {
                acquiringprofilePhotoDAO.create(photo);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            FacesHelper.addMessage("registrationForm:photo", "Uploaded " + filename, "Yee-ha.");
            return "ok";
        } else {
            FacesHelper.addMessage("registrationForm:photo", "Cannot upload " + filename, ", sorry!");
            return "missingNickname";
        }
    }

    /**
     * http://stackoverflow.com/questions/5498391/how-to-download-a-file-stored-in-a-database-with-jsf-2-0
     * @param photo
     */
    public void startDownload(AcquiringprofilePhotoEntity photo) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.setResponseHeader("Content-Type", photo.getContentType());
        externalContext.setResponseHeader("Content-Length", String.valueOf(photo.getContent().length));
        //externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + photo.getFileName() + "\"");
        try {
            externalContext.getResponseOutputStream().write(photo.getContent());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        facesContext.responseComplete();
    }

    /**
     * http://stackoverflow.com/questions/9391838/how-to-stream-a-file-download-in-a-jsf-backing-bean
     * @throws IOException
     */
    /*
    public void download() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
        ec.setResponseContentType(contentType); // Check http://www.w3schools.com/media/media_mimeref.asp for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
        ec.setResponseContentLength(contentLength); // Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.
        OutputStream output = ec.getResponseOutputStream();
        // Now you can write the InputStream of the file to the above OutputStream the usual way.
        // ...
        fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
    }
    */

}
