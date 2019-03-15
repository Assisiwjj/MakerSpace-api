package com.makerspace.demo.team.web;

import com.makerspace.demo.team.domain.TeamCheck;
import com.makerspace.demo.team.service.TeamCheckService;
import com.makerspace.demo.utils.PageBean;
import com.makerspace.demo.work.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@RestController
@RequestMapping("/check/team")
public class TeamCheckController extends BaseController {
    @Autowired
    private TeamCheckService teamCheckService;


//    @RequestMapping(value = "/regist",method = RequestMethod.POST)
//    public Map<String, Object> regist(@RequestBody TeamCheck teamCheck){
//        msg.clear();
//        try{
//            if (teamCheck.getTeamName()!=null && teamCheck.getName()!=null && teamCheck.getAffiliationCollege()!=null
//                    && teamCheck.getManager()!=null && teamCheck.getmTelephone()!=null && teamCheck.getPurpose()!=null
//
//                    ){
//                int i = teamCheckService.regist(teamCheck);
//                if (i==1) {
//                    msg.put("code", "1");
//                    msg.put("msg", "成功");
//                }else{
//                    msg.put("code", "0");
//                    msg.put("msg", "失败");
//                }
//            }else {
//                msg.put("code", "2");
//                msg.put("msg", "请传输完整参数或正确参数");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }


//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public Map<String, Object>getAll(HttpServletRequest request){
//        msg.clear();
//        try{
//            Integer limit = Integer.parseInt(request.getParameter("limit"));
//            Integer page = Integer.parseInt(request.getParameter("page"));
//            PageBean pageBean =teamCheckService.getPageBean(limit, page);
//            msg.put("code","1");
//            msg.put("msg","成功");
//            msg.put("data",pageBean);
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }

//    @RequestMapping(value = "/delete/{teamId}",method = RequestMethod.DELETE)
//    public Map<String, Object>getAll(@PathVariable("teamId") Long teamId){
//        try{
//            if (teamId!=null && teamId>0) {
//                if (teamCheckService.deleteNoPass(teamId) == 1) {
//                    msg.put("code", "1");
//                    msg.put("msg", "成功");
//                }else {
//                    msg.put("code", "0");
//                    msg.put("msg", "失败");
//            }
//            }else{
//                msg.put("code","0");
//                msg.put("msg","团队号错误");
//            }
//        }catch (Exception e){
//            msg.put("code","0");
//            msg.put("msg",e.getMessage());
//        }
//        return msg;
//    }
}
