package com.hirelens.controller;

import com.hirelens.entity.Resume;
import com.hirelens.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(
            @RequestParam("file") MultipartFile file) {

        try {

            // Temporary user ID for testing
            Long userId = 1L;

            Resume resume =
                    resumeService.uploadResume(
                            file,
                            userId
                    );

            return ResponseEntity.ok(resume);

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}