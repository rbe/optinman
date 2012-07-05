/*
 * optinman
 * optinman-ejb
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/27/12 5:10 PM
 */
package eu.artofcoding.optinman.entity;

import java.util.Calendar;
import java.util.Collection;

/**
 *
 */
public class AcquiringprofileEntity implements GenericEntity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Calendar lastModified;

    public Calendar getLastModified() {
        return lastModified;
    }

    public void setLastModified(Calendar lastModified) {
        this.lastModified = lastModified;
    }

    public void updateLastModified() {
        setLastModified(Calendar.getInstance());
    }

    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private String salutation;

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String mailPassword;

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    private String mailServer;

    public String getMailServer() {
        return mailServer;
    }

    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    private String mailServerPort;

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    private String mailServerProtocol;

    public String getMailServerProtocol() {
        return mailServerProtocol;
    }

    public void setMailServerProtocol(String mailServerProtocol) {
        this.mailServerProtocol = mailServerProtocol;
    }

    private String mailUsername;

    public String getMailUsername() {
        return mailUsername;
    }

    public void setMailUsername(String mailUsername) {
        this.mailUsername = mailUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcquiringprofileEntity that = (AcquiringprofileEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (mailPassword != null ? !mailPassword.equals(that.mailPassword) : that.mailPassword != null) return false;
        if (mailServer != null ? !mailServer.equals(that.mailServer) : that.mailServer != null) return false;
        if (mailServerPort != null ? !mailServerPort.equals(that.mailServerPort) : that.mailServerPort != null)
            return false;
        if (mailServerProtocol != null ? !mailServerProtocol.equals(that.mailServerProtocol) : that.mailServerProtocol != null)
            return false;
        if (mailUsername != null ? !mailUsername.equals(that.mailUsername) : that.mailUsername != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (salutation != null ? !salutation.equals(that.salutation) : that.salutation != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = id;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (salutation != null ? salutation.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (mailPassword != null ? mailPassword.hashCode() : 0);
        result = 31 * result + (mailServer != null ? mailServer.hashCode() : 0);
        result = 31 * result + (mailServerPort != null ? mailServerPort.hashCode() : 0);
        result = 31 * result + (mailServerProtocol != null ? mailServerProtocol.hashCode() : 0);
        result = 31 * result + (mailUsername != null ? mailUsername.hashCode() : 0);
        return result.intValue();
    }

    private Collection<AcquiringprofilePhotoEntity> photosById;

    public Collection<AcquiringprofilePhotoEntity> getPhotosById() {
        return photosById;
    }

    public void setPhotosById(Collection<AcquiringprofilePhotoEntity> photosById) {
        this.photosById = photosById;
    }
}
