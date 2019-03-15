package com.makerspace.demo.team.web;

import com.makerspace.demo.team.dao.TeamMapper;
import com.makerspace.demo.team.domain.Team;
import com.makerspace.demo.team.domain.TeamPermissions;
import com.makerspace.demo.team.service.TeamPermissionsService;
import com.makerspace.demo.team.service.TeamService;
import com.makerspace.demo.utils.JwtUtil;
import com.makerspace.demo.utils.SHA2;
import com.makerspace.demo.utils.Test;
import com.makerspace.demo.work.web.BaseController;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamPermissionsService teamPermissionsService;

    @Autowired
    private TeamMapper teamMapper;
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> Login(@RequestBody Team requestTeam){
        msg.clear();
        try{
            if (requestTeam.getName()!=null && requestTeam.getPassword()!=null){
                Team team = new Team();
                team.setName(requestTeam.getName());
                team.setPassword(requestTeam.getPassword());
                JwtUtil jwtUtil =new JwtUtil();
                Team team1 = teamService.login(team);
                TeamPermissions teamPermissions =teamPermissionsService.selectPermissions(team1.getPkId());
                String token = jwtUtil.createJWT(team1.getPkId().toString(), team1.getName(), 1000*60*60*24*15);
                msg.put("code", "1");
                msg.put("msg", "成功");
                msg.put("token", token);
                msg.put("teamId",team1.getPkId());
                msg.put("teamName",team1.getTeamName());
                msg.put("permissionsCode",teamPermissions.getPermissionsId());
            }else {
                msg.put("code", "2");
                msg.put("msg", "用户名或密码不能为空");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
            msg.remove("token");
        }
        return msg;
    }

    @RequestMapping(value = "repeat", method = RequestMethod.GET)
    public Map<String, Object> checkRepeat(HttpServletRequest request){
        String name = request.getParameter("name");
        msg.clear();
        try{
            if (name!=null){
                if (teamService.selectRepeat(name)==1){
                    msg.put("code", "1");
                    msg.put("msg","该邮箱未使用");
                }else {
                    msg.put("code", "0");
                    msg.put("msg","该邮箱已存在");
                }
            } else {
                msg.put("code","2");
                msg.put("msg","请输入团队ID");
            }
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }


    @RequestMapping(value = "forget", method = RequestMethod.GET)
    public Map<String, Object> forgetPwd(HttpServletRequest request){
        String email = request.getParameter("email");
        msg.clear();
        if (email!=null){
            Team team = teamService.selectTeamByName(email);
            if (team!=null){
                //不等完成返回发送成功
                teamService.sendRePasswordEmail(team.getTeamName(), email ,request);
//                if (teamService.sendRePasswordEmail(team.getTeamName(), email ,request)) {
                msg.put("code", "1");
                msg.put("msg", "成功发送邮件");
//                }else {
//                    msg.put("code", "0");
//                    msg.put("msg", "失败");
//                }
            }else {
                msg.put("code","0");
                msg.put("msg","该邮箱不存在");
            }
        }else {
            msg.put("code","0");
            msg.put("msg","请输入完整参数");
        }
        return msg;
    }

    @RequestMapping(value = "forget/repassword", method = RequestMethod.GET)
    public Map<String, Object> forget(HttpServletRequest request,@RequestParam("code") String code,
                                      @RequestParam("password") String pwd,
                                      @RequestParam("email") String email){
        msg.clear();
        if (code!=null && pwd!=null && email!=null) {
            if (teamService.selectTeamByName(email)!=null) {
                int i=teamService.cmpCode(code, request);
                if ( i== 3) {
                    msg.put("code","0");
                    msg.put("msg","验证码已失效");
                }else {
                    if (i == 2) {
                        msg.put("code","0");
                        msg.put("msg","验证码不正确");
                    }else {
                        if (i ==1) {
                            Team findTeam = teamService.selectTeamByName(email);
                            String password = SHA2.SHA256(findTeam.getPkId() + pwd);
                            findTeam.setPassword(password);
                            if (teamService.updatePassword(findTeam) != null) {
                                msg.put("code", "1");
                                msg.put("msg", "修改成功");
                            } else {
                                msg.put("code", "0");
                                msg.put("msg", "修改失败");
                            }
                        }
                    }
                }
            }else {
                msg.put("code","0");
                msg.put("msg","该团队不存在");
            }
        }else {
            msg.put("code","0");
            msg.put("msg","错误的参数请求");
            }
        return msg;
    }

//    Team findTeam = teamService.selectTeamByName(email);
//            String password = SHA2.SHA256(findTeam.getPkId() + pwd);
//            findTeam.setPassword(password);
//            if (teamService.updatePassword(findTeam) != null) {
//                msg.put("code", "1");
//                msg.put("msg", "修改成功");
//            } else {
//                msg.put("code", "0");
//                msg.put("msg", "修改失败");
}
