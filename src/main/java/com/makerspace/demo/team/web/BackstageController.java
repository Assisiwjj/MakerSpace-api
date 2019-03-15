package com.makerspace.demo.team.web;

import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.team.service.TeamCheckService;
import com.makerspace.demo.team.service.TeamPermissionsService;
import com.makerspace.demo.team.service.TeamService;
import com.makerspace.demo.utils.PageBean;
import com.makerspace.demo.utils.SHA2;
import com.makerspace.demo.work.dao.WorkMapper;
import com.makerspace.demo.work.domain.Work;
import com.makerspace.demo.work.service.WorkService;
import com.makerspace.demo.work.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/backstage")
public class BackstageController extends BaseController {
    @Autowired
    private WorkService workService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamCheckService teamCheckService;

    @Autowired
    private TeamPermissionsService teamPermissionsService;

    @Autowired
    private WorkMapper workMapper;

    @RequestMapping(value = "/team/check/list",method = RequestMethod.GET)
    public Map<String, Object> getAll(HttpServletRequest request){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (teamPermissionsService.judgment(teamId)==false){
                Integer limit = Integer.parseInt(request.getParameter("limit"));
                Integer page = Integer.parseInt(request.getParameter("page"));
                PageBean pageBean =teamCheckService.getPageBean(limit, page);
                msg.put("code","1");
                msg.put("msg","成功");
                msg.put("data",pageBean);
            }else{
                msg.put("code","0");
                msg.put("msg","你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/team/check", method = RequestMethod.POST)
    public Map<String, Object> createTeam(HttpServletRequest request, @RequestBody Team team){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (teamPermissionsService.judgment(teamId)==false){
                if (team.getTeamName()!=null && team.getName()!=null && team.getAffiliationCollege()!=null
                        && team.getManager()!=null && team.getmTelephone()!=null
                        ){
                    if (teamService.insert(team)){
                        msg.put("code", "1");
                        msg.put("msg", "成功");
                    }else {
                        msg.put("code", "0");
                        msg.put("msg", "失败");
                    }
                }else {
                    msg.put("code", "0");
                    msg.put("msg", "请传输完整参数");
                }
            }else {
                msg.put("code","0");
                msg.put("msg","你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/team/check/delete/{teamId}",method = RequestMethod.DELETE)
    public Map<String, Object>getAllDelete(HttpServletRequest request, @PathVariable("teamId") Long checkId){
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (teamPermissionsService.judgment(teamId)==false) {
                if (checkId != null && checkId > 0) {
                    if (teamCheckService.deleteNoPass(checkId) == 1) {
                        msg.put("code", "1");
                        msg.put("msg", "成功");
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "失败");
                    }
                } else {
                    msg.put("code", "0");
                    msg.put("msg", "团队号错误");
                }
            }else {
                msg.put("code","0");
                msg.put("msg","你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "work/check/list", method = RequestMethod.GET)
    public Map<String, Object> nocheckWork(HttpServletRequest request){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (teamPermissionsService.judgment(teamId)==false){
                Integer limit = Integer.parseInt(request.getParameter("limit"));
                Integer page = Integer.parseInt(request.getParameter("page"));
                PageBean pageBean =workService.getPageBeanCheck(limit, page);
                msg.put("code", "1");
                msg.put("msg","成功");
                msg.put("data", pageBean);
            }else {
                msg.put("code","0");
                msg.put("msg","你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "work/check/{workId}", method = RequestMethod.PATCH)
    public Map<String, Object> checkPass(@PathVariable("workId") Long workId, HttpServletRequest request){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (teamPermissionsService.judgment(teamId)==false){
                Long passCode = Long.parseLong(request.getParameter("passCode"));
                workService.workCheck(workId, passCode);
                msg.put("code", "1");
                msg.put("msg","成功");
            }
                else {
                msg.put("code","0");
                msg.put("msg","你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


    @RequestMapping(value = "team/update", method = RequestMethod.PUT)
    public Map<String, Object> updateTeam(HttpServletRequest request, @RequestBody Team team){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if(team.getAffiliationCollege()!=null && team.getTeamName()!=null
                    && team.getManager()!=null && team.getmTelephone() !=null){
                if (teamId!=null){
                    team.setPkId(teamId);
                    Team findTeam = teamService.updateTeam(team);
                    msg.put("code", "1");
                    msg.put("msg","成功");
                    msg.put("data", findTeam);
                } else {
                    msg.put("code", "0");
                    msg.put("msg", "失败");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "错误的参数");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "team/delete/{teamId}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteTeam(HttpServletRequest request,@PathVariable("teamId") Long checkId){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (teamPermissionsService.judgment(teamId)==false) {
                if (checkId != null) {
                    if (teamService.deleteTeam(checkId) == 1) {
                        msg.put("code", "1");
                        msg.put("msg", "成功");
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "失败");
                    }
                } else {
                    msg.put("code", "2");
                    msg.put("msg", "请输入团队ID");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


    @RequestMapping(value = "work/update/{workId}", method = RequestMethod.PUT)
    public Map<String, Object> updateWork(@PathVariable("workId")Long workId,
                                          HttpServletRequest request, @RequestBody Work work){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (workMapper.selectByteamId(teamId)!=null) {
                if (workId != null) {
                    work.setPkId(workId);
                    if (workService.updateWork(work) == 1) {
                        msg.put("code", "1");
                        msg.put("msg", "成功");
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "失败");
                    }
                } else {
                    msg.put("code", "0");
                    msg.put("msg", "作品不存在");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "work/insert", method = RequestMethod.POST)
    public Map<String, Object> inserWork(HttpServletRequest request, @RequestBody Work work){
        msg.clear();
        try{
            String dataPrix = "";
            String data = "";
            String base64Data = work.getShowPic();
            if(base64Data == null || "".equals(base64Data)){
                msg.put("code","0");
                msg.put("msg","上传失败，上传图片数据为空");
                return msg;
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                    work.setShowPic(null);
                }else{
                    msg.put("code","0");
                    msg.put("msg","上传失败，数据不合法");
                    return msg;
                }
            }

            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                msg.put("code","0");
                msg.put("msg","上传图片格式不合法");
                return msg;
            }



            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (work.getName()!=null && work.getTypeTechnology()!=null && work.getTypeIndustry()!=null && teamId!=null){
                if (workService.insert(work,teamId,suffix,data)==1) {
                    msg.put("code", "1");
                    msg.put("msg", "成功");
                }else {
                    msg.put("code", "0");
                    msg.put("msg", "失败");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "请传入必须参数");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "work/image",method = RequestMethod.POST)
    public Map<String, Object> imageUpload (HttpServletRequest request,@RequestBody Work work){
        msg.clear();
        try {
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());

            String dataPrix = "";
            String data = "";
            String base64Data = work.getShowPic();
            if(base64Data == null || "".equals(base64Data)){
                msg.put("code","0");
                msg.put("msg","上传失败，上传图片数据为空");
                return msg;
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                    work.setShowPic(null);
                }else{
                    msg.put("code","0");
                    msg.put("msg","上传失败，数据不合法");
                    return msg;
                }
            }

            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                msg.put("code","0");
                msg.put("msg","上传图片格式不合法");
                return msg;
            }

            if (workMapper.selectByteamId(teamId)!=null) {
                if (work!=null){
                    if (workService.updateImage(work.getPkId(),suffix,data)>0) {
                        msg.put("code", "1");
                        msg.put("msg", "上传成功");
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "上传失败");
                    }
                }else {
                    msg.put("code", "0");
                    msg.put("msg", "上传失败,图片为空");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "work/delete/{workId}",method = RequestMethod.DELETE)
    public Map<String, Object>deleteWork(HttpServletRequest request, @PathVariable("workId") Long workId){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (workMapper.selectByteamId(teamId)!=null || teamPermissionsService.judgment(teamId)==false) {
                if (workId != null) {
                    if (workService.workDelete(workId) == 1) {
                        msg.put("code", "1");
                        msg.put("msg", "成功");
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "失败");
                    }
                } else {
                    msg.put("code", "2");
                    msg.put("msg", "请输入作品ID");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg", e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "team/repassword",method = RequestMethod.PATCH)
    public Map<String, Object> RestPassword (HttpServletRequest request, @RequestBody Team team){
        msg.clear();
        try{
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
            if (workMapper.selectByteamId(teamId)!=null) {
                Team findTeam = teamService.selectTeamByName(team.getName());
                String password = SHA2.SHA256(findTeam.getPkId() + team.getPassword());
                findTeam.setPassword(password);
                if(teamService.updatePassword(findTeam)!=null){
                    msg.put("code","1");
                    msg.put("msg","修改成功");
                }else{
                    msg.put("code","0");
                    msg.put("msg","修改失败");
                }
            }else {
                msg.put("code","0");
                msg.put("msg","你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }



    @RequestMapping(value = "team/image",method = RequestMethod.POST)
    public Map<String, Object> imageUpload1 (HttpServletRequest request,@RequestParam("image")MultipartFile file){
        msg.clear();
        try {
            Long teamId=Long.parseLong(request.getAttribute("teamId").toString());
            if (file!=null){
                if(teamService.upload(teamId,file)){
                    msg.put("code","1");
                    msg.put("msg","上传成功");
                }else{
                    msg.put("code","0");
                    msg.put("msg","上传失败");
                }
            }else {
                msg.put("code","0");
                msg.put("msg","上传失败,图片为空");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


    @RequestMapping(value = "team/getImage",method = RequestMethod.GET)
    public Map<String, Object> getTeamImage (HttpServletRequest request) throws IOException {
        msg.clear();
        Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
        try{
            String data = teamService.base64Data(teamId);
            if(data!=null){
                msg.put("code","1");
                msg.put("msg","成功");
                msg.put("data",data);
            }else{
                msg.put("code","0");
                msg.put("msg","失败");
            }
        }catch (Exception e){
            throw new IOException(e.getMessage());
        }

        return msg;
    }

    @RequestMapping(value = "work/getImage/{workId}",method = RequestMethod.GET)
    public Map<String, Object> getWorkImage (HttpServletRequest request,
                                             @PathVariable("workId")Long workId) throws IOException {
        msg.clear();
        Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
        try{
            if(teamId!=null &&workMapper.selectByteamId(teamId)!=null){
                String data = workService.base64Data(workId);
                if(data!=null){
                    msg.put("code","1");
                    msg.put("msg","成功");
                    msg.put("data",data);
                }else{
                    msg.put("code","0");
                    msg.put("msg","失败");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "你没有权限");
            }
        }catch (Exception e){
            throw new IOException(e.getMessage());
        }


        return msg;
    }

    @RequestMapping(value = "work/upload",method = RequestMethod.POST)
    public Map<String, Object> staticImage (HttpServletRequest request,@RequestBody Map<String , Object> image){
        msg.clear();
        try {
            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());

            String dataPrix = "";
            String data = "";
            String base64Data = image.get("image").toString();
            if(base64Data == null || "".equals(base64Data)){
                msg.put("code","0");
                msg.put("msg","上传失败，上传图片数据为空");
                return msg;
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                }else{
                    msg.put("code","0");
                    msg.put("msg","上传失败，数据不合法");
                    return msg;
                }
            }

            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                msg.put("code","0");
                msg.put("msg","上传图片格式不合法");
                return msg;
            }

            if (workMapper.selectByteamId(teamId)!=null) {
                if (image!=null){
                    String fileName = workService.staticImage(suffix,data);
                    if (fileName!=null) {
                        msg.put("code", "1");
                        msg.put("msg", "上传成功");
                        msg.put("url", "http://210.32.98.136:8080/image/" + fileName);
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "上传失败");
                    }
                }else {
                    msg.put("code", "0");
                    msg.put("msg", "上传失败,图片为空");
                }
            }else {
                msg.put("code", "0");
                msg.put("msg", "你没有权限");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    //    @RequestMapping(value = "team/rename",method = RequestMethod.PATCH)
//    public Map<String, Object> RestName (HttpServletRequest request){
//        msg.clear();
//        try{
//            Long teamId = Long.parseLong(request.getAttribute("teamId").toString());
//            String newName = request.getParameter("newName");
//            if (newName!=null) {
//                if (teamService.selectRepeat(newName)==1){
//                    Team findTeam = teamService.selectByTeamId(teamId);
//                    findTeam.setTeamName(newName);
//                    if (teamService.updateTeam(findTeam) != null) {
//                        msg.put("code", "1");
//                        msg.put("msg", "修改成功");
//                    } else {
//                        msg.put("code", "0");
//                        msg.put("msg", "修改失败");
//                    }
//                }else {
//                    msg.put("code", "0");
//                    msg.put("msg", "该用户名已存在");
//                }
//            }else {
//                msg.put("code", "0");
//                msg.put("msg", "newName参数不正确");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
}
