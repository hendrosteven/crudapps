/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.services;

import com.hendro.dto.MessageType;
import com.hendro.dto.ResponseObject;
import com.hendro.entity.Position;
import com.hendro.repo.PositionRepo;
import java.util.Collection;
import javax.transaction.Transactional;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hendro Steven
 */
@Service("positionService")
@Transactional
public class PositionService {

    @Autowired
    private PositionRepo positionRepo;

    public ResponseObject findById(Long id) {
        Position position = positionRepo.findOne(id);
        if (position != null) {
            return new ResponseObject(MessageType.SUCCESS, "Position By ID", position);
        } else {
            return new ResponseObject(MessageType.INFO, "Position By ID Not Found", null);
        }
    }

    public ResponseObject findAll() {
        Collection<Position> positions = IteratorUtils.toList(positionRepo.findAll().iterator());
        return new ResponseObject(MessageType.SUCCESS, "Find All Position", positions);
    }

}
