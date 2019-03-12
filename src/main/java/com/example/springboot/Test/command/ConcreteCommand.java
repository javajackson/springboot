package com.example.springboot.Test.command;

/**
 * @Author: chenglvpeng
 * @Date: 2019/2/19  10:00
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void executeCommand() {
        receiver.action();
    }
}
