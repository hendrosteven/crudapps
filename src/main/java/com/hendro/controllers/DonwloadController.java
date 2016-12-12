/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.controllers;

import com.hendro.entity.Curriculum;
import com.hendro.services.CurriculumService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hendro Steven
 */
@RestController
@RequestMapping("/api/download")
public class DonwloadController {

    @Autowired
    private CurriculumService curriculumService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public void download(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        Curriculum curriculum = curriculumService.findById(id);
        byte[] decodedBytes = Base64.decodeBase64(curriculum.getBase64());
        response.setContentType(curriculum.getFiletype());
        response.setHeader("Content-Disposition", "attachment; filename=" + curriculum.getFilename() + "");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.getOutputStream().write(decodedBytes);
    }
}
