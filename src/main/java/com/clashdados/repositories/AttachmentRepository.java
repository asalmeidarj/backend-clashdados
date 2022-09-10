package com.clashdados.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clashdados.models.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
