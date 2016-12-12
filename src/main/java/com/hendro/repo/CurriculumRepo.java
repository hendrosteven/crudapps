/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.repo;

import com.hendro.entity.Curriculum;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Hendro Steven
 */
public interface CurriculumRepo extends PagingAndSortingRepository<Curriculum, Long> {

}
