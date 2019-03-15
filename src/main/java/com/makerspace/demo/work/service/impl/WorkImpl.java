package com.makerspace.demo.work.service.impl;

import com.makerspace.demo.team.dao.TeamMapper;
import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.utils.*;
import com.makerspace.demo.work.dao.WorkContextMapper;
import com.makerspace.demo.work.dao.WorkMapper;
import com.makerspace.demo.work.domain.Work;
import com.makerspace.demo.work.domain.WorkContext;
import com.makerspace.demo.work.domain.WorkExample;
import com.makerspace.demo.work.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class WorkImpl implements WorkService {
    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private WorkContextMapper workContextMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public PageBean getPageBean(Integer limit, Integer page, String type, String name, String teamName) throws RuntimeException{
        try {
            WorkExample example = new WorkExample();
            WorkExample.Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(false);
            criteria.andIsCheckEqualTo(true);

            WorkExample.Criteria criteria2 = example.or();
            criteria2.andIsDeleteEqualTo(false);
            criteria2.andIsCheckEqualTo(true);

            if (name!= null) {
                criteria.andNameLike("%" + name + "%");
                criteria2.andNameLike("%" + name + "%");
            }
            if (type!= null) {

                criteria.andTypeTechnologyEqualTo(type);
                criteria2.andTypeIndustryEqualTo(type);
            }
            if (teamName!= null) {
                criteria.andTeamNameLike("%" + teamName + "%");
                criteria2.andTeamNameLike("%" + teamName + "%");
            }
            int count = (int) workMapper.countByExample(example);
            if(count>0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                List<Work> workList = (workMapper.selectByExample(example));
                for(Work work : workList){
                    if(work.getShowPic()!=null){
                        work.setShowPic(Base64.toBase64W(work.getShowPic()));
                    }
                }
                pageBean.setList(workList);
                return pageBean;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public PageBean getPageBeanCheck(Integer limit, Integer page) throws RuntimeException{
        try {
            WorkExample example = new WorkExample();
            WorkExample.Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(false);
            criteria.andIsCheckEqualTo(false);
            int count = (int) workMapper.countByExample(example);
            if (count > 0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                List<Work> workList = (workMapper.selectByExample(example));
                for(Work work : workList){
                    if(work.getShowPic()!=null){
                        work.setShowPic(Base64.toBase64W(work.getShowPic()));
                    }
                }
                pageBean.setList(workList);
                return pageBean;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Work selectByWorkId(Long workId)throws RuntimeException{
        try {
            Work work = workMapper.selectByWorkId(workId);
            if (work!=null){
                if (work.getIsDelete()){
                    return null;
                }else {
                    workMapper.updateHitsByWorkId(workId);
                    work.setShowPic(Base64.toBase64W(work.getShowPic()));
                    return work;
                }
            }else{
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Work> selectByTeam(Long teamId) throws RuntimeException{
        try {
            WorkExample example =new WorkExample();
            WorkExample.Criteria criteria = example.createCriteria();
            //example.setLimit(3);
            criteria.andAffiliateTeamEqualTo(teamId);
            criteria.andIsCheckEqualTo(true);
            criteria.andIsDeleteEqualTo(false);
            return workMapper.selectByExample(example);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Work> selectByTime() throws RuntimeException{
        try{
            WorkExample example =new WorkExample();
            WorkExample.Criteria criteria = example.createCriteria();
            criteria.andIsCheckEqualTo(true);
            criteria.andIsDeleteEqualTo(false);
            example.setOrderByClause("gmt_create desc");
            example.setLimit(8);
            example.setDistinct(true);
            List<Work> list = workMapper.selectByExample(example);
            for(Work work : list){
                if(work.getShowPic()!=null){
                    work.setShowPic(Base64.toBase64W(work.getShowPic()));
                }
            }
            if (list!=null && list.size()>0){
                return list;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Work> selectByHits()throws RuntimeException{
        try{
            WorkExample example =new WorkExample();
            WorkExample.Criteria criteria = example.createCriteria();
            criteria.andIsCheckEqualTo(true);
            criteria.andIsDeleteEqualTo(false);
            example.setOrderByClause("hits desc");
            example.setLimit(8);
            example.setDistinct(true);
            List<Work> list = workMapper.selectByExample(example);
            for(Work work : list){
                if(work.getShowPic()!=null){
                    work.setShowPic(Base64.toBase64W(work.getShowPic()));
                }
            }
            if (list!=null && list.size()>0){
                return list;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int workDelete(Long workId)throws RuntimeException{
        try {
            Work work = new Work();
            work.setPkId(workId);
            work.setIsDelete(true);
            return workMapper.updateByPrimaryKeySelective(work);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public int updateWork (Work work)throws RuntimeException{
        try {
            work.setIsCheck(false);
            WorkContext workContext =new WorkContext();
            workContext.setContext(work.getWorkContext().getContext());
            workContext.setPkId(work.getPkId());
            workMapper.updateByPrimaryKeySelective(work);
            workContextMapper.updateByPrimaryKeySelective(workContext);
            //workMapper.selectByWorkId(work.getPkId());
            return 1;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }



    @Override
    public int workCheck(Long workId, Long passCode) throws RuntimeException{
        try{
            if (workMapper.selectByPrimaryKey(workId)!=null){
                if (passCode == 1) {
                    Work work = new Work();
                    work.setPkId(workId);
                    work.setIsCheck(true);
                    return workMapper.updateByPrimaryKeySelective(work);
                }else {
                    Work work = new Work();
                    work.setPkId(workId);
                    work.setIsCheck(false);
                    work.setIsDelete(true);
                    return workMapper.updateByPrimaryKeySelective(work);
                }
            }
            else {
                return 0;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public int insert(Work work, Long teamId, String suffix, String data) throws RuntimeException{
        try {
            work.setGmtCreate(new Date());
            work.setGmtModified(new Date());
            work.setIsDelete(false);
            work.setIsCheck(false);
            work.setAffiliateTeam(teamId);
            work.setHits(0L);
            work.setTeamName(teamMapper.selectTNameByTeamId(teamId));
            work.setShowPic(upload(suffix, null, data, true));
            WorkContext workContext =new WorkContext();
            workContext.setContext(work.getWorkContext().getContext());
            workContext.setGmtCreate(new Date());
            workContext.setGmtModified(new Date());
            workContextMapper.insert(workContext);
            return workMapper.insert(work);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }


    @Override
    public int updateImage(Long workId, String suffix,String data) {
        Work work = workMapper.selectByPrimaryKey(workId);
        work.setShowPic(upload(suffix, work.getShowPic(), data, false));
        work.setIsCheck(false);
        return workMapper.updateByPrimaryKey(work);
    }



    @Override
    public String upload(String suffix, String FileName, String data, Boolean insert) throws RuntimeException {
        String fileName;
        try
        {
            //Base64解码
            byte[] b = Base64Utils.decodeFromString(data);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            if(!insert){
                fileName = FileName;
                File oldFile = new File(ConstantsW.getCurrenPath()+fileName);
                if(oldFile.exists()){
                    oldFile.delete();
                }
                fileName =  FileName.split("\\.")[0] + suffix;
            }else{
                fileName = UUID.randomUUID().toString() + suffix;
            }
            String imgFilePath = ConstantsW.getCurrenPath()+fileName;
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return fileName;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public String staticImage(String suffix, String data) throws RuntimeException {
        String fileName;
        try
        {
            //Base64解码
            byte[] b = Base64Utils.decodeFromString(data);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {
                    //调整异常数据
                    b[i]+=256;
                }
            }

            fileName = UUID.randomUUID().toString() + suffix;
            String imgFilePath = ConstantsS.getCurrenPath()+fileName;
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return fileName;
        }
        catch (Exception e)
        {
            return null;
        }
    }
//    @Override
//    public Boolean upload(Long workId, MultipartFile file){
//        if(file!=null) {
//            Work work;
//
//            if (workMapper.selectByPrimaryKey(workId)!=null) {
//                work = workMapper.selectByPrimaryKey(workId);
//                // 原始文件名
//                String originalFileName = file.getOriginalFilename();
//                // 获取图片后缀
//                String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
//                // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
//
//                String fileName;
//
//                if (work.getShowPic() != null) {
//                    File oldFile = new File(ConstantsT.getCurrenPath() +work.getShowPic());
//                    if (oldFile.exists()){
//                        oldFile.delete();
//                    }
//                    fileName = work.getShowPic().split("\\.")[0] + suffix;
//                } else {
//                    fileName = UUID.randomUUID().toString() + suffix;
//                }
//                // 图片存储路径
//                String filePath = ConstantsW.getCurrenPath() + fileName;
//                File saveFile = new File(filePath);
//                try {
//                    file.transferTo(saveFile);
//                    work.setShowPic(fileName);
//                } catch (IOException e) {
//                    throw new RuntimeException(e.getMessage());
//                }
//                return workMapper.updateByPrimaryKeySelective(work) > 0;
//            } else {
//                return false;
//            }
//        }else {
//            throw new RuntimeException("该作品不存在");
//        }
//    }


    @Override
    public String base64Data(Long workId){
        Work work = workMapper.selectByPrimaryKey(workId);
        if(work.getShowPic()==null){
            return null;
        }
        InputStream inputStream = null;
        byte[] data = null;
        String imgFile = ConstantsW.getCurrenPath() + work.getShowPic();
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        String Data = "data:image/png;base64," + encoder.encode(data);
        return Data;
    }
//    @Override
//    public int workCheckNoPass(Long workId) throws RuntimeException{
//        try{
//            if (workMapper.selectByPrimaryKey(workId)!=null){
//
//            }
//            else {
//                return 0;
//            }
//        }catch (Exception e){
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
}
