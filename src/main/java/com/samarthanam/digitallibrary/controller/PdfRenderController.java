package com.samarthanam.digitallibrary.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@EnableSwagger2
@ApiOperation("Content rendering")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PdfRenderController {

    @GetMapping(value = "digital_library/v1/pdfs/{pdf_book_id}", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> renderPdf() throws IOException {

        ClassPathResource pdfFile = new ClassPathResource("TaxProof_UserManual_Upload.pdf");
        return ResponseEntity
                .ok()
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(pdfFile.getInputStream()));

    }

    @GetMapping(value = "digital_library/v1/audios/{audio_book_id}", produces = "application/json")
    public ResponseEntity<InputStreamResource> renderAudio() throws IOException {

        return null;
        // TO-DO Implementation
    }

    @GetMapping(value = "digital_library/v1/audios/{audio_file_name}")
    public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
        //below commented line to pull file from cloud
        //final byte[] data = someservice.downloadFile(cloudkey);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ClassPathResource pdfFile = new ClassPathResource("file_example_MP3_700KB.mp3");
        return ResponseEntity
                .ok()
                .contentLength(pdfFile.contentLength())
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(pdfFile.getInputStream()));

    }
}
