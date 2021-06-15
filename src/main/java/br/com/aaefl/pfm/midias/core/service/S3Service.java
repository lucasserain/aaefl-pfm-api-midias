package br.com.aaefl.pfm.midias.core.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class S3Service {

    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${s3.bucket}")
    private String bucketName;

    public URI uploadFile(MultipartFile multipartFile) throws IOException, URISyntaxException {

            String fileName = multipartFile.getOriginalFilename();
            InputStream is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();
            return uploadFile(is,fileName,contentType);
    }

    public URI uploadFile(InputStream is, String fileName, String contetTYpe) throws URISyntaxException {
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType(contetTYpe);
        s3client.putObject(new PutObjectRequest(bucketName, fileName+".mp4", is, meta).withCannedAcl(CannedAccessControlList.PublicRead));
        return  s3client.getUrl(bucketName,fileName).toURI();
    }

}
