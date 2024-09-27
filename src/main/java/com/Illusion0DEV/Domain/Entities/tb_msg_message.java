package com.Illusion0DEV.Domain.Entities;

import jakarta.persistence.*;

import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_msg_message")
public class tb_msg_message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID msg_id;

    public String msg_message_content;

    //CONSTRUCTOR
    public tb_msg_message() {}

    //GETTERS
    public UUID get_msg_id() {
        return msg_id;
    }
    public String get_msg_message_content() {
        return msg_message_content;
    }

    //SETTERS
    public void set_msg_id(UUID msg_id) {
        this.msg_id = msg_id;
    }
    public void set_msg_message_content(String msg_message_content) {
        this.msg_message_content = msg_message_content;
    }
}
