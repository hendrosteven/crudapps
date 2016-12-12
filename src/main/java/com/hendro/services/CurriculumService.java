/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.services;

import com.hendro.entity.Curriculum;
import com.hendro.repo.CurriculumRepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service class is a business object class for manipulate Curriculum
 * object
 *
 * @author Hendro Steven
 */
@Service("curriculumService")
@Transactional
public class CurriculumService {

    @Autowired
    private CurriculumRepo curriculumRepo;

    /**
     * Get a Curriculum by Id
     *
     * @param id
     * @return
     */
    public Curriculum findById(Long id) {
        return curriculumRepo.findOne(id);
    }
}
