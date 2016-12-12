/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendro.dto;

/**
 * This class is a DTO object that used for the response data to the client
 * @author Hendro Steven
 */
public class ResponseObject {

    private MessageType type;
    private String messages;
    private Object payload;

    public ResponseObject() {  
    }

    public ResponseObject(MessageType type, String messages, Object payload) {       
        this.type = type;
        this.messages = messages;
        this.payload = payload;
    }

    /**
     * @return the type
     */
    public MessageType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MessageType type) {
        this.type = type;
    }

    /**
     * @return the messages
     */
    public String getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(String messages) {
        this.messages = messages;
    }

    /**
     * @return the payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    
}
