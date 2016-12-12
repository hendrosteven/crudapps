/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.controllers;

import com.hendro.dto.ResponseObject;
import com.hendro.services.PositionService;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for accessing position data
 * @author Hendro Steven
 */
@RestController
@RequestMapping("/api/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    /**
     * End point for get all position
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET)
    public Callable<ResponseObject> findAll() {
        return new Callable<ResponseObject>() {
            @Override
            public ResponseObject call() throws Exception {
                return positionService.findAll();
            }
        };
    }

    /**
     * End point for get position by Id
     * @param id
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Callable<ResponseObject> findById(@PathVariable("id") Long id) {
        return new Callable<ResponseObject>() {
            @Override
            public ResponseObject call() throws Exception {
                return positionService.findById(id);
            }
        };
    }

}
