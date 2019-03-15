package com.makerspace.demo.work.service;

import com.makerspace.demo.utils.PageBean;
import com.makerspace.demo.work.domain.Work;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WorkService {
    PageBean getPageBean(Integer limit, Integer page,  String type, String name, String teamName);

    PageBean getPageBeanCheck(Integer limit, Integer page);

    Work selectByWorkId(Long workId);

    List<Work> selectByTeam(Long teamId);

    List<Work> selectByTime();

    List<Work> selectByHits();

    int workDelete(Long workId);

    int updateWork (Work work);

    int workCheck(Long workId, Long passCode);

    int insert(Work work, Long teamId, String suffix,String data);

    String upload(String suffix, String FileName, String data, Boolean insert);

    int updateImage(Long workId, String suffix,String data);

//    Boolean upload(Long workId, MultipartFile file);
    String staticImage(String suffix,  String data);

    String base64Data(Long workId);

    //    List<Work> selectNoCheck();
//    int workCheckNoPass(Long workId);
}
