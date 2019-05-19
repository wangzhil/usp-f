/*
package sinosoft.com.ribbon.clienta.aspect;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guobao.dto.common.Head;
import com.guobao.dto.common.TransData;
import com.guobao.dto.common.YBTExceptionRes;
import com.guobao.dto.log.LkclienttranlogWithBLOBs;
import com.guobao.dto.qry.common.ExceptionRes;
import com.guobao.dto.qry.common.HeadData;
import com.guobao.dto.qry.common.QryTransData;
import com.guobao.enums.ENUM_RESULT;
import com.guobao.ifp.enums.ENUM_INTERFACEID;
import com.guobao.insure.service.dto.check.response.ResCheckInputData;
import com.guobao.insure.service.dto.check.response.ResUWBody;
import com.guobao.insure.service.rpc.CommonService;
import com.guobao.utils.CommonUtil;
import com.guobao.utils.DateUtil;

@Aspect
@Component
public class WebFacadeInsureAspect {

	private static final Logger LOG = LoggerFactory.getLogger(WebFacadeInsureAspect.class);

	@Autowired
	private CommonService commonService;
	
	private String prtNo;

	// 正则表达式配置切入包，类，方法
	@Pointcut("execution(public * com.guobao.insure.service.facade.InsureService.*(..))")
	public void WebFacadeAspectAop() {
	}
	


	@Around(value = "WebFacadeAspectAop()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();// 开始时间
		long endTime = 0;// 结束时间
		LkclienttranlogWithBLOBs lkTranLog = new LkclienttranlogWithBLOBs();// 日志记录
		Object result = null;//返回报文
		Head head =null;//头部报文
		HeadData headData =null;
		TransData transData =null;
		QryTransData qrytransData =null;
		YBTExceptionRes res = new YBTExceptionRes();
		ExceptionRes qryRes = new ExceptionRes();
		boolean isReFlag = false ; 
		try {
			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			ServletRequestAttributes sra = (ServletRequestAttributes) ra;
			HttpServletRequest request = sra.getRequest(); // 获取request信息

			String method = request.getMethod();
			String uri = request.getRequestURI(); // 获取请求地址
			int n = uri.lastIndexOf("/");
			String interfaceCode = uri.substring(n + 1);
			// String queryString = request.getQueryString();
			// Map<?, ?> inputParamMap = request.getParameterMap();
			String params = "";
			if ("POST".equals(method)) {
				Object[] paramsArray = proceedingJoinPoint.getArgs();
				params = argsArrayToString(paramsArray);
			}
			// 1、记录开始log日志
			LOG.info("[WebFacadeInsureAspect.doAround][\r\n开始时间" + DateUtil.getDateStr(new Date(startTime)) + ",请求接口："
					+ interfaceCode + "]");
			LOG.info("[WebFacadeInsureAspect.doAround][\r\n请求报文" + params + "]");
			JSONObject json = JSON.parseObject(params);
			transData = JSON.parseObject(json.get("TransData").toString(), TransData.class);

			head = transData.getBaseInfo();
			if (null != head) {

				// 2、重复校验
				Boolean exist = commonService.queryClientTransLog(head.getTransSeq());
				if (exist != null && exist.booleanValue()) {
					isReFlag = true;
					throw new Exception("重复请求");
				}

				String prtNo = getRequestPrtNO(params);// 获取订单号，如果报文中没有订单号，返回空
				// 3、封装数据库日志-开始信息
				lkTranLog.setTranno(head.getTransSeq());// 交易流水号
				lkTranLog.setOtherno(prtNo);// 订单号
				lkTranLog.setTranstype(head.getTransCode()); // 业务类型
				lkTranLog.setCategory("YBT");// 接口区分
				lkTranLog.setRequesttime(new Date(startTime));// 请求时间
				lkTranLog.setRequestcontent(json.toString());// 请求内容
				lkTranLog.setMakedate(DateUtil.getCurrentDate());// 入机时间

				// 4、调用拦截方法
				// result的值就是被拦截方法的返回值
				result = proceedingJoinPoint.proceed();
				endTime = System.currentTimeMillis();// 结束时间
				float useTime = (float) ((endTime - startTime) / 1000.00);// 用时

				// 5、封装数据库日志-结束信息，并落入数据库
				lkTranLog.setResponsecontent(result.toString());// 返回报文
				lkTranLog.setResponsetime(new Date(endTime));// 返回时间
				lkTranLog.setUsedtime(useTime);// 耗时
				lkTranLog.setState(getResultStatus(result.toString())); // 交易状态

				// 6、记录结束log日志
				LOG.info("[WebFacadeInsureAspect.doAround][\r\n结束时间：" + DateUtil.getDateStr(new Date(endTime)) + "用时:"
						+ useTime + ",请求接口：" + interfaceCode + "]");
				LOG.info("[WebFacadeInsureAspect.doAround][\r\n返回报文：" + result + "]");
				return result;
			} else {
				qrytransData = JSON.parseObject(json.get("TransData").toString(), QryTransData.class);
				headData = qrytransData.getHeadData();

				// 2、重复校验
				Boolean exist = commonService.queryClientTransLog(headData.getID());
				if (exist != null && exist.booleanValue()) {
					isReFlag = true;
					throw new Exception("重复请求");
				}
				
				prtNo = getRequestPrtNO(params);// 获取订单号，如果报文中没有订单号，返回空

				// 3、封装数据库日志-开始信息
				lkTranLog.setTranno(headData.getID());// 交易流水号
				lkTranLog.setOtherno(prtNo);// 订单号
				lkTranLog.setTranstype(headData.getTRANS_CODE()); // 接口区分
				lkTranLog.setCategory(headData.getREQ_APP_ID());// 源系统ID
				lkTranLog.setRequesttime(new Date(startTime));// 请求时间
				lkTranLog.setRequestcontent(json.toString());// 请求内容
				lkTranLog.setMakedate(DateUtil.getCurrentDate());// 入机时间

				// 4、调用拦截方法
				// result的值就是被拦截方法的返回值
				result = proceedingJoinPoint.proceed();
				endTime = System.currentTimeMillis();// 结束时间
				float useTime = (float) ((endTime - startTime) / 1000.00);// 用时

				// 5、封装数据库日志-结束信息，并落入数据库            /20181123    何竞帆修改lkclienttranlog表中，核保接口新生成prtNo替换原prtNo
			    if(ENUM_INTERFACEID.FHNB002.code().equals(headData.getTRANS_CODE())) {
						lkTranLog.setOtherno(getResultPrtNo(result.toString()));
					}
				lkTranLog.setResponsecontent(result.toString());// 返回报文
				lkTranLog.setResponsetime(new Date(endTime));// 返回时间
				lkTranLog.setUsedtime(useTime);// 耗时
				lkTranLog.setState(getResultStatus(result.toString())); // 交易状态
				// 6、记录结束log日志
				LOG.info("[WebFacadeInsureAspect.doAround][\r\n结束时间：" + DateUtil.getDateStr(new Date(endTime)) + "用时:"
						+ useTime + ",请求接口：" + interfaceCode + "]");
				LOG.info("[WebFacadeInsureAspect.doAround][\r\n返回报文：" + result + "]");
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// String errorReturn = createErrorRepeat(e.getMessage());
			LOG.error("WebFacadeInsureAspect.doAround][系统异常，异常信息：" + e.getMessage() + "]");
			LOG.error("WebFacadeInsureAspect.doAround][\r\n返回报文：" + JSON.toJSON(e.getMessage()) + "]");
			if(null!=head){
				head = CommonUtil.returnHead(head, ENUM_RESULT.FAIL.code(), ENUM_RESULT.FAIL.desc()+"-"+e.getMessage());
				transData.setBaseInfo(head);
				res.setTransData(transData);
				return JSON.toJSONString(res);
			}else if(null != headData){
				headData = CommonUtil.returnHeadData(headData, ENUM_RESULT.FAIL.code(), ENUM_RESULT.FAIL.desc()+"-"+e.getMessage());
				qrytransData.setHeadData(headData);
				qryRes.setTransData(qrytransData);
				return JSON.toJSONString(qryRes);
			}
		} finally {
			try {
				if(!isReFlag){
					commonService.addClientTransLog(lkTranLog);
				}
			} catch (Exception ex) {
				LOG.error("[WebFacadeInsureAspect.doAround][日志记录数据库出现错误：" + ex.getMessage() + "]");
			}
		}
		return result;
	}

	


	
	*//**
	 * 请求参数拼装
	 * 
	 * @param paramsArray
	 * @return
	 *//*
	private String argsArrayToString(Object[] paramsArray) {
		String params = "";
		if (paramsArray != null && paramsArray.length > 0) {
			for (int i = 0; i < paramsArray.length; i++) {
				Object jsonObj = JSON.toJSON(paramsArray[i]);
				params += jsonObj.toString() + " ";
			}
		}
		try {
			params = new String(params.getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return params.trim();
	}

	
	 * 从返回信息中获取返回code
	 
	private String getRequestPrtNO(String requestJson) {
		int n = requestJson.indexOf("PrtNo");
		if (n == -1) {
			return "";
		}

		String temp = requestJson.substring(n);
		String prtno = temp.split(",")[0];
		prtno = prtno.replace("PrtNo", "").replace("\"", "").replace(",", "").replace(":", "").replace("}", "").replaceAll("\\s+", "");
		return prtno;
	}

	
	 * 从返回信息中获取返回code
	 
	private String getResultStatus(String result) {
		String resultCode = "";
		JSONObject resultJson = JSON.parseObject(result);
		TransData transData = JSON.parseObject(resultJson.get("TransData").toString(), TransData.class);
		Head head = transData.getBaseInfo();
		if (null != head) {
			resultCode = head.getResultCode();
		} else {
			QryTransData qrytransData = JSON.parseObject(resultJson.get("TransData").toString(), QryTransData.class);
			HeadData headData = qrytransData.getHeadData();
			resultCode = headData.getRESP_CODE();
		}
		return resultCode;
	}

	*//**
	 * 获取返回报文的投保单号
	 * @param result
	 * @return
	 *//*
	private String getResultPrtNo(String result) {
		String prtNo = this.prtNo;
		JSONObject resultJson = JSON.parseObject(result);
		ResUWBody resUWBody = JSON.parseObject(resultJson.get("TransData").toString(), ResUWBody.class);
		if(null !=  resUWBody.getInputData()) {
		ResCheckInputData inputData = resUWBody.getInputData();
		prtNo = inputData.getPrtNo();
		}
		return prtNo;
	}
	
	 * 创建重复返回报文，抽取方法，已便扩展
	 
	private String createErrorRepeat(String errorMsg) {
		String errorRepeat = "{\"response\":{\"status\":{\"statuscode\":\"03\",\"statusmessage\":[\"交易异常\",\""
				+ errorMsg + "\"]}}}";
		return errorRepeat;
	}
}
*/