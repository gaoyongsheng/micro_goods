package com.shopping.micro.goods.service;

import com.shopping.micro.goods.entity.FilesRes;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/17 14:36
 * @Version 1.0
 */
public interface FilesResService {

    List<FilesRes> saveFileRes(List<FilesRes> filesRes);

    void deleteFilesRes(List<FilesRes> filesResList);

    void deleteFileResByFileId(Long FileId);
}
