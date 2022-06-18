package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Avatar {

    private Long            imageId;
    private Long            userId;
    private String          fileName;
    private String          fileOriginalName;
    private String          size;
    private String          mime;

    public Avatar(Long userId, String fileName, String fileOriginalName, String size, String mime) {
        this.userId = userId;
        this.fileName = fileName;
        this.fileOriginalName = fileOriginalName;
        this.size = size;
        this.mime = mime;
    }
}
