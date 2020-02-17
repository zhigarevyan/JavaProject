package entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Data
public class Attachments {
    private String nameOfFile;
    private Date dateOfDownload;
    private String commentary;
}
