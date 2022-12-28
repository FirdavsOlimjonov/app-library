package uz.isft.applibary.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


public class CommonUtils {


    public static String ATTACHMENT_DOWNLOAD_PATH;
    public static String ATTACHMENT_MEDIUM_VIEW_PATH;
    public static String DOMAIN;

    public static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    public static TypeFactory typeFactory = TypeFactory.defaultInstance();

    //
    public static String getDownloadPath(String fileId) {
        if (fileId == null) return null;
        return DOMAIN + "/" + ATTACHMENT_DOWNLOAD_PATH + "?id=" + fileId;
    }


//    public static Date stringToDate(String date) throws ParseException {
//        return new SimpleDateFormat("dd/MM/yyyy").parse(date);
//    }
//
//    //REQUEST DAN USER ID NI OLIB BERADI
//    public static String getUserIdFromRequestHeader() {
//        try {
//            HttpServletRequest httpServletRequest = currentRequest();
//
//            return (String) httpServletRequest.getAttribute(REQUEST_ATTRIBUTE_CURRENT_USER_ID);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    //REQUEST DAN PERMISSION LARNI OLIB BERADI
//    public static String getUserPermissionsFromRequestHeader() {
//        try {
//            HttpServletRequest httpServletRequest = currentRequest();
//            return httpServletRequest.getHeader(REQUEST_ATTRIBUTE_CURRENT_USER_ID);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static String getUserIdFromRequest(HttpServletRequest httpServletRequest) {
//        return httpServletRequest.getHeader(AUTHENTICATION_HEADER);
//    }
//
//    public static String getUserPermissionsFromRequest(HttpServletRequest httpServletRequest) {
//        return httpServletRequest.getHeader(RestConstants.REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS);
//    }
//
//    public static HttpServletRequest currentRequest() {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        return Optional
//                .ofNullable(servletRequestAttributes)
//                .map(ServletRequestAttributes::getRequest)
//                .orElse(null);
//    }
//
//    //REQUEST DAN TOKENNI OLIB BERADI
//    public static String getTokenFromRequest() {
//        HttpServletRequest httpServletRequest = currentRequest();
//        if (Objects.isNull(httpServletRequest)) {
//            return "";
//        }
//        String header = httpServletRequest.getHeader(RestConstants.AUTHORIZATION_HEADER);
//        return Objects.nonNull(header) ? header : "";
//    }


}
