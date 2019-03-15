package com.makerspace.demo.work.web;

import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.utils.PageBean;
import com.makerspace.demo.work.dao.WorkMapper;
import com.makerspace.demo.work.domain.Work;
import com.makerspace.demo.work.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/work")
public class WorkController extends BaseController{
    @Autowired
    private WorkService workService;

    @Autowired
    private WorkMapper workMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object>getAllWork(HttpServletRequest request){
        msg.clear();
        try{
            Integer limit = Integer.parseInt(request.getParameter("limit"));
            Integer page = Integer.parseInt(request.getParameter("page"));
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String teamName = request.getParameter("teamName");
            PageBean pageBean =workService.getPageBean(limit, page, type, name, teamName);
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",pageBean);
        }
        catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/list/{workId}", method = RequestMethod.GET)
    public Map<String, Object>getWorkByWorkId(@PathVariable("workId") Long workId){
        msg.clear();
        try{
            Work work = workService.selectByWorkId(workId);
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",work);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/list/team/{teamId}", method = RequestMethod.GET)
    public Map<String, Object>getWorkByAffiliateTeam(@PathVariable("teamId")Long teamId, HttpServletRequest request){
        msg.clear();
        try{
            if (teamId!=null) {
                List<Work> list = workService.selectByTeam(teamId);
                msg.put("code", "1");
                msg.put("msg", "成功");
                msg.put("data", list);
            }else {
                msg.put("code", "0");
                msg.put("msg", "失败");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/list/recent", method = RequestMethod.GET)
    public Map<String, Object>getWorkByTime(HttpServletRequest request){
        msg.clear();
        try{
            List<Work> list= workService.selectByTime();
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",list);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/list/popular", method = RequestMethod.GET)
    public Map<String, Object>getWorkByHits(HttpServletRequest request){
        msg.clear();
        try{
            List<Work> list= workService.selectByHits();
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",list);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Map<String, Object>getRecords(){
        msg.clear();
        try{
            List list= workMapper.countByTechnology();
            List list2= workMapper.countByIndustry();
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("technology",list);
            msg.put("industry",list2);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

//    @RequestMapping(value = "/delete/{workId}",method = RequestMethod.DELETE)
//    public Map<String, Object>deleteWork(@PathVariable("workId") Long workId){
//        msg.clear();
//        try{
//            if (workId!=null){
//                if (workService.workDelete(workId)==1){
//                    msg.put("code","1");
//                    msg.put("msg","成功");
//                }else {
//                    msg.put("code","0");
//                    msg.put("msg","失败");
//                }
//            }else {
//                msg.put("code","2");
//                msg.put("msg","请输入作品ID");
//            }
//
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg", e.getMessage());
//        }
//        return msg;
//    }

//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public Map<String, Object> updateWork(HttpServletRequest request, @RequestBody Work work){
//        msg.clear();
//        try{
//            Long workId = Long.parseLong(request.getParameter("pkId"));
//            if (workId!=null){
//                work.setPkId(workId);
//                Work findWork = workService.updateWork(work);
//                msg.put("code", "1");
//                msg.put("msg","成功");
//                msg.put("data", findWork);}
//            else {
//                msg.put("code", "1111");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }

//    @RequestMapping(value = "/check/list", method = RequestMethod.GET)
//    public Map<String, Object> nocheckWork(HttpServletRequest request){
//        msg.clear();
//        try{
//            Integer limit = Integer.parseInt(request.getParameter("limit"));
//            Integer page = Integer.parseInt(request.getParameter("page"));
//            PageBean pageBean =workService.getPageBeanCheck(limit, page);
//            msg.put("code", "1");
//            msg.put("msg","成功");
//            msg.put("data", pageBean);
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }

//    @RequestMapping(value = "/check/{workId}", method = RequestMethod.PATCH)
//    public Map<String, Object> checkPass(@PathVariable("workId") Long workId, HttpServletRequest request){
//        msg.clear();
//        try{
//            Long passCode = Long.parseLong(request.getParameter("passCode"));
//            workService.workCheck(workId, passCode);
//            msg.put("code", "1");
//            msg.put("msg","成功");
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }

//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public Map<String, Object> inserWork(@RequestBody Work work){
//        msg.clear();
//        try{
//            if (work.getName()!=null && work.getType()!=null && work.getAffiliateTeam()!=null ){
//                workService.insert(work);
//                msg.put("code", "1");
//                msg.put("msg","成功");
//            }else {
//                msg.put("code", "0");
//                msg.put("msg", "请传入必须参数");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
//
//    @RequestMapping(value = "/image",method = RequestMethod.POST)
//    public Map<String, Object> imageUpload (HttpServletRequest request,@RequestParam("image")MultipartFile file){
//        msg.clear();
//        try {
//            Long workId=Long.parseLong(request.getParameter("workId"));
//            if(workService.upload(workId,file)){
//                msg.put("code","1");
//                msg.put("msg","上传成功");
//            }else{
//                msg.put("code","0");
//                msg.put("msg","上传失败");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
//    @RequestMapping(value = "/check/nopass/{workId}", method = RequestMethod.PATCH)
//    public Map<String, Object> checkNoPass(@PathVariable("workId") Long workId){
//        msg.clear();
//        try{
//            workService.workCheckNoPass(workId);
//            msg.put("code", "1");
//            msg.put("msg","成功");
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
}
