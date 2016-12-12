/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * This class represent the Candidate
 *
 * @author Hendro Steven
 */
@Entity
@Table(name = "tblcandidate")
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Field name validation using bean validation : can't be null, min length
     * 2, max length 100, only containing letters
     */
    @Column(length = 100, nullable = false)
    @NotNull(message = "error.name.notnull")
    @Size(min = 2, max = 100, message = "error.name.size")
    @Pattern(regexp = "^\\pL+[\\pL\\pZ\\pP]{0,}$", message = "error.name.letters")
    private String name;

    /**
     * Field surename validation using bean validation : can't be null, min
     * length 2, max length 200, only containing letters
     */
    @Column(length = 200, nullable = false)
    @NotNull(message = "error.surename.notnull")
    @Size(min = 2, max = 200, message = "error.surename.size")
    @Pattern(regexp = "^\\pL+[\\pL\\pZ\\pP]{0,}$", message = "error.surename.letters")
    private String sureName;

    /**
     * Field position validation using bean validation : can't be null
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(nullable = false)
    @NotNull(message = "error.position.notnull")
    private Position position;

    /**
     * Field curriculum validation using bean validation : can't be null
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    @NotNull(message = "error.curriculum.notnull")
    @NotFound(action = NotFoundAction.IGNORE)
    private Curriculum curriculum;

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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sureName
     */
    public String getSureName() {
        return sureName;
    }

    /**
     * @param sureName the sureName to set
     */
    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the curriculum
     */
    public Curriculum getCurriculum() {
        return curriculum;
    }

    /**
     * @param curriculum the curriculum to set
     */
    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

}
