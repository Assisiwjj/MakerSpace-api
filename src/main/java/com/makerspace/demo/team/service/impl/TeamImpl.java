package com.makerspace.demo.team.service.impl;

import com.makerspace.demo.team.dao.TeamCheckMapper;
import com.makerspace.demo.team.dao.TeamIntroductionMapper;
import com.makerspace.demo.team.dao.TeamMapper;
import com.makerspace.demo.team.domain.*;
import com.makerspace.demo.team.service.TeamIntroductionService;
import com.makerspace.demo.team.service.TeamPermissionsService;
import com.makerspace.demo.team.service.TeamService;
import com.makerspace.demo.utils.*;
import com.makerspace.demo.work.dao.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TeamImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private TeamCheckMapper teamCheckMapper;

    @Autowired
    private WorkMapper workMapper;

    @Autowired
    private TeamPermissionsService teamPermissionsService;

    @Autowired
    private TeamIntroductionService teamIntroductionService;

    @Autowired
    private TeamIntroductionMapper teamIntroductionMapper;

    @Override
    public PageBean getPageBean(Integer limit, Integer page) {
        try {
            TeamExample example = new TeamExample();
            TeamExample.Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(false);
            int count = (int) teamMapper.countByExample(example);
            if (count > 0) {
                PageBean pageBean = new PageBean(page, count, limit);
                example.setLimit(limit);
                example.setOffset(pageBean.getStart());
                List<Team> teamList = teamMapper.selectByExample(example);
                for(Team team : teamList){
                    if(team.getCoverPic()!=null){
                        team.setCoverPic((Base64.toBase64T(team.getCoverPic())));
                    }
                }
                pageBean.setList(teamList);
                return pageBean;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public Team selectByTeamId(Long teamId) throws RuntimeException {
        try {
            Team team = teamMapper.selectByTeamId(teamId);
            if (team != null) {
                if (team.getIsDelete()) {
                    return null;
                } else {
                    return team;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public Boolean insert(Team team) throws RuntimeException{
            team.setGmtCreate(new Date());
            team.setGmtModified(new Date());
            team.setIsDelete(false);
            teamMapper.insert(team);
            String pwd=RandomString.getRandomString(10);
//            String pwd = "123";
            team.setPassword(SHA2.SHA256(team.getPkId() + pwd));
            teamMapper.updateByPrimaryKeySelective(team);
            teamCheckMapper.deleteByIsCheck(team.getName());
            teamPermissionsService.insert(team.getPkId());
            teamIntroductionService.insertn();

            String msg = null;
            try {
                msg = "<p>尊敬的"+team.getTeamName()+"团队：</p>" +
                        "<p>您好!</p><p>您的团队已通过申请" + "您的初始密码是：</p>" +
                        "<p><font size=\"6\" color=\"#1E90FF\"  face=\"Microsoft YaHei\">"+ pwd + "</font></p>" +
                        "<p>请妥善保管您的账号和密码。</p>";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(EmailUtil.sendEmail(team.getName(),"申请通过",msg)==true) {
                return true;
            } else {
                return false;
            }
    }


    @Override
    public Team selectTeamByName(String name) {
        TeamExample example = new TeamExample();
        TeamExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Team> list = teamMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Team login(Team team) throws RuntimeException {
        try {
            Team findTeamByname = selectTeamByName(team.getName());
            if(findTeamByname!=null) {
                team.setPkId(findTeamByname.getPkId());
                team.setPassword(SHA2.SHA256(team.getPkId() + team.getPassword()));
                TeamExample example = new TeamExample();
                TeamExample.Criteria criteria = example.createCriteria();
                criteria.andNameEqualTo(team.getName());
                criteria.andPasswordEqualTo(team.getPassword());
                List<Team> list = teamMapper.selectByExample(example);
                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
                else {
                    throw new RuntimeException("用户名或密码错误");
                }
            }else {
                throw new RuntimeException("用户名或密码错误");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public Team updateTeam(Team team) throws RuntimeException {
        try {
                if(teamMapper.updateByPrimaryKeySelective(team)>0){
                teamMapper.updateByPrimaryKeySelective(team);
                workMapper.updateWorkTName(team.getPkId(),team.getTeamName());
                TeamIntroduction teamIntroduction = new TeamIntroduction();
                teamIntroduction.setIntroduction(team.getTeamIntroduction().getIntroduction());
                teamIntroduction.setPkId(team.getTeamIntroduction().getPkId());
                teamIntroductionMapper.updateByPrimaryKeySelective(teamIntroduction);
                return teamMapper.selectByPrimaryKey(team.getPkId());
            }else {
                    throw new RuntimeException("更新失败");
                }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int deleteTeam(Long teamId) throws RuntimeException {
        try {
            if (teamId != null) {
                if (teamMapper.selectByPrimaryKey(teamId) != null) {
                    Team team = new Team();
                    team.setPkId(teamId);
                    team.setIsDelete(true);
                    return teamMapper.updateByPrimaryKeySelective(team);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int selectRepeat(String name) throws RuntimeException{
        try {
            TeamExample example =new TeamExample();
            TeamExample.Criteria criteria = example.createCriteria();
            criteria.andNameEqualTo(name);
            TeamCheckExample example1 =new TeamCheckExample();
            TeamCheckExample.Criteria criteria1 = example1.createCriteria();
            criteria.andNameEqualTo(name);
            criteria1.andNameEqualTo(name);
            if (teamCheckMapper.selectByExample(example1).size()==0){
                if (teamMapper.selectByExample(example).size()==0){
                        return 1;
                }else {
                    throw new RuntimeException("该邮箱已存在");
                }
            }else {
                throw new RuntimeException("该邮箱已存在");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Boolean upload(Long teamId, MultipartFile file){
        if(file!=null) {
            Team team;

            if (teamMapper.selectByPrimaryKey(teamId)!=null) {
                team = teamMapper.selectByPrimaryKey(teamId);
                // 原始文件名
                String originalFileName = file.getOriginalFilename();
                // 获取图片后缀
                String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
                // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀

                String fileName;

                if (team.getCoverPic() != null) {
                    File oldFile = new File(ConstantsT.getCurrenPath() +team.getCoverPic());
                    if (oldFile.exists()){
                        oldFile.delete();
                    }
                    fileName = team.getCoverPic().split("\\.")[0] + suffix;
                } else {
                    fileName = UUID.randomUUID().toString() + suffix;
                }
                // 图片存储路径
                String filePath = ConstantsT.getCurrenPath() + fileName;
                File saveFile = new File(filePath);
                try {
                    file.transferTo(saveFile);
                    team.setCoverPic(fileName);
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
                return teamMapper.updateByPrimaryKeySelective(team) > 0;
            } else {
                return false;
            }
        }else {
            throw new RuntimeException("该团队不存在");
        }
    }

    @Override
    public Team updatePassword(Team team) throws RuntimeException {
        try {
            if(teamMapper.updateByPrimaryKeySelective(team)>0){
                teamMapper.updateByPrimaryKeySelective(team);
                return teamMapper.selectByPrimaryKey(team.getPkId());
            }else {
                throw new RuntimeException("更新失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public String base64Data(Long teamId){
        Team team = teamMapper.selectByPrimaryKey(teamId);
        if(team.getCoverPic()==null){
            return null;
        }
        InputStream inputStream = null;
        byte[] data = null;
        String imgFile = ConstantsT.getCurrenPath() + team.getCoverPic();
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


    @Override
    @Async
    public Boolean sendRePasswordEmail(String teamName , String email, HttpServletRequest request){
        //System.out.println("getVCode...service...");
        //随机生成5验证码
        Integer number =(int)((Math.random()*9+1)*10000);
        String checkCode = number.toString();
        //记录验证码和时间
        String checkCodeTime = TimeUtil.getTime();

        //存入session  验证码#时间
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5*60);
        session.setAttribute("checkCode", checkCode + "#" + checkCodeTime);
        System.out.println(session.getAttribute("checkCode"));
        System.out.println(session.getId());

        //邮件发送
        String msg = null;
        msg = "<p>尊敬的"+teamName+"团队：</p>" +
                "<p>您好!</p><p>您正在尝试重置密码！" + "您的密码重置验证码是：</p>" +
                "<p><font size=\"6\" color=\"#1E90FF\">"+ checkCode + "</font></p>" +
                "<p>该验证码5分钟内有效</p>" +
                "<p>请妥善保管您的账号和密码。</p>"+
                "<p>如非本人操作请忽视本邮件</p>";

        if(EmailUtil.sendEmail(email,"密码重置",msg)==true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int cmpCode(String Code,HttpServletRequest request){
            //System.out.println("cmpVCode...service...");
            try{
                HttpSession session = request.getSession();
                System.out.println(session.getId());
                String checkCode =  (String) session.getAttribute("checkCode");
                String vcodeTimeArray[] = checkCode.split("#");

                //先比较验证码是否正确
                if (TimeUtil.cmpTime(vcodeTimeArray[1])){
                    if(vcodeTimeArray[0].equals(Code)) {
                        session.removeAttribute("checkCode");
                        //验证码正确
                        return 1;
                    }else {
                        //验证码不正确
                        return 2;
                    }
                }else {
                    //验证码已失效
                    return 3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
}
