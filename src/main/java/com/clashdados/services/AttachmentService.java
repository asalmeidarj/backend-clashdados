package com.clashdados.services;

import org.springframework.web.multipart.MultipartFile;

import com.clashdados.models.Attachment;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
