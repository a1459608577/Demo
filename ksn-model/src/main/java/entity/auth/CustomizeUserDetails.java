package entity.auth;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 22:08
 */
@Data
@TableName("t_user")
public class CustomizeUserDetails implements UserDetails {

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("accountNonExpired")
    private boolean accountNonExpired;
    @TableField("accountNonLocked")
    private boolean accountNonLocked;
    @TableField("credentialsNonExpired")
    private boolean credentialsNonExpired;
    @TableField("enabled")
    private boolean enabled;
    @TableField(exist = false)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        if (CollUtil.isNotEmpty(getRoles())) {
            for (Role role : getRoles()) {
                list.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
