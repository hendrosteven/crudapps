/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.services;

import com.hendro.dto.MessageType;
import com.hendro.dto.ResponseObject;
import com.hendro.entity.Candidate;
import com.hendro.repo.CandidateRepo;
import java.util.Collection;
import javax.transaction.Transactional;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hendro Steven
 */
@Service("candidateService")
@Transactional
public class CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    public ResponseObject findById(Long id) {
        Candidate candidate = candidateRepo.findOne(id);
        if (candidate != null) {
            return new ResponseObject(MessageType.SUCCESS, "Candidate By ID", candidate);
        } else {
            return new ResponseObject(MessageType.INFO, "Candidate By ID Not Found", null);
        }
    }

    public ResponseObject findAll() {
        Collection<Candidate> candidates = IteratorUtils.toList(candidateRepo.findAll().iterator());
        return new ResponseObject(MessageType.SUCCESS, "Find All Candidate", candidates);
    }

    
    public ResponseObject insert(Candidate candidate) {
        Candidate newCandidate = candidateRepo.save(candidate);
        if (newCandidate != null) {
            return new ResponseObject(MessageType.SUCCESS, "New Candidate saved", newCandidate);
        } else {
            return new ResponseObject(MessageType.INFO, "New Candidate can't be saved", null);
        }
    }

    public ResponseObject delete(Long id) {
        Candidate candidate = candidateRepo.findOne(id);
        if (candidate != null) {
            candidateRepo.delete(candidate);
            return new ResponseObject(MessageType.SUCCESS, "Candidate deleted", null);
        } else {
            return new ResponseObject(MessageType.INFO, "Candidate cannot be deleted", null);
        }

    }

    public ResponseObject update(Candidate candidate) {
        Candidate newCandidate = candidateRepo.save(candidate);
        if (newCandidate != null) {
            return new ResponseObject(MessageType.SUCCESS, "Candidate data updated", newCandidate);
        } else {
            return new ResponseObject(MessageType.INFO, "Candidate data cannot be updated", null);
        }
    }
}
