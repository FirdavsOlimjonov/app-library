package uz.isft.applibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isft.applibary.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
