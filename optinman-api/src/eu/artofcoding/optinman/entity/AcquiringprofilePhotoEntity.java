/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/27/12 5:29 PM
 */
package eu.artofcoding.optinman.entity;

import java.util.Arrays;
import java.util.Calendar;

/**
 *
 */
public class AcquiringprofilePhotoEntity implements GenericEntity {
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

    private int acquiringprofileId;

    public int getAcquiringprofileId() {
        return acquiringprofileId;
    }

    public void setAcquiringprofileId(int acquiringprofileId) {
        this.acquiringprofileId = acquiringprofileId;
    }

    private byte[] content;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] data) {
        this.content = data;
    }

    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    private String originalFilename;

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcquiringprofilePhotoEntity that = (AcquiringprofilePhotoEntity) o;

        if (acquiringprofileId != that.acquiringprofileId) return false;
        if (id != that.id) return false;
        if (!Arrays.equals(content, that.content)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = id;
        result = 31 * result + acquiringprofileId;
        result = 31 * result + (content != null ? Arrays.hashCode(content) : 0);
        return result.intValue();
    }

    private AcquiringprofileEntity acquiringprofileByAcquiringprofileId;

    public AcquiringprofileEntity getAcquiringprofileByAcquiringprofileId() {
        return acquiringprofileByAcquiringprofileId;
    }

    public void setAcquiringprofileByAcquiringprofileId(AcquiringprofileEntity acquiringprofileByAcquiringprofileId) {
        this.acquiringprofileByAcquiringprofileId = acquiringprofileByAcquiringprofileId;
    }
}
