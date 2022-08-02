package com.aphea.cqqksrv;

import com.aphea.cqqksrv.dao.CarInfoDao;
import com.aphea.cqqksrv.dao.TUserDao;
import com.aphea.cqqksrv.dao.TUserRoleDao;
import com.aphea.cqqksrv.entity.vo.CarInfoVO;
import com.aphea.cqqksrv.entity.vo.NodeVO;
import com.aphea.cqqksrv.entity.vo.OrgVO;
import com.aphea.cqqksrv.entity.vo.UserVO;
import com.aphea.cqqksrv.service.TNodeService;
import com.aphea.cqqksrv.service.TOrgService;
import com.aphea.cqqksrv.service.TUserRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootTest
class CqqkSrvApplicationTests {

    @Autowired
    private TUserRoleService tUserRoleService;

    @Autowired
    private TUserDao tUserDao;

    @Autowired
    private TOrgService tOrgService;

    @Autowired
    private TNodeService tNodeService;

    @Autowired
    private CarInfoDao carInfoDao;

    @Test
    void contextLoads() {

        // Map<String, String> userRoleMap = tUserRoleService.getUserRoleMap();
        // System.out.println(userRoleMap);
    }

    @Test
    void test01() throws InterruptedException {
        Random random = new Random();
        while(true) {
            int i = random.nextInt(100000);
            String s = String.valueOf(i);
            Thread.sleep(10);
        }
    }

    @Test
    void test02() {

        UserVO userByUserTel = tUserDao.getUserByUserTel("13896543186");
        System.out.println(userByUserTel);
    }

    @Test
    void test03() {

        List<OrgVO> orgList = tOrgService.getOrgList();
        for (OrgVO orgVO : orgList) {
            System.out.println(orgVO);
        }
    }

    @Test
    void test04() {

        OrgVO orgTree = tOrgService.getOrgTree();
        System.out.println(orgTree);
    }

    @Test
    void test05() {

        // List<CarInfoVO> carInfoVOList = carInfoDao.selectListPage(1, 10);
        // for (CarInfoVO carInfoVO : carInfoVOList) {
        //     System.out.println(carInfoVO);
        // }
    }
}
