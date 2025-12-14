package com.paresh.project.Lovable.Clone.Entity;


import com.paresh.project.Lovable.Clone.Enum.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
@Setter
public class Preview {
    Long id;
    Project project;

    String namepace;
    String podName;
    String previewUrl;

    PreviewStatus status;

    Instant startedAt;
    Instant terminatedAt;
    Instant createdAt;





}
