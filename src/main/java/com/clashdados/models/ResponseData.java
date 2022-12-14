package com.clashdados.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

	private String id_file;
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
    
}
