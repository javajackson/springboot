package com.example.springboot.dao.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * @Author: chenglvpeng
 * @Date: 2019/1/15  14:20
 * @Description:
 * @注意：本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User extends BaseDo{
    private Long id;
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getUsername(), getPassword());
    }
}
