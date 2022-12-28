package uz.isft.applibary.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.isft.applibary.payload.ApiResult;
import uz.isft.applibary.payload.AttachmentDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

public interface AttachmentService {

    ApiResult<List<AttachmentDTO>> upload(MultipartHttpServletRequest request, Integer hotelId);

    void loadFrom(UUID id, HttpServletResponse response,Integer hotelId);
}
