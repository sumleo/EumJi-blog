package com.eumji.zblog.controller.admin;

import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.util.ResultInfoFactory;
import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Partner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.net.URLDecoder;

/**
 * FILE: com.eumji.zblog.controller.admin.PartnerController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/14
 * TIME: 22:28
 */
@RestController
@RequestMapping("/admin/partner")
public class AdminPartnerController {
    @Resource
    private PartnerService partnerService;

    @RequestMapping("/initPage")
    public Pager initPage(Pager pager){
        partnerService.initPage(pager);
        return pager;
    }

    @RequestMapping("/save")
    public ResultInfo savePartner(Partner partner){
        try {
            partner.setSiteName(URLDecoder.decode(partner.getSiteName(), "utf-8"));
            partner.setSiteDesc(URLDecoder.decode(partner.getSiteDesc(), "utf-8"));
            partner.setSiteUrl(URLDecoder.decode(partner.getSiteUrl(), "utf-8"));
            partnerService.savePartner(partner);
        }catch (Exception e){
            return ResultInfoFactory.getErrorResultInfo();
        }
       return ResultInfoFactory.getSuccessResultInfo();

    }

    @RequestMapping("/update")
    public ResultInfo updatePartner(Partner partner) {
        try {
            partner.setSiteName(URLDecoder.decode(partner.getSiteName(), "utf-8"));
            partner.setSiteDesc(URLDecoder.decode(partner.getSiteDesc(), "utf-8"));
            partner.setSiteUrl(URLDecoder.decode(partner.getSiteUrl(), "utf-8"));
            if (partner.getSort()==null){
                partner.setSort(0);
            }
            partnerService.updatePartner(partner);
        } catch (Exception e) {
            return ResultInfoFactory.getErrorResultInfo();
        }
       return ResultInfoFactory.getSuccessResultInfo();

    }
    @RequestMapping("/delete")
    public ResultInfo deletePartner(Integer id){
        try {
            partnerService.deletePartner(id);
        }catch (Exception e){
            return ResultInfoFactory.getErrorResultInfo();
        }
        return ResultInfoFactory.getSuccessResultInfo();
    }
}
