package com.novsky.controller.common;


import com.novsky.domain.locations.Locations;
import com.novsky.domain.locations.Vlocations;
import com.novsky.domain.person.Person;
import com.novsky.domain.user.User;
import com.novsky.object.ListObject;
import com.novsky.service.commonData.CommonDataService;
import com.novsky.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by huangbin on 2015/12/23 0023.
 * 创建通用数据的控制器 自动选择数据加载方式
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/commonData")
public class CommonDataController extends BaseController {
    @Autowired
    CommonDataService commonDataService;
    /**
     * @param httpSession 当前会话
     * @return
     */
    @RequestMapping(value = "/findMyLocation", method = RequestMethod.GET)
    @ResponseBody
    public List<Locations> findMyLocation(HttpSession httpSession) {
        String location = SessionUtil.getCurrentUserLocationBySession(httpSession);
        List<Locations> locationList = null;
        if (location != null && !location.equals("")) {
            locationList = commonDataService.findMyLocation(location, httpSession);
        }
        return locationList;
    }


    /**
     * @param httpSession 当前会话
     * @return
     */
    @RequestMapping(value = "/findMyLoc", method = RequestMethod.GET)
    @ResponseBody
    public List<Vlocations> findMyLoc(HttpSession httpSession) {
        String location = SessionUtil.getCurrentUserLocationBySession(httpSession);
        List<Vlocations> locationList = null;
        if (location != null && !location.equals("")) {
            locationList = commonDataService.findMyVLocation(location, httpSession);
        }
        return locationList;
    }


    /**
     * @param httpSession 当前会话
     * @return 获得设备状态
     */
    @RequestMapping(value = "/getEqStatus", method = RequestMethod.GET)
    @ResponseBody
    public List<ListObject> getEqStatus(HttpSession httpSession) {
        return commonDataService.getEqStatus(httpSession);
    }

    /**
     * @param httpSession 当前会话
     * @return 获得设备状态
     */
    @RequestMapping(value = "/getEqRunStatus", method = RequestMethod.GET)
    @ResponseBody
    public List<ListObject> getEqRunStatus(HttpSession httpSession) {

        return commonDataService.getRunningStatus(httpSession);
    }


    /**
     * @param httpSession 当前会话
     * @return 获得设备状态
     */
    @RequestMapping(value = "/findActivePerson", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> findActivePerson(HttpSession httpSession) {
        return commonDataService.findActivePerson(httpSession);
    }



    /**
     * @return 获得服务器时间
     */
    @RequestMapping(value = "/getServerDate", method = RequestMethod.GET)
    @ResponseBody
    public String getServerDate() {
        return commonDataService.getServerDate();
    }

    /**
     * @param session 会话
     * @return 重载session值
     */
    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    @ResponseBody
    public Boolean reload(HttpSession session) {
        boolean result = false;
        User user = (User) session.getAttribute("currentUser");

        if (user != null) {
            result = commonDataService.reload(user, session);
        }
        return result;
    }

}

