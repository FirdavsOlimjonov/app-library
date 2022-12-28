package uz.isft.applibary.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.isft.applibary.entity.Attachment;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachmentDTO {
    private UUID id;
    private String name;

    public static AttachmentDTO
    mapAttachmentToAttachmentDTO(Attachment attachment) {
        return AttachmentDTO.builder()
                .id(attachment.getId())
                .name(attachment.getName())
                .build();
    }
}
