/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.services;

import com.hendro.dto.MessageType;
import com.hendro.dto.ResponseObject;
import com.hendro.entity.Curriculum;
import com.hendro.repo.CurriculumRepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hendro Steven
 */
@Service("curriculumService")
@Transactional
public class CurriculumService {

    @Autowired
    private CurriculumRepo curriculumRepo;

    public Curriculum findById(Long id) {
        return curriculumRepo.findOne(id);
    }
}
