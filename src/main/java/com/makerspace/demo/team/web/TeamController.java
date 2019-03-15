package com.makerspace.demo.team.web;

import com.makerspace.demo.team.dao.TeamMapper;
import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.team.domain.TeamCheck;
import com.makerspace.demo.team.service.TeamCheckService;
import com.makerspace.demo.team.service.TeamService;
import com.makerspace.demo.utils.PageBean;
import com.makerspace.demo.utils.SHA2;
import com.makerspace.demo.work.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.SHA;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController extends BaseController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamCheckService teamCheckService;

    @Autowired
    private TeamMapper teamMapper;

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public Map<String, Object> regist(@RequestBody TeamCheck teamCheck){
        msg.clear();
        try{
            if (teamCheck.getTeamName()!=null && teamCheck.getName()!=null && teamCheck.getAffiliationCollege()!=null
                    && teamCheck.getManager()!=null && teamCheck.getmTelephone()!=null && teamCheck.getPurpose()!=null){
                if (teamService.selectTeamByName(teamCheck.getName())==null) {
                    if (teamCheckService.regist(teamCheck) == 1) {
                        msg.put("code", "1");
                        msg.put("msg", "成功");
                    } else {
                        msg.put("code", "0");
                        msg.put("msg", "失败");
                    }
                }else {
                    msg.put("code", "0");
                    msg.put("msg", "该邮箱已被注册");
                }
            }else {
                msg.put("code", "2");
                msg.put("msg", "请传输完整参数或正确参数");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String, Object>getAllTeam(HttpServletRequest request){
        msg.clear();
        try{
            Integer limit = Integer.parseInt(request.getParameter("limit"));
            Integer page = Integer.parseInt(request.getParameter("page"));
            PageBean pageBean =teamService.getPageBean(limit, page);
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",pageBean);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


    @RequestMapping(value = "/list/{teamId}",method = RequestMethod.GET)
    public Map<String, Object>getTeamByTeamId(@PathVariable("teamId") Long teamId){
        msg.clear();
        try{
            Team team = teamService.selectByTeamId(teamId);
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("data",team);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


    @RequestMapping(value = "/getName/{teamId}",method = RequestMethod.GET)
    public Map<String, Object>getNameByTeamId(@PathVariable("teamId") Long teamId){
        msg.clear();
        try{
            String teamName = teamMapper.selectTNameByTeamId(teamId);
            msg.put("code","1");
            msg.put("msg","成功");
            msg.put("teamName",teamName);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public Map<String, Object> createTeam(@RequestBody Team team){
//        msg.clear();
//        try{
//            if (team.getTeamName()!=null && team.getName()!=null && team.getAffiliationCollege()!=null
//                    && team.getManager()!=null && team.getmTelephone()!=null
//                    ){
//                String str = teamService.insert(team);
//
////                if (i==1) {
//                    msg.put("password",str);
//                    msg.put("code", "1");
//                    msg.put("msg", "成功");
////                }else{
////                    msg.put("code", "0");
////                    msg.put("msg", "失败");
////                }
//            }else {
//                msg.put("code", "2");
//                msg.put("msg", "请传输完整参数");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }

//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public Map<String, Object> updateTeam(HttpServletRequest request, @RequestBody Team team){
//        msg.clear();
//        try{
//            if(team.getAffiliationCollege()!=null && team.getTeamName()!=null
//                    && team.getManager()!=null && team.getmTelephone() !=null){
//                Long teamId = Long.parseLong(request.getParameter("pkId"));
//                if (teamId!=null){
//                    team.setPkId(teamId);
//                    Team findTeam = teamService.updateTeam(team);
//                    msg.put("code", "1");
//                    msg.put("msg","成功");
//                    msg.put("data", findTeam);
//                } else {
//                    msg.put("code", "0");
//                    msg.put("msg", "失败");
//                }
//            }else {
//                msg.put("code", "0");
//                msg.put("msg", "错误的参数");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
//
//    @RequestMapping(value = "/delete/{teamId}", method = RequestMethod.DELETE)
//    public Map<String, Object> deleteTeam(@PathVariable("teamId") Long teamId){
//        msg.clear();
//        try{
//            if (teamId!=null){
//                if (teamService.deleteTeam(teamId)==1){
//                    msg.put("code", "1");
//                    msg.put("msg","成功");
//                }else {
//                    msg.put("code","0");
//                    msg.put("msg","失败");
//                }
//            } else {
//                msg.put("code","2");
//                msg.put("msg","请输入团队ID");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }


//    @RequestMapping(value = "repassword",method = RequestMethod.PATCH)
//    public Map<String, Object> RestPassword (@RequestBody Team team){
//        msg.clear();
//        try{
//            Team findTeam = teamService.selectTeamByName(team.getName());
//            String password = SHA2.SHA256(findTeam.getPkId() + team.getPassword());
//            findTeam.setPassword(password);
//            if(teamService.updateTeam(findTeam)!=null){
//                msg.put("code","1");
//                msg.put("msg","修改成功");
//            }else{
//                msg.put("code","0");
//                msg.put("msg","修改失败");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
//
//    @RequestMapping(value = "{teamId}/rename",method = RequestMethod.PATCH)
//    public Map<String, Object> RestName (@PathVariable("teamId") Long teamId, HttpServletRequest request){
//        msg.clear();
//        try{
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
//
//    @RequestMapping(value = "/image",method = RequestMethod.POST)
//    public Map<String, Object> imageUpload (HttpServletRequest request,@RequestParam("image")MultipartFile file){
//        msg.clear();
//        try {
//            Long teamId=Long.parseLong(request.getParameter("teamId"));
//            if(teamService.upload(teamId,file)){
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
}
