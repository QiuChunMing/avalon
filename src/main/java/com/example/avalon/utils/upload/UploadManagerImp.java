package com.example.avalon.utils.upload;

import com.example.avalon.enums.ResultEnum;
import com.example.avalon.exception.SellException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
public class UploadManagerImp implements IUploadManager {

    @Value("${qiniu.access-key}")
    private String accessKey;

    @Value("${qiniu.secret-key}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    private UploadManager uploadManager;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    private void init() {
        Configuration cfg = new Configuration(Zone.zone0());
        uploadManager = new UploadManager(cfg);
    }

    private String getToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }

    @Override
    public String upload(String path) {
        //不指定key的情況下，使用文件內容的hash值作为文件名
        String key = null;
        DefaultPutRet defaultPutRet;

        try {
            Response putRet = uploadManager.put(path, key, getToken());
            defaultPutRet = convertTo(putRet.bodyString(), DefaultPutRet.class);
        } catch (QiniuException e) {
            log.error(e.getMessage());
            throw new SellException(ResultEnum.IMAGE_FAIL);
        }
        return defaultPutRet.hash;
    }

    @Override
    public String upload(byte[] uploadBytes) {
        //不指定key的情況下，使用文件內容的hash值作为文件名
        String key = null;
        DefaultPutRet defaultPutRet;

        try {
            Response putRet = uploadManager.put(uploadBytes, key, getToken());
            defaultPutRet = convertTo(putRet.bodyString(), DefaultPutRet.class);
        } catch (QiniuException e) {
            log.error(e.response.toString());
            throw new SellException(ResultEnum.IMAGE_FAIL);
        }
        return defaultPutRet.hash;
    }

    private <T> T convertTo(String json, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return t;
    }
}
