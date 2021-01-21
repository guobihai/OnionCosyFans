package cc.onion.cosyfans.passport.listener;

/**
 * 密码状态显示控制
 * @author guobihai
 * @date 2019-11-27
 */
public interface PasswordSeeStateOnClickListener {


    /**
     * 密码状态控制
     */
    void passwordState(boolean isShow);


    void passwordStateAgain(boolean isShow);
}
