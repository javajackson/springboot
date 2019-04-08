package com.example.springboot.common.enumeration;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  14:51
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public enum RedisExpireEnum {

    EXPIRE_FOREVER(new Long(Integer.MAX_VALUE), "永久保存，其实也需要设置一个最大正整数"),
    EXPIRE_1S(1L, "1秒"),
    EXPIRE_3S(3L, "3秒"),
    EXPIRE_5S(5L, "5秒"),
    EXPIRE_10S(10L, "10秒"),
    EXPIRE_20S(20L, "20秒"),
    EXPIRE_30S(30L, "30秒"),
    EXPIRE_1M(60L, "1分钟"),
    EXPIRE_3M(3*60L, "3分钟"),
    EXPIRE_5M(5*60L, "5分钟"),
    EXPIRE_10M(10*60L, "10分钟"),
    EXPIRE_20M(20*60L, "20分钟"),
    EXPIRE_30M(30*60L, "30分钟"),
    EXPIRE_1H(60*60L, "1小时"),
    EXPIRE_2H(2*60*60L, "2小时"),
    EXPIRE_1D(24*60*60L, "1天"),
    EXPIRE_7D(7*24*60*60L, "一周7天"),
    EXPIRE_30D(30*24*60*60L, "一个月30天"),





    ;







    private Long seconds;

    private String desc;

    private RedisExpireEnum(Long seconds, String desc){
        this.seconds = seconds;
        this.desc = desc;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
