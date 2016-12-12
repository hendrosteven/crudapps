/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

/**
 * This class represent the Curriculum Vitae file. The uploaded file are stored as base64 String.
 * @author Hendro Steven
 */
@Entity
@Table(name = "tblcurriculum")
public class Curriculum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Maximum file size is limited only 3 mb
     */
    @Column(nullable = false)
    @Max(value = 3000000, message = "error.curriculum.size")
    private int filesize;
    @Column(nullable = false, length = 20)
    private String filetype;
    @Column(nullable = false, length = 200)
    private String filename;
    @Column(nullable = false, length = 10000)
    private String base64;

    /**
     * @return the filetype
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * @param filetype the filetype to set
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the base64
     */
    public String getBase64() {
        return base64;
    }

    /**
     * @param base64 the base64 to set
     */
    public void setBase64(String base64) {
        this.base64 = base64;
    }

    /**
     * @return the filesize
     */
    public int getFilesize() {
        return filesize;
    }

    /**
     * @param filesize the filesize to set
     */
    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

}
