package uz.isft.applibary.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.isft.applibary.payload.ApiResult;
import uz.isft.applibary.payload.AttachmentDTO;
import uz.isft.applibary.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AttachmentControllerImpl implements AttachmentController {
    private final AttachmentService attachmentService;

    @Override
    public ApiResult<List<AttachmentDTO>> upload(MultipartHttpServletRequest request, Integer hotelId) {
        return attachmentService.upload(request,hotelId);
    }

    @Override
    public void getFileFrom(UUID id, HttpServletResponse response,Integer hotelId) {
        attachmentService.loadFrom(id,response,hotelId);
    }
}
