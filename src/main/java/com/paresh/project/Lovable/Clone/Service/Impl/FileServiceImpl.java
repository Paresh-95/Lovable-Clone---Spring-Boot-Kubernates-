package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Project.File.FileContentResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.File.FileNode;
import com.paresh.project.Lovable.Clone.Service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
