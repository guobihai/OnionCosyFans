package cc.onion.cosyfans.passport.api;

import cc.onion.cosyfans.base.entity.BaseRequestBean;
import cc.onion.cosyfans.base.entity.BaseResponse;
import cc.onion.cosyfans.passport.entity.LoginRequest;
import cc.onion.cosyfans.passport.entity.LoginResponEntity;
import cc.onion.cosyfans.passport.entity.NextVerificationPasswordRequest;
import cc.onion.cosyfans.passport.entity.RegisterRequest;
import cc.onion.cosyfans.passport.entity.SendEmailRequest;
import cc.onion.cosyfans.passport.entity.SmsRequest;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author guobihai
 * @date 2019-11-27
 */
public interface SigninApi {

    /**
     * 登录
     * @param requestBean
     * @return
     */
    @POST("/user/login")
    Observable<BaseResponse<LoginResponEntity>> login(@Body LoginRequest requestBean);


    /**
     * 退出
     * @param requestBean
     * @return
     */
    @POST("/user/detail/logOut")
    Observable<BaseResponse> logOut(@Body BaseRequestBean requestBean);


    /**
     * 发送短信
     * @param requestBean
     * @return
     */
    @POST("/user/doSendSms")
    Observable<BaseResponse> doSendSms(@Body SmsRequest requestBean);


    /**
     * 发送邮件
     * @param requestBean
     * @return
     */
    @POST("/user/doSendEmail")
    Observable<BaseResponse> doSendEmail(@Body SendEmailRequest requestBean);


    /**
     * 找回密码:下一步
     * @param requestBean
     * @return
     */
    @POST("/user/retrievePassword/verification")
    Observable<BaseResponse> retrievePassword(@Body NextVerificationPasswordRequest requestBean);


    /**
     * 重置密码
     * @param requestBean
     * @return
     */
    @POST("/user/detail/resetPassword")
    Observable<BaseResponse> resetPassword(@Body BaseRequestBean requestBean);


    /**
     * 找回密码:修改密码
     * @param requestBean
     * @return
     */
    @POST("/user/retrievePassword/resetPassword")
    Observable<BaseResponse> modifyPassword(@Body BaseRequestBean requestBean);


    @POST("/user/register")
    Observable<BaseResponse> registerAccount(@Body RegisterRequest requestBean);

}
