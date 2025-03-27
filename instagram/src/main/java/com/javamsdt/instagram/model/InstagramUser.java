package com.javamsdt.instagram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instagram_user")
public record InstagramUser (
        @Id Long id,
         String username,
        String profilePicture
) {

}
