package ru.dmkalvan.inote.data;

import java.security.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class NoteDataMapping {

    public static NoteData toNoteData(String id, Map<String, Object> doc) {
        Timestamp timeStamp = (Timestamp) doc.get(Fields.DATE);
        NoteData answer = new NoteData((String) doc.get(Fields.TITLE),
                (String) doc.get(Fields.DESCRIPTION),
                timeStamp.getTimestamp(),
                (String) doc.get(Fields.BODY));
        answer.setId(id);
        return answer;
    }

    public static Map<String, Object> toDocument(NoteData noteData) {
        Map<String, Object> answer = new HashMap<>();
        answer.put(Fields.TITLE, noteData.getTitle());
        answer.put(Fields.DESCRIPTION, noteData.getDescription());
        answer.put(Fields.DATE, noteData.getDate());
        answer.put(Fields.BODY, noteData.getBody());
        return answer;
    }

    public static class Fields {
        public final static String DATE = "date";
        public final static String TITLE = "title";
        public final static String DESCRIPTION = "description";
        public final static String BODY = "body";
    }
}
