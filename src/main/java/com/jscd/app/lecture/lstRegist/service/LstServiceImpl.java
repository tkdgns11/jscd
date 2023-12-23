package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.lstRegist.dao.LstRegistDao;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import com.jscd.app.lecture.lstRegist.dto.lstregistfileDto;
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
//        System.out.println("service lstRegistDto = " + lstRegistDto);
//        System.out.println("mpRequest = " + mpRequest);
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
    public void modifyRegist(LstRegistDto lstRegistDto, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
        // 전달받은 lstRegistDto는 dao로 보낸다.
        lstRegistDao.modifyRegist(lstRegistDto);
        // 전달받은 첨부파일은 Map형태로 정리하고 list로 묶어서 보낸다.
        List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(lstRegistDto, files, fileNames, mpRequest);

        Map<String, Object> tempMap = null;
        int size = list.size();
        for(int i=0; i<size; i++) {
            tempMap = list.get(i);
            // parseUpdateFileInfo를 통해 전달받은 데이터 중 new의 Y값을 갖고 있다면 insertFile로 아니면 updateFile로 보낸다.
            if(tempMap.get("new").equals("Y")) {
                lstRegistDao.InsertFile(tempMap);
            } else {
                lstRegistDao.updateFile(tempMap);
            }
        }
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
    public List<lstregistfileDto> seminarList() throws Exception {
        return lstRegistDao.getSeminarList();
    }
    @Override
    public LstRegistDto seminarRead(Integer registCode) throws Exception {
        LstRegistDto lstRegistDto = lstRegistDao.readSeminar(registCode);
        return lstRegistDto;
    }
    @Override
    public List<lstregistfileDto> seminarPaging(Map map) throws Exception {
        return lstRegistDao.seminarPaging(map);
    }
    // 7.4 진행예정 세미나 리스트
    @Override
    public List<lstregistfileDto> appointSMList(Map map) throws Exception {
        return lstRegistDao.appointSMList(map);
    }
    // 7.5 세미나 진행 페이징
    @Override
    public List<lstregistfileDto> processSMList(Map map) throws Exception {
        return lstRegistDao.processSMList(map);
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
    @Override
    public List<LstRegistDto> bootCampPaging(Map map) throws Exception {
        return lstRegistDao.bootCampPaging(map);
    }
    // 8.4 부트캠프 진행예정 리스트
    @Override
    public List<LstRegistDto> appointBTList(Map map) throws Exception {
        return lstRegistDao.appointBTList(map);
    }
    // 7.5 부트캠프 진행 페이징
    @Override
    public List<LstRegistDto> processBTList(Map map) throws Exception {
        return lstRegistDao.processBTList(map);
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

    @Override
    public int getCountAll() throws Exception {
        return lstRegistDao.countRegist();
    }

    @Override
    public int getCountBT() throws Exception {
        return lstRegistDao.countBT();
    }

    @Override
    public int getCountSM() throws Exception {
        return lstRegistDao.countSM();
    }
    // 진행예정 부트캠프 카운팅
    @Override
    public int getAppointCountBT() throws Exception {
        return lstRegistDao.countAppointBT();
    }
    // 진행 중 부트캠프 카운팅
    @Override
    public int getProcessCountBT() throws Exception {
        return lstRegistDao.countProcessBT();
    }
    // 진행예정 세미나 카운팅
    @Override
    public int getAppointCountSM() throws Exception {
        return lstRegistDao.countAppointSM();
    }
    // 진행 중 세미나 카운팅
    @Override
    public int getProcessCountSM() throws Exception {
        return lstRegistDao.countProcessSM();
    }

    // 홈 화면 세미나 리스트(2개)
    @Override
    public List<LstRegistDto> homeSeminarList() throws Exception {
        return lstRegistDao.homeSeminarList();
    }

    // 홈 화면 부트캠프 리스트(2개)
    @Override
    public List<LstRegistDto> homeBootCampList() throws Exception {
        return lstRegistDao.homeBootCampList();
    }

}
