package com.bolsaempleo.backend.app.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest {

    private Long id;
	private Timestamp createdAt;
	private String guardName;
	private String name;
	private Timestamp updatedAt;
}
