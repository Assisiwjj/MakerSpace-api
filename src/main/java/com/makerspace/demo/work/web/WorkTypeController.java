package com.makerspace.demo.work.web;

import com.makerspace.demo.utils.PageBean;
import com.makerspace.demo.work.domain.WorkType;
import com.makerspace.demo.work.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class WorkTypeController extends BaseController{
    @Autowired
    private WorkTypeService workTypeService;

    @RequestMapping( method = RequestMethod.GET)
    public Map<String, Object>typeList() {
        msg.clear();
        try{
            List<WorkType> list = workTypeService.selectAllType();
            msg.put("code", "1");
            msg.put("msg","成功");
            msg.put("data", list);
        }catch (Exception e){
            msg.put("code","0");
            msg.put("msg",e.getMessage());
        }
        return msg;
    }

}
