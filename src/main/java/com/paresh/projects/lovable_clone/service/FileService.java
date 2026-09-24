package com.paresh.projects.lovable_clone.service;

import com.paresh.projects.lovable_clone.dto.project.file.FileContentResponse;
import com.paresh.projects.lovable_clone.dto.project.file.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
