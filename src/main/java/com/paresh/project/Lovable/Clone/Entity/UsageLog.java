package com.paresh.project.Lovable.Clone.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class UsageLog {

    Long id;
    User user;
    Project project;
    String action;
    Integer tokensUsed;
    Integer durationMs;
    String metaData;  //STORE JSON OF MODEL USED OR PROMPT USED
    Instant createdAt;


}
