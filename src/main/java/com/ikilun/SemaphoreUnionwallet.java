package com.ikilun;

import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
//seməfɔ
public class SemaphoreUnionwallet {
	private int DEF_QUEUE = 120;
	private Semaphore LoginQueue = new Semaphore(DEF_QUEUE);
	//private AtomicInteger usedQueueCount = new AtomicInteger(0);
	public int updateLoginSemaphoreMax(int max) {
		this.DEF_QUEUE = max;
		Semaphore tmpSemaphore = new Semaphore(max);
		LoginQueue = tmpSemaphore;
		return max;
	}
	//
	public ResultCode<String> getToken(String UNIONPAYWALLET_TOKEN_URL, Map<String, String> tokenParamMap){
        boolean allow = false;
		try {
//			int cur = this.usedQueueCount.get();
//			if(cur > this.DEF_QUEUE){
//				dbLogger.warn("银联排队：" + cur);
//				return ResultCode.getFailure("排队人数过多，请稍后重试");
//			}
			//5秒内能否获取许可
			allow = LoginQueue.tryAcquire(5, TimeUnit.SECONDS);
			if(allow){
				//this.usedQueueCount.incrementAndGet();
				/*tokenResult = HttpUtils.getUrlAsString(UNIONPAYWALLET_TOKEN_URL, tokenParamMap, DEFAULT_TIMEOUT);
		        if(!tokenResult.isSuccess()) {
		            dbLogger.warn("银联钱包登录失败："+tokenParamMap+","+tokenResult.getStatus());
		            return ResultCode.getFailure("01:" + tokenResult.getStatus(),"银联钱包登录失败：" + tokenResult.getStatus());
		        }*/
		        //return ResultCode.getSuccessReturn(tokenResult);
				return ResultCode.getSuccessReturn("");
			}else{
				return ResultCode.getFailure("02","排队人数过多，请稍后重试");
			}
		} catch (InterruptedException e) {
			 return ResultCode.getFailure("03","系统繁忙，请稍候重试");
		}finally {
			if(allow){
				LoginQueue.release();
				//this.usedQueueCount.decrementAndGet();
			}
		}
	}
}
