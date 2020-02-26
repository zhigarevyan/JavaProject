package entity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Data
public class Attachment implements Serializable {
    private int id;
    private String nameOfFile;
    private Date dateOfDownload;
    private String commentary;


    }

