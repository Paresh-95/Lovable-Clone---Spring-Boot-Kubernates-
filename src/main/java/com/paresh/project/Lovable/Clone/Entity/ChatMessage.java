package com.paresh.project.Lovable.Clone.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


@FieldDefaults(level = AccessLevel.PROTECTED)
@Setter
@Getter
public class ChatMessage {

    Long id;
    ChatSession chatSession;

    String content;
    String toolCalls; //JSON ARRAY OF TOOLS CALLED

    Integer tokenUsed;

    Instant createdAt;




}
