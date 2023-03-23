package com.wawansetiawan.machine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/media")
public class MediaController {

    private static final Logger logger = LoggerFactory.getLogger(MediaController.class);

    public MediaController() {
    }

    @CrossOrigin
    @GetMapping(value = "/{sensorId}/{timestamp}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getAudio(@PathVariable("sensorId") String sensorId, @PathVariable("timestamp") String timestamp) {
        try {
            logger.info("Handling /media/music request");

            // Load the audio file from disk
            String fileName = "soundClip/";
            if (sensorId.equals("default")) {
                fileName += timestamp + ".wav";
            } else {
                fileName += sensorId + "_" + timestamp + ".wav";
            }

            Path filePath = Paths.get(fileName).toAbsolutePath();
            File audioFile = filePath.toFile();

            // Create a resource object to represent the audio file
            InputStreamResource resource = new InputStreamResource(new FileInputStream(audioFile));

            // Build the response object with the audio file as the body
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + audioFile.getName())
                    .contentLength(audioFile.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);            
        } catch (Exception e) {
            logger.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/**")
    public ResponseEntity<Resource> handleUndefinedRequest() {

        logger.warn("Handling invalid request");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
