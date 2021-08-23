package com.adson.aplimc.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String buckeName;

	public URI uploadFile(MultipartFile multipartFile) { // aula 86
		try {
			String fileName = multipartFile.getOriginalFilename(); // extrai nome do arquivo enviado
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType(); // pega o tipo enviado
			return uploadFile(is, fileName, contentType);

		} catch (IOException e) {
			throw new RuntimeException("Erro de IO: " + e.getMessage());
		}

	}

	public URI uploadFile(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Inicializando upload");
			s3client.putObject(buckeName, fileName, is, meta);
			LOG.info("upload finalizado");
			return s3client.getUrl(buckeName, fileName).toURI();

		} catch (URISyntaxException e) {
			throw new RuntimeException("Error ao converter URL para URI");
		}
	}

}