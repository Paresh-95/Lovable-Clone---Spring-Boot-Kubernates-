package com.paresh.project.Lovable.Clone.Service;

import com.paresh.project.Lovable.Clone.Dto.Project.File.FileContentResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.File.FileNode;



import java.util.List;


public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
