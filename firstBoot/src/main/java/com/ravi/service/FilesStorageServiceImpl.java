package com.ravi.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

	@Value("${upload.path}")
	private String path;

	@Override
	public void save(MultipartFile file) {
		try {

			Files.copy(file.getInputStream(), Paths.get(path + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

}