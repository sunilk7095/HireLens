package com.hirelens.service;

import com.hirelens.entity.Resume;
import com.hirelens.repository.ResumeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final S3Service s3Service;

    public ResumeService(
            ResumeRepository resumeRepository,
            S3Service s3Service) {

        this.resumeRepository = resumeRepository;
        this.s3Service = s3Service;
    }

    public Resume uploadResume(
            MultipartFile file,
            Long userId) throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        if (!"application/pdf".equals(file.getContentType())) {
            throw new RuntimeException(
                    "Only PDF files are allowed"
            );
        }

        Resume resume = new Resume();

        resume.setUserId(userId);
        resume.setFileName(file.getOriginalFilename());
        resume.setFileSize(file.getSize());
        resume.setFileType(file.getContentType());
        resume.setStatus("UPLOADED");

        Resume savedResume =
                resumeRepository.save(resume);

        String key =
                "users/"
                        + userId
                        + "/resumes/"
                        + savedResume.getId()
                        + "/"
                        + UUID.randomUUID()
                        + ".pdf";

        s3Service.uploadFile(key, file);

        savedResume.setS3Key(key);

        return resumeRepository.save(savedResume);
    }
}