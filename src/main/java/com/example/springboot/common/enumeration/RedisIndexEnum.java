package com.example.springboot.common.enumeration;

/**
 * @Author: chenglvpeng
 * @Date: 2019/3/14  14:50
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public enum  RedisIndexEnum {
    INDEX_0(0, "0号仓库"),
    INDEX_1(1, "1号仓库"),
    INDEX_2(2, "2号仓库"),
    INDEX_3(3, "3号仓库"),
    INDEX_4(4, "4号仓库,活动服务默认仓库"),
    INDEX_5(5, "5号仓库"),
    INDEX_6(6, "6号仓库"),
    INDEX_7(7, "7号仓库"),
    INDEX_8(8, "8号仓库"),
    INDEX_9(9, "9号仓库"),
    INDEX_10(10, "10号仓库"),
    INDEX_11(11, "11号仓库"),
    INDEX_12(12, "12号仓库"),
    INDEX_13(13, "13号仓库"),
    INDEX_14(14, "14号仓库"),
    INDEX_15(15, "15号仓库");



    private int index;

    private String desc;

    private RedisIndexEnum(int index, String desc){
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    private void setDesc(String desc) {
        this.desc = desc;
    }
}
