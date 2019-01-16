package com.example.avalon.utils.upload;


public interface IUploadManager {
    String upload(String path);
    String upload(byte[] uploadBytes);
}
