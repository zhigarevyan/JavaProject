package entity;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ShortContact {
    private int id;
    private int contactInfoId;
    private int attachmentId;
    private int telephoneNumberId;

}
