package com.shopping.micro.goods.service.impl;

import com.shopping.micro.goods.entity.FilesRes;
import com.shopping.micro.goods.repository.FilesResRepository;
import com.shopping.micro.goods.service.FilesResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/17 14:37
 * @Version 1.0
 */

@Service
@Transactional
public class FilesResServiceImpl extends AbstractBaseImpl implements FilesResService {

    @Autowired
    FilesResRepository filesResRepository;

    @Override
    public List<FilesRes> saveFileRes(List<FilesRes> filesResList) {
        return filesResRepository.saveAll(filesResList);
    }

    @Override
    public void deleteFilesRes(List<FilesRes> filesResList) {
        filesResRepository.deleteAll(filesResList);
    }

    @Override
    public void deleteFileResByFileId(Long FileId) {
        filesResRepository.deleteById(FileId);
    }
}
