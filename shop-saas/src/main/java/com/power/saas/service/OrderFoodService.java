package com.power.saas.service;

import com.power.saas.common.ID;
import com.power.saas.entity.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
    @Autowired
    private OrderService orderService;


    @Transactional
    public void submitOrder(Long deskId, Long vipId, String note, String item, String num) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONArray jsonArray = JSONArray.fromObject(item);

        if (null != deskId) {
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
            if (vipId != null) {
                vipInfo = vipInfoService.selectByPrimaryKey(vipId);
                deskStatus.setVipName(vipInfo.getName());
                deskStatus.setTel(vipInfo.getTel());
            }
            deskStatusService.updateByPrimaryKeySelective(deskStatus);
            //保存订单
            Bill bill = new Bill();
            Long billId = ID.getNonaSec();
            bill.setId(billId);
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
            for (Object ob : jsonArray) {
                JSONObject o = (JSONObject) ob;
                BillMenu billMenu = new BillMenu();
                billMenu.setId(ID.getNonaSec());
                billMenu.setBillNo(billNo.toString());
                billMenu.setMenuCode(o.getString("code"));
                billMenu.setMenuTypeCode(o.getString("typeName"));
                billMenu.setTime(date);
                billMenu.setNum(Integer.parseInt(num));
                billMenu.setIsSettled(0);
                billMenu.setNote(note);
                billMenuService.insert(billMenu);
            }
            //
            deskInfo.setBillId(billId);
            deskInfoService.updateByPrimaryKeySelective(deskInfo);
        }

    }

    public void settled(Long deskInfoId, Double amount,Double amt,String billNo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BillMenu billMenuKey = new BillMenu();
        billMenuKey.setBillNo(billNo);
        List<BillMenu> billMenuList = billMenuService.queryByList(billMenuKey);
        //结算
        for (BillMenu menu : billMenuList){
            menu.setIsSettled(1);
            billMenuService.updateByPrimaryKeySelective(menu);
        }
        //更新桌台状态
        DeskInfo deskInfo = deskInfoService.selectByPrimaryKey(deskInfoId);
        Long deskStatusId = deskInfo.getStatusId();
        DeskStatus deskStatus = new DeskStatus();
        deskStatus.setId(deskStatusId);
        deskStatus.setStatus("无人用餐");
        deskStatus.setNote("");
        deskStatus.setTime(null);
        deskStatus.setPersonNum(0);
        deskStatus.setVipName("");
        deskStatus.setTel("");
        deskStatusService.updateByPrimaryKey(deskStatus);
        //销售记录
        Order order = new Order();
        order.setId(ID.getNonaSec());
        order.setTime(simpleDateFormat.format(new Date()));
        order.setReceivable(amt);
        order.setActualReceipt(amount);
        orderService.insert(order);
    }
}
