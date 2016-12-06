package com.novsky.service.org;

import com.novsky.dao.app.org.OrgRepository;
import com.novsky.domain.app.org.SystemInfo;
import com.novsky.service.app.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangbin
 * 2016年9月29日10:03:31
 * <p/>
 * 物料消耗查询业务类
 */
@Service
public class SysInfoService extends BaseService {

    @Autowired
    public OrgRepository orgRepository;



    /**
     * @param sysName 系统参数名称
     * @return
     */
    public SystemInfo findBySysName(String sysName) {
        List<SystemInfo> systemInfoList = orgRepository.findBySysName(sysName);
        return (systemInfoList != null) ? systemInfoList.get(0) : null;
    }
}
