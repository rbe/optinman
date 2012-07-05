/*
 * optinman
 * optinman-api
 * Copyright (C) 2011-2012 art of coding UG, http://www.art-of-coding.eu
 *
 * Alle Rechte vorbehalten. Nutzung unterliegt Lizenzbedingungen.
 * All rights reserved. Use is subject to license terms.
 *
 * rbe, 6/30/12 6:12 PM
 */
package eu.artofcoding.optinman.entity;

import java.util.Calendar;

/**
 *
 */
public class AcquisitionsourceEntity implements GenericEntity {
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

    private String acquisitionsourceName;

    public String getAcquisitionsourceName() {
        return acquisitionsourceName;
    }

    public void setAcquisitionsourceName(String acquisitionsourceName) {
        this.acquisitionsourceName = acquisitionsourceName;
    }

    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcquisitionsourceEntity that = (AcquisitionsourceEntity) o;

        if (id != that.id) return false;
        if (acquisitionsourceName != null ? !acquisitionsourceName.equals(that.acquisitionsourceName) : that.acquisitionsourceName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = id;
        result = 31 * result + (acquisitionsourceName != null ? acquisitionsourceName.hashCode() : 0);
        return result.intValue();
    }
}
