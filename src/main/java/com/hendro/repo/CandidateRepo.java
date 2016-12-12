/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.repo;

import com.hendro.entity.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Extends Spring framework repository class, so by default this class will have all CRUD method
 * @author Hendro Steven
 */
public interface CandidateRepo extends PagingAndSortingRepository<Candidate, Long> {

}
