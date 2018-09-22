package com.power.saas.service;

import com.power.saas.common.ID;
import com.power.saas.entity.*;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Yan on 2018/9/22.
 */
@Service
public class OrderFoodService {

    @Autowired
    private DeskInfoService deskInfoService;
    @Autowired
    private VipInfoService vipInfoService;

    @Autowired
    private DeskStatusService deskStatusService;

    @Autowired
    private BillService billService;
    @Autowired
    private BillMenuService billMenuService;

    @Transactional
    public void submitOrder(Long deskId,Long vipId,String note,String item,String num){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONArray jsonArray = JSONArray.fromObject(item);
        List<MenuInfo> menuInfoList = (List<MenuInfo>) jsonArray;

        if (null != deskId){
            String date = simpleDateFormat.format(new Date());
            DeskInfo deskInfo = deskInfoService.selectByPrimaryKey(deskId);
            Long deskStatusId = deskInfo.getStatusId();
            //更新桌台状态
            DeskStatus deskStatus = new DeskStatus();
            deskStatus.setId(deskStatusId);
            deskStatus.setStatus("正在用餐");
            deskStatus.setNote(note);
            deskStatus.setTime(date);
            deskStatus.setPersonNum(Integer.parseInt(num));
            VipInfo vipInfo = new VipInfo();
            if (vipId != null){
                vipInfo = vipInfoService.selectByPrimaryKey(vipId);
                deskStatus.setVipName(vipInfo.getName());
                deskStatus.setTel(vipInfo.getTel());
            }
            deskStatusService.updateByPrimaryKeySelective(deskStatus);
            //保存订单
            Bill bill = new Bill();
            bill.setId(ID.getNonaSec());
            Long billNo = ID.getNonaSec();
            bill.setBillNo(billNo.toString());
            bill.setDeskId(deskId);
            bill.setVipCode(vipInfo.getCode());
            bill.setPersonNum(Integer.parseInt(num));
            bill.setTime(date);
            bill.setNote(note);
            bill.setVipName(vipInfo.getName());
            billService.insert(bill);
            //订单明细
            for (MenuInfo menuInfo : menuInfoList){
                BillMenu billMenu = new BillMenu();
                billMenu.setId(ID.getNonaSec());
                billMenu.setBillNo(billNo.toString());
                billMenu.setMenuCode(menuInfo.getCode());
                billMenu.setMenuTypeCode(menuInfo.getTypeName());
                billMenu.setTime(date);
                billMenu.setNum(Integer.parseInt(num));
                billMenu.setIsSettled(0);
                billMenu.setNote(note);
                billMenuService.insert(billMenu);
            }
        }

    }
}
