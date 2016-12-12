/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home end point
 * @author Hendro Steven
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(ModelMap model) {
        return "main";
    }
}
