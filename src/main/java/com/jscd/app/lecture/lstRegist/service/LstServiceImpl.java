package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.lstRegist.dao.LstRegistDao;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import com.jscd.app.lecture.lstRegist.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LstServiceImpl implements LstService {

    @Resource(name="fileUtils")
    private FileUtils fileUtils;

    @Autowired
    LstRegistDao lstRegistDao;
    //1.강의 목록
    @Override
    public List<LstRegistDto> getLstRegistList() throws Exception {
        return lstRegistDao.getRegistList();
    }

    //2.강의 등록
    @Override
    public void addRegist(LstRegistDto lstRegistDto,  MultipartHttpServletRequest mpRequest) throws Exception {
        lstRegistDao.addRegist(lstRegistDto);
        System.out.println("service lstRegistDto = " + lstRegistDto);
        System.out.println("mpRequest = " + mpRequest);
        List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(lstRegistDto, mpRequest);
        int size = list.size();
        for(int i=0; i<size; i++){
            lstRegistDao.InsertFile(list.get(i));
        }

    }
    //3.강의 상세
    @Override
    public Map<String, Object> readRegist(Integer registCode) throws Exception {
        return lstRegistDao.readRegist(registCode);
    }
    //4.강의 삭제
    @Override
    public int removeRegist(Integer registCode) throws Exception {
        return lstRegistDao.removeRegist(registCode);
    }
    //5.강의 수정
    @Override
    public int modifyRegist(LstRegistDto dto) throws Exception {
        return lstRegistDao.modifyRegist(dto);
    }
    //6.검색 및 페이지
    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return lstRegistDao.searchResultCnt(sc);
    }
    @Override
    public List<LstRegistDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return lstRegistDao.searchSelectPage(sc);
    }

    //7.세미나
    @Override
    public List<LstRegistDto> seminarList() throws Exception {
        return lstRegistDao.getSeminarList();
    }

    @Override
    public LstRegistDto seminarRead(Integer registCode) throws Exception {
        LstRegistDto lstRegistDto = lstRegistDao.readSeminar(registCode);
        return lstRegistDto;
    }
    //8.부트캠프
    @Override
    public List<LstRegistDto> bootCampList() throws Exception {
        return lstRegistDao.getBootCampList();
    }

    @Override
    public LstRegistDto bootCampRead(Integer registCode) throws Exception {
        LstRegistDto lstRegistDto = lstRegistDao.readBootCamp(registCode);
        return lstRegistDto;
    }

    // 첨부파일 조회
    @Override
    public List<Map<String, Object>> selectFileList(Integer registCode) throws Exception {
        // TODO Auto-generated method stub
        return lstRegistDao.selectFileList(registCode);
    }

    @Override
    public Map<String, Object> selectFileDown(Map<String, Object> map) throws Exception {
        return lstRegistDao.selectFileDown(map);
    }

}
