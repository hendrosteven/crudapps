/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.controllers;

import com.hendro.dto.ResponseObject;
import com.hendro.entity.Candidate;
import com.hendro.services.CandidateService;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hendro Steven
 */
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.GET)
    public Callable<ResponseObject> findAll() {
        return new Callable<ResponseObject>() {
            @Override
            public ResponseObject call() throws Exception {
                return candidateService.findAll();
            }
        };
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Callable<ResponseObject> findById(@PathVariable("id") Long id) {
        return new Callable<ResponseObject>() {
            @Override
            public ResponseObject call() throws Exception {
                return candidateService.findById(id);
            }
        };
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseObject insert(@Validated @RequestBody Candidate candidate) {
        return candidateService.insert(candidate);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseObject delete(@PathVariable("id") Long id) {
        return candidateService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseObject update(@Validated @RequestBody Candidate candidate) {
        return candidateService.update(candidate);
    }

}
