package com.paresh.project.Lovable.Clone.Dto.Project.File;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        Long size,
        String type
) {
}
