package com.bolsaempleo.backend.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto implements Serializable{

    private UUID id;
	private Timestamp createdAt;
	private String guardName;
	private String name;
	private Timestamp updatedAt;
}
