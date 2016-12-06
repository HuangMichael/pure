package com.novsky.controller.portal;


import com.novsky.controller.common.BaseController;
import com.novsky.service.portal.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by huangbin on 2015/12/23 0023.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/portal")
@SessionAttributes("menuList")
public class PortalController extends BaseController {


    @Autowired
    PortalService portalService;


    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap) {

        return "/portal/index";
    }


}

