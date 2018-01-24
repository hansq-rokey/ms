package com.fengzhuo.tudou.ms.controller;

import cn.freesoft.utils.FsUtils;
import com.fengzhuo.tudou.ms.common.*;
import com.fengzhuo.tudou.ms.configUtil.Global;
import com.fengzhuo.tudou.ms.domain.*;
import com.fengzhuo.tudou.ms.persistence.SysConfigMapper;
import com.fengzhuo.tudou.ms.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tool.util.BeanUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * 获取模型分
 * Created by hanshuaiqi 14:04 2017/11/6
 */
@Controller
public class ModelScoreController {
    private static final Logger logger = LoggerFactory.getLogger(ModelScoreController.class);
    @Resource
    private StrategyService strategyService;
    @Resource
    private UserScoreStatisticsService userScoreStatisticsService;
    @Resource
    private SysConfigMapper sysConfigMapper;
    @Resource
    private OrgTeamService orgTeamService;
    @Resource
    private UserScoreStatisticsLogService userScoreStatisticsLogService;
    @Resource
    private SysConfigService sysConfigService;

    @RequestMapping(value = "/ms/model/score")
    @ResponseBody
    public Object getModelScore(@RequestParam(value = "name",required = true)String name,
                                @RequestParam(value = "phone",required = true)String phone,
                                @RequestParam(value = "idNo",required = true)String idNo,
                                @RequestParam(value = "zhimaScore",required = true)String zhimaScore,
                                @RequestParam(value = "borrowTimeScore",required = true)String borrowTimeScore,
                                @RequestParam(value = "overDay",required = true)Integer overDay,
                                @RequestParam(value = "teamNo",required = true)String teamNo,
                                @RequestParam(value = "mobileType",required = false)String mobileType,
                                @RequestParam(value = "blockBox",required = false)String blockBox,
                                HttpServletRequest request){
        if(StringUtil.isEmpty(name) || StringUtil.isEmpty(phone) || StringUtil.isEmpty(idNo) || StringUtil.isEmpty(teamNo)){
            return ResultUtil.genFailedResult(ErrorCode.FAIL,"name OR phone OR idno OR teamNo is null");
        }
        OrgTeam team = orgTeamService.getTeamByNo(teamNo);
        String ip = getIp(request);
        logger.info("ip:"+ip);
        String ips = team.getIps();
        boolean flag = false;
        if("0.0.0.0".equals(ips)){
            flag = true;
        }else{
            String[] ipStr = ips.split(",");
            flag = Arrays.asList(ipStr).contains(ip);
        }
        if(!flag){
            return ResultUtil.genFailedResult(ErrorCode.FAIL,"ip is error");
        }
        List<Strategy> strategies = strategyService.queryList();
        double totalScore = Double.parseDouble(GlobalConfig.rc_score);//风控基本分
        UserScoreStatistics userScore = new UserScoreStatistics();
        userScore.setBlackBox(blockBox);
        userScore.setBorrowTimesScore(BigDecimal.valueOf(Double.parseDouble(borrowTimeScore)));
        userScore.setCreateTime(new Date());
        userScore.setOverDay(overDay);
        userScore.setZhimaScore(BigDecimal.valueOf(Double.parseDouble(zhimaScore)));
        userScore.setIdNo(idNo);
        userScore.setUserName(name);
        userScore.setPhone(phone);
        userScore.setMobileType(mobileType);
        userScore.setTeamId(team.getId());
        StringBuffer buffer = new StringBuffer();
        buffer.append(totalScore);
        if(strategies!=null && strategies.size() > 0){
            for(Strategy strategy : strategies){
                LoanStrategyService loanStrategyService = (LoanStrategyService) BeanUtil.getBean(strategy.getImpl());
                LoanStrategyResult sresult = loanStrategyService.execute(name,phone,idNo,userScore,mobileType,blockBox);
                String formula = strategy.getFormula();
                if("zhimaCreditService".equals(strategy.getImpl())){
                    sresult.setScore(Double.parseDouble(zhimaScore));
                }
                if("borrowTimesService".equals(strategy.getImpl())){
                    sresult.setScore(Double.parseDouble(borrowTimeScore));
                }
                if (FsUtils.strsNotEmpty(formula)) {
                    Double rate = FsUtils.d(formula);
                    if (!rate.equals(0D)) {
                        if (FsUtils.strsNotEmpty(sresult.getScore()) && sresult.getScore() >= 0) {
                            totalScore = totalScore + FsUtils.mulDouble(rate, sresult.getScore().doubleValue());
                            buffer.append("+" + rate + "*" + sresult.getScore().doubleValue());
                        }
                    }
                }
            }
        }

        Double x = Math.pow(Math.E, totalScore);
        double d = FsUtils.divDouble(1D, FsUtils.addDouble(1D, x));
        Double modelScore = FsUtils.roundDouble(FsUtils.mulDouble(d, 100D), 2);
        FsUtils.log_info("模型分数:" + modelScore);
        userScore.setModelScore(BigDecimal.valueOf(modelScore));
        if(userScore.getZhimaScore().compareTo(BigDecimal.valueOf(0.0))==0
                || userScore.getUdScore().compareTo(BigDecimal.valueOf(-1))==0
                || userScore.getNewUdScore().compareTo(BigDecimal.valueOf(-1))==0){
            userScore.setModelScore(BigDecimal.valueOf(-1));
        }
        userScoreStatisticsService.insertSelective(userScore);
        Map<String,Object> map = new HashMap<>();
        map.put("modelScore",modelScore);
        return ResultUtil.genSuccessResult(map);
    }

    /**
     * 刷新config
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/ms/model/onConfig")
    public void onLoad(HttpServletResponse response)throws Exception{
        List<SysConfig> sysConfigList = sysConfigMapper.selectByExample(new SysConfigExample());
        for (SysConfig sysConfig : sysConfigList) {
            ReflectUtil.setValue(GlobalConfig.class, null, sysConfig.getCode(), sysConfig.getValue());
        }
        logger.info("success load sysconfig");
        response.getWriter().print("success load sysconfig");
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        //PHP发起的请求都是PHP所在服务器的内网IP，需要从自定义header中获取
        String str = request.getHeader("X-PHP-Real-IP");
        String str2 = request.getHeader("X-Forwarded-For");
        if(!StringUtil.isEmpty(str2)){
            ip = str2;
        }
        else{
            if(!StringUtil.isEmpty(str)){
                ip = str;
            }
        }
        if (StringUtil.isEmpty(ip)){
            ip = request.getRemoteAddr();
        }
        ip = StringUtil.isEmpty(ip)?"1.1.1.1":ip;
        if (StringUtil.isEmpty(ip)){
            ip = "1.1.1.1";
        }
        String[] ips= ip.split(",");
        if (ips.length>0){
            ip = ips[0].trim();
        }
        return ip;
    }

    @RequestMapping(value = "/ms/model/updateScore/submit")
    @ResponseBody
    public Object updateUdScore() throws Exception{
        List<UserScoreStatisticsLog> list = userScoreStatisticsLogService.queryList();
        for(UserScoreStatisticsLog log : list){
            updateModeScore(log.getId());
        }
        return ResultUtil.genSuccessResult();
    }

    public Object updateModeScore(Long logId){
        UserScoreStatisticsLog log = userScoreStatisticsLogService.selectById(logId);
        if(StringUtil.isEmpty(log.getUserName())
                || StringUtil.isEmpty(log.getPhone())
                || StringUtil.isEmpty(log.getIdNo())){
            return ResultUtil.genFailedResult(ErrorCode.FAIL,"name OR phone OR idno OR teamNo is null");
        }
        List<Strategy> strategies = strategyService.queryList();
        double totalScore = Double.parseDouble(GlobalConfig.rc_score);//风控基本分
        StringBuffer buffer = new StringBuffer();
        buffer.append(totalScore);
        if(strategies!=null && strategies.size() > 0){
            for(Strategy strategy : strategies){
                LoanStrategyService loanStrategyService = (LoanStrategyService) BeanUtil.getBean(strategy.getImpl());
                LoanStrategyResult sresult = loanStrategyService.execute1(
                        log.getUserName(),log.getPhone(),log.getIdNo(),log,log.getMobileType(),log.getBlackBox());
                String formula = strategy.getFormula();
                if("zhimaCreditService".equals(strategy.getImpl())){
                    sresult.setScore(Double.valueOf(log.getZhimaScore()+""));
                }
                if("borrowTimesService".equals(strategy.getImpl())){
                    sresult.setScore(Double.valueOf(log.getBorrowTimesScore()+""));
                }
                if (FsUtils.strsNotEmpty(formula)) {
                    Double rate = FsUtils.d(formula);
                    if (!rate.equals(0D)) {
                        if (FsUtils.strsNotEmpty(sresult.getScore()) && sresult.getScore() >= 0) {
                            totalScore = totalScore + FsUtils.mulDouble(rate, sresult.getScore().doubleValue());
                            buffer.append("+" + rate + "*" + sresult.getScore().doubleValue());
                        }
                    }
                }
            }
        }

        Double x = Math.pow(Math.E, totalScore);
        double d = FsUtils.divDouble(1D, FsUtils.addDouble(1D, x));
        Double modelScore = FsUtils.roundDouble(FsUtils.mulDouble(d, 100D), 2);
        FsUtils.log_info("模型分数:" + modelScore);
        log.setModelScore(BigDecimal.valueOf(modelScore));
        if(log.getZhimaScore().compareTo(BigDecimal.valueOf(0.0))==0
                || log.getUdScore().compareTo(BigDecimal.valueOf(-1))==0
                || log.getNewUdScore().compareTo(BigDecimal.valueOf(-1))==0){
            log.setModelScore(BigDecimal.valueOf(-1));
        }
        log.setCreateTime(new Date());
        userScoreStatisticsLogService.updateByPrimaryKeySelective(log);
        Map<String,Object> map = new HashMap<>();
        map.put("modelScore",modelScore);
        return ResultUtil.genSuccessResult(map);
    }


    /**
     * 刷新配置文件
     * @return
     */
    @RequestMapping(value = "ms/config/refresh",method = RequestMethod.GET)
    @ResponseBody
    public Object refresh(){
        sysConfigService.flushCache();
        logger.info(Global.getValue("tdr_android_loan_id"));
        return ResultUtil.genSuccessResult();
    }
}
















