package com.jscd.app.lecture.lstRegist.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Component("fileUtils")
public class FileUtils {
//    private static final String filePath = "C:\\Users\\wjdtn\\Desktop\\jscd\\src\\main\\webapp\\resources\\upload\\img"; // 파일이 저장될 위치

    private static final String filePath = "/Users/george/Desktop/JungSuk_Project/src/main/webapp/resources/upload/img";

    public List<Map<String, Object>> parseInsertFileInfo(LstRegistDto lstRegistDto, MultipartHttpServletRequest mpRequest) throws Exception{

		/*
			Iterator은 데이터들의 집합체에서 컬렉션으로부터 정보를 얻어올 수 있는 인터페이스입니다.
			List나 배열은 순차적으로 데이터의 접근이 가능하지만, Map등의 클래스들은 순차적으로 접근할 수가 없습니다.
			Iterator을 이용하여 Map에 있는 데이터들을 while문을 이용하여 순차적으로 접근합니다.
		*/

        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null;

        int registCode = lstRegistDto.getRegistCode();

        File file = new File(filePath);
        if(file.exists() == false) {
            file.mkdirs();
        }

        while(iterator.hasNext()) {
            multipartFile = mpRequest.getFile(iterator.next());
            System.out.println("multipartFile==="+multipartFile);
            if(multipartFile.isEmpty() == false) {
                originalFileName = multipartFile.getOriginalFilename();
                System.out.println("originalFileName==="+originalFileName);
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = getRandomString() + originalFileExtension;

                file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);
                listMap = new HashMap<String, Object>();
                listMap.put("registCode", registCode);
                listMap.put("originFileName", originalFileName);
                listMap.put("storedFileName", storedFileName);
                listMap.put("fileSize", multipartFile.getSize());
                list.add(listMap);
            }
        }
        return list;
    }

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public List<Map<String, Object>> parseUpdateFileInfo(LstRegistDto lstRegistDto, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
        Iterator<String> iterator = mpRequest.getFileNames();
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null;

        int registCode = lstRegistDto.getRegistCode();

        while(iterator.hasNext()){
            multipartFile = mpRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = getRandomString() + originalFileExtension;
                multipartFile.transferTo(new File(filePath + storedFileName));
                listMap = new HashMap<String,Object>();
                listMap.put("new", "Y");
                listMap.put("registCode", registCode);
                listMap.put("originFileName", originalFileName);
                listMap.put("storedFileName", storedFileName);
                listMap.put("fileSize", multipartFile.getSize());
                list.add(listMap);
            }
        }
        if(files != null && fileNames != null){
            for(int i = 0; i<fileNames.length; i++) {
                listMap = new HashMap<String,Object>();
                listMap.put("new", "N");
                listMap.put("fileNo", files[i]);
                list.add(listMap);
            }
        }
        return list;
    }
}