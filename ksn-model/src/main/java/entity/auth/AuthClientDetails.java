package entity.auth;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/6/1 15:13
 */
@Data
public class AuthClientDetails implements ClientDetails {

    /**
     * 主键
     */
    private String id;
    /**
     * 平台唯一标识
     */
    private String appId;
    /**
     * 平台私钥
     */
    private String privateKey;
    private List<String> scopes;
    /**
     * 自动审核操作域
     */
    private List<String> autoApproveScope;
    /**
     * 授权类型
     */
    private List<String> grantTypes;
    /**
     * 转向请求地址
     */
    private LinkedList<String> redirectUris;
    /**
     * 资源唯一标识
     */
    private List<String> resourceIds;
    private List<String> roles;
    /**
     * token附加信息
     */
    private Map<String, Object> additionalInfo;
    /**
     * 令牌验证间隔（有效时间，单位：秒）
     */
    private Integer tokenValidSeconds;
    /**
     * 令牌刷新时间（单位：秒）
     */
    private Integer tokenRefreshSeconds;

    @Override
    public String getClientId() {
        return appId;
    }

    @Override
    public Set<String> getResourceIds() {
        return CollUtil.isNotEmpty(resourceIds) ? CollectionUtil.newHashSet(resourceIds) : CollectionUtil.newHashSet();
    }

    @Override
    public boolean isSecretRequired() {
        return StrUtil.isNotBlank(privateKey);
    }

    @Override
    public String getClientSecret() {
        return privateKey;
    }

    @Override
    public boolean isScoped() {
        return CollUtil.isNotEmpty(scopes);
    }

    @Override
    public Set<String> getScope() {
        return CollectionUtil.isNotEmpty(scopes) ? CollectionUtil.newHashSet(scopes) : CollectionUtil.newHashSet();
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return CollectionUtil.isNotEmpty(grantTypes) ? CollectionUtil.newHashSet(grantTypes) : CollectionUtil.newHashSet();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return CollectionUtil.isNotEmpty(redirectUris) ? CollectionUtil.newHashSet(redirectUris) : CollectionUtil.newHashSet();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        if (CollUtil.isNotEmpty(roles)) {
            roles.stream().forEach(role -> list.add(new SimpleGrantedAuthority(role)));
        }
        return list;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return tokenValidSeconds == null ? 0 : tokenValidSeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return tokenRefreshSeconds == null ? 0 : tokenRefreshSeconds;
    }

    // 验证scope
    @Override
    public boolean isAutoApprove(String scope) {
        if (CollUtil.isNotEmpty(autoApproveScope)) {
            return autoApproveScope.contains(scope);
        }
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return Collections.unmodifiableMap(additionalInfo);
    }
}
