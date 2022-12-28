package uz.isft.applibary.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.isft.applibary.entity.Attachment;
import uz.isft.applibary.exceptions.RestException;
import uz.isft.applibary.payload.ApiResult;
import uz.isft.applibary.payload.AttachmentDTO;
import uz.isft.applibary.repository.AttachmentRepository;
import uz.isft.applibary.util.MessageConstants;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;

    @Value("${app.upload.folder}")
    private String UPLOAD_FOLDER_PATH;

    @SneakyThrows
    @Override
    public ApiResult<List<AttachmentDTO>> upload(MultipartHttpServletRequest request, Integer hotelId) {
        List<AttachmentDTO> attachmentDTOList = new ArrayList<>();

        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()) {
            String key = fileNames.next();
            List<MultipartFile> files = request.getFiles(key);
            for (MultipartFile file : files) {
                Attachment attachment = new Attachment();
                attachment.setName(file.getOriginalFilename());
                attachment.setSize(file.getSize());
                attachment.setContentType(file.getContentType());
                attachment = attachmentRepository.save(attachment);
                attachmentDTOList.add(AttachmentDTO
                        .mapAttachmentToAttachmentDTO(attachment));

                FileCopyUtils.copy(file.getInputStream(),
                        makeFileOutputStream(attachment.getId(), Objects.requireNonNull(file.getOriginalFilename()), hotelId));
            }
        }

        return ApiResult.successResponse(attachmentDTOList);
    }

    @SneakyThrows
    @Override
    public void loadFrom(@NonNull UUID id, HttpServletResponse response,Integer hotelId) {
        Attachment attachment = findAttachmentOrThrow(id);

        response.setHeader("Content-disposition", "inline; filename=\"" + attachment.getName() + "\"");
        response.setHeader("Cache-Control", "max-age=8640000");
        response.setContentLength(attachment.getSize().intValue());
        response.setContentType(attachment.getContentType());
        FileCopyUtils.copy(
                makeFileInputStream(attachment.getId(),attachment.getName(),hotelId),
                response.getOutputStream());
    }

    private Attachment findAttachmentOrThrow(UUID id) {
        return attachmentRepository.findById(id).orElseThrow(() ->
                RestException.restThrow(MessageConstants.ATTACHMENT_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    private FileOutputStream makeFileOutputStream(UUID id, String originalName, Integer hotelId) throws FileNotFoundException {
        return new FileOutputStream(UPLOAD_FOLDER_PATH + id + originalName.substring(originalName.lastIndexOf(".")));
    }

    private FileInputStream makeFileInputStream(UUID id, String originalName,Integer hotelId) throws FileNotFoundException {
        return new FileInputStream(UPLOAD_FOLDER_PATH + id + originalName.substring(originalName.lastIndexOf(".")));
    }
}
