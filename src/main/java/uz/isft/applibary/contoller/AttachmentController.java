package uz.isft.applibary.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.isft.applibary.payload.ApiResult;
import uz.isft.applibary.payload.AttachmentDTO;
import uz.isft.applibary.util.RestConstants;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RequestMapping(value = AttachmentController.ATTACHMENT_CONTROLLER_BASE_PATH)
public interface AttachmentController {
    String ATTACHMENT_CONTROLLER_BASE_PATH = RestConstants.BASE_PATH+"attachment";

    @PostMapping("/upload/{hotelId}")
    ApiResult<List<AttachmentDTO>> upload(MultipartHttpServletRequest request,
                                          @PathVariable Integer hotelId);

    @GetMapping("/load/{hotelId}/{id}")
    void getFileFrom(@PathVariable UUID id, HttpServletResponse response,
                     @PathVariable Integer hotelId);

}

