package base;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;


public enum ExceptionStatus implements IEnum {

// 1xx Informational

    /**
     * {@code 100 Continue}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.2.1">HTTP/1.1: Semantics and Content, section 6.2.1</a>
     */
    CONTINUE(100, "Continue"),
    /**
     * {@code 101 Switching Protocols}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.2.2">HTTP/1.1: Semantics and Content, section 6.2.2</a>
     */
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    /**
     * {@code 102 Processing}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2518#section-10.1">WebDAV</a>
     */
    PROCESSING(102, "Processing"),
    /**
     * {@code 103 Checkpoint}.
     *
     * @see <a href="http://code.google.com/p/gears/wiki/ResumableHttpRequestsProposal">A proposal for supporting
     * resumable POST/PUT HTTP requests in HTTP/1.0</a>
     */
    CHECKPOINT(103, "Checkpoint"),

    // 2xx Success

    /**
     * {@code 200 OK}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.1">HTTP/1.1: Semantics and Content, section 6.3.1</a>
     */
    OK(200, "OK"),
    /**
     * {@code 201 Created}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.2">HTTP/1.1: Semantics and Content, section 6.3.2</a>
     */
    CREATED(201, "Created"),
    /**
     * {@code 202 Accepted}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.3">HTTP/1.1: Semantics and Content, section 6.3.3</a>
     */
    ACCEPTED(202, "Accepted"),
    /**
     * {@code 203 Non-Authoritative Information}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.4">HTTP/1.1: Semantics and Content, section 6.3.4</a>
     */
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    /**
     * {@code 204 No Content}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.5">HTTP/1.1: Semantics and Content, section 6.3.5</a>
     */
    NO_CONTENT(204, "No Content"),
    /**
     * {@code 205 Reset Content}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.3.6">HTTP/1.1: Semantics and Content, section 6.3.6</a>
     */
    RESET_CONTENT(205, "Reset Content"),
    /**
     * {@code 206 Partial Content}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7233#section-4.1">HTTP/1.1: Range Requests, section 4.1</a>
     */
    PARTIAL_CONTENT(206, "Partial Content"),
    /**
     * {@code 207 Multi-Status}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-13">WebDAV</a>
     */
    MULTI_STATUS(207, "Multi-Status"),
    /**
     * {@code 208 Already Reported}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5842#section-7.1">WebDAV Binding Extensions</a>
     */
    ALREADY_REPORTED(208, "Already Reported"),
    /**
     * {@code 226 IM Used}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc3229#section-10.4.1">Delta encoding in HTTP</a>
     */
    IM_USED(226, "IM Used"),

    // 3xx Redirection

    /**
     * {@code 300 Multiple Choices}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.1">HTTP/1.1: Semantics and Content, section 6.4.1</a>
     */
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    /**
     * {@code 301 Moved Permanently}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.2">HTTP/1.1: Semantics and Content, section 6.4.2</a>
     */
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    /**
     * {@code 302 Found}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.3">HTTP/1.1: Semantics and Content, section 6.4.3</a>
     */
    FOUND(302, "Found"),
    /**
     * {@code 302 Moved Temporarily}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc1945#section-9.3">HTTP/1.0, section 9.3</a>
     * @deprecated in favor of {@link #FOUND} which will be returned from {@code HttpStatus.valueOf(302)}
     */
    @Deprecated
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    /**
     * {@code 303 See Other}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.4">HTTP/1.1: Semantics and Content, section 6.4.4</a>
     */
    SEE_OTHER(303, "See Other"),
    /**
     * {@code 304 Not Modified}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7232#section-4.1">HTTP/1.1: Conditional Requests, section 4.1</a>
     */
    NOT_MODIFIED(304, "Not Modified"),
    /**
     * {@code 305 Use Proxy}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.5">HTTP/1.1: Semantics and Content, section 6.4.5</a>
     * @deprecated due to auth concerns regarding in-band configuration of a proxy
     */
    @Deprecated
    USE_PROXY(305, "Use Proxy"),
    /**
     * {@code 307 Temporary Redirect}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.4.7">HTTP/1.1: Semantics and Content, section 6.4.7</a>
     */
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    /**
     * {@code 308 Permanent Redirect}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7238">RFC 7238</a>
     */
    PERMANENT_REDIRECT(308, "Permanent Redirect"),

    // --- 4xx Client Error ---

    /**
     * {@code 400 Bad Request}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.1">HTTP/1.1: Semantics and Content, section 6.5.1</a>
     */
    BAD_REQUEST(400, "请求无效"),
    /**
     * {@code 401 Unauthorized}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.1">HTTP/1.1: Authentication, section 3.1</a>
     */
    UNAUTHORIZED(401, "请求未授权"),
    /**
     * {@code 402 Payment Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.2">HTTP/1.1: Semantics and Content, section 6.5.2</a>
     */
    PAYMENT_REQUIRED(402, "Payment Required"),
    /**
     * {@code 403 Forbidden}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.3">HTTP/1.1: Semantics and Content, section 6.5.3</a>
     */
    FORBIDDEN(403, "请求被禁止"),
    /**
     * {@code 404 Not Found}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.4">HTTP/1.1: Semantics and Content, section 6.5.4</a>
     */
    NOT_FOUND(404, "找不到请求资源"),
    /**
     * {@code 405 Method Not Allowed}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.5">HTTP/1.1: Semantics and Content, section 6.5.5</a>
     */
    METHOD_NOT_ALLOWED(405, "请求类型不允许"),
    /**
     * {@code 406 Not Acceptable}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.6">HTTP/1.1: Semantics and Content, section 6.5.6</a>
     */
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    /**
     * {@code 407 Proxy Authentication Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7235#section-3.2">HTTP/1.1: Authentication, section 3.2</a>
     */
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    /**
     * {@code 408 Request Timeout}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.7">HTTP/1.1: Semantics and Content, section 6.5.7</a>
     */
    REQUEST_TIMEOUT(408, "请求超时"),
    /**
     * {@code 409 Conflict}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.8">HTTP/1.1: Semantics and Content, section 6.5.8</a>
     */
    CONFLICT(409, "请求资源冲突"),
    /**
     * {@code 410 Gone}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.9">
     * HTTP/1.1: Semantics and Content, section 6.5.9</a>
     */
    GONE(410, "Gone"),
    /**
     * {@code 411 Length Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.10">
     * HTTP/1.1: Semantics and Content, section 6.5.10</a>
     */
    LENGTH_REQUIRED(411, "Length Required"),
    /**
     * {@code 412 Precondition failed}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7232#section-4.2">
     * HTTP/1.1: Conditional Requests, section 4.2</a>
     */
    PRECONDITION_FAILED(412, "Precondition Failed"),
    /**
     * {@code 413 Payload Too Large}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.11">
     * HTTP/1.1: Semantics and Content, section 6.5.11</a>
     * @since 4.1
     */
    PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
    /**
     * {@code 413 Request Entity Too Large}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2616#section-10.4.14">HTTP/1.1, section 10.4.14</a>
     * @deprecated in favor of {@link #PAYLOAD_TOO_LARGE} which will be
     * returned from {@code HttpStatus.valueOf(413)}
     */
    @Deprecated
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    /**
     * {@code 414 URI Too Long}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.12">
     * HTTP/1.1: Semantics and Content, section 6.5.12</a>
     * @since 4.1
     */
    URI_TOO_LONG(414, "URI Too Long"),
    /**
     * {@code 414 Request-URI Too Long}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2616#section-10.4.15">HTTP/1.1, section 10.4.15</a>
     * @deprecated in favor of {@link #URI_TOO_LONG} which will be returned from {@code HttpStatus.valueOf(414)}
     */
    @Deprecated
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    /**
     * {@code 415 Unsupported Media Type}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.13">
     * HTTP/1.1: Semantics and Content, section 6.5.13</a>
     */
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    /**
     * {@code 416 Requested Range Not Satisfiable}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7233#section-4.4">HTTP/1.1: Range Requests, section 4.4</a>
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested range not satisfiable"),
    /**
     * {@code 417 Expectation Failed}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.5.14">
     * HTTP/1.1: Semantics and Content, section 6.5.14</a>
     */
    EXPECTATION_FAILED(417, "Expectation Failed"),
    /**
     * {@code 418 I'm a teapot}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2324#section-2.3.2">HTCPCP/1.0</a>
     */
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    /**
     * @deprecated See
     * <a href="http://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">
     * WebDAV Draft Changes</a>
     */
    @Deprecated
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),
    /**
     * @deprecated See
     * <a href="http://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">
     * WebDAV Draft Changes</a>
     */
    @Deprecated
    METHOD_FAILURE(420, "Method Failure"),
    /**
     * @deprecated See <a href="http://tools.ietf.org/rfcdiff?difftype=--hwdiff&url2=draft-ietf-webdav-protocol-06.txt">
     * WebDAV Draft Changes</a>
     */
    @Deprecated
    DESTINATION_LOCKED(421, "Destination Locked"),
    /**
     * {@code 422 Unprocessable Entity}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.2">WebDAV</a>
     */
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    /**
     * {@code 423 Locked}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.3">WebDAV</a>
     */
    LOCKED(423, "Locked"),
    /**
     * {@code 424 Failed Dependency}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.4">WebDAV</a>
     */
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    /**
     * {@code 426 Upgrade Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc2817#section-6">Upgrading to TLS Within HTTP/1.1</a>
     */
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    /**
     * {@code 428 Precondition Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-3">Additional HTTP Status Codes</a>
     */
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    /**
     * {@code 429 Too Many Requests}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-4">Additional HTTP Status Codes</a>
     */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    /**
     * {@code 431 Request Header Fields Too Large}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-5">Additional HTTP Status Codes</a>
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    /**
     * {@code 451 Unavailable For Legal Reasons}.
     *
     * @see <a href="https://tools.ietf.org/html/draft-ietf-httpbis-legally-restricted-status-04">
     * An HTTP Status Code to Report Legal Obstacles</a>
     * @since 4.3
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),

    // --- 5xx Server Error ---

    /**
     * {@code 500 Internal Server Error}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.1">HTTP/1.1: Semantics and Content, section 6.6.1</a>
     */
    INTERNAL_SERVER_ERROR(500, "系统内部服务异常"),
    /**
     * {@code 501 Not Implemented}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.2">HTTP/1.1: Semantics and Content, section 6.6.2</a>
     */
    NOT_IMPLEMENTED(501, "Not Implemented"),
    /**
     * {@code 502 Bad Gateway}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.3">HTTP/1.1: Semantics and Content, section 6.6.3</a>
     */
    BAD_GATEWAY(502, "系统网关错误"),
    /**
     * {@code 503 Service Unavailable}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.4">HTTP/1.1: Semantics and Content, section 6.6.4</a>
     */
    SERVICE_UNAVAILABLE(503, "系统服务不可用"),
    /**
     * {@code 504 Gateway Timeout}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.5">HTTP/1.1: Semantics and Content, section 6.6.5</a>
     */
    GATEWAY_TIMEOUT(504, "网关请求超时"),
    /**
     * {@code 505 HTTP Version Not Supported}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc7231#section-6.6.6">HTTP/1.1: Semantics and Content, section 6.6.6</a>
     */
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported"),
    /**
     * {@code 506 Variant Also Negotiates}
     *
     * @see <a href="http://tools.ietf.org/html/rfc2295#section-8.1">Transparent Content Negotiation</a>
     */
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    /**
     * {@code 507 Insufficient Storage}
     *
     * @see <a href="http://tools.ietf.org/html/rfc4918#section-11.5">WebDAV</a>
     */
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    /**
     * {@code 508 Loop Detected}
     *
     * @see <a href="http://tools.ietf.org/html/rfc5842#section-7.2">WebDAV Binding Extensions</a>
     */
    LOOP_DETECTED(508, "Loop Detected"),
    /**
     * {@code 509 Bandwidth Limit Exceeded}
     */
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    /**
     * {@code 510 Not Extended}
     *
     * @see <a href="http://tools.ietf.org/html/rfc2774#section-7">HTTP Extension Framework</a>
     */
    NOT_EXTENDED(510, "Not Extended"),
    /**
     * {@code 511 Network Authentication Required}.
     *
     * @see <a href="http://tools.ietf.org/html/rfc6585#section-6">Additional HTTP Status Codes</a>
     */
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required"),

    INVOKE_API_PARAMETER_EXCEPTION(-0100, "接口调用参数异常"),
    FACTORY_EXCEPTION(-0200, "工厂处理异常"),
    INVOKE_API_EXCEPTION(-0300, "接口调用异常"),
    NULL_OBJECT_ERROR(-1001, "对象为空"),
    INVOKE_ERROR(-1002, "服务调用异常"),
    LOGIN_FAIL(-1003, "登录失败"),
    AUTHENTICATION_IS_EMPTY(-1004, "认证信息为空"),
    ACCOUNT_NAME_NULL(-1005, "账户名称为空"),
    CLIENT_ID_NULL(-1006, "应用标识为空"),
    ACCOUNT_IS_NULL(-1007, "账户信息为空"),
    CLIENT_DETAILS_EMPTY(-1008, "应用信息为空"),
    ACCOUNT_DETAILS_EMPTY(-1009, "账户信息为空"),
    ACCOUNT_CLIENT_NOT_MATCH(-1010, "应用未授权当前账户"),
    REQUEST_PARAMETERS_ERROR(-1011, "请求参数不正确"),
    AUTHENTICATION_INFO_ERROR(-1012, "认证信息错误"),
    ACCOUNT_NOT_EXIST(-1013, "账户不存在"),
    REQUEST_PARAMETERS_EMPTY(-1014, "请求参数存在空值"),
    ACCOUNT_ENTERPRISE_EMPTY(-1015, "账户企业信息为空！"),
    ACCOUNT_CORPORATION_EMPTY(-1016, "法人企业信息为空！"),
    DICTIONARY_CODE_DUPLICATE(-1017, "字典Code字段重复"),
    PARAN_VERIFICATION_NOT_ADOPT(-1018, "参数校验未通过，请检查参数"),
    DATA_VERSION_ERROR(-1019, "数据状态已被更新"),
    MESSAGE_TEMPLATE_NULL(-1020, "消息模板不存在"),
    PASSWORD_NOT_MATCH(-1021, "用户名或密码不正确"),
    ACCESS_TOKEN_IS_EXPIRED(-1022, "Access token expired"),
    REFRESH_TOKEN_IS_EXPIRED(-1023, "Refresh token expired"),
    ACCOUNT_IS_EXIST(-1024,"账户信息已存在"),
    CAPTCHA_CODE_IS_EMPTY(-1025,"验证码填写为空"),
    CAPTCHA_CODE_IS_ERROR(-1026,"验证码填写有误"),
    DUPLICATE_KEY(-2001, "存在重复主键"),
    NO_SUPPORT_MODE(-2002, "不支持的模式"),
    DIC_DATA_NOT(-2003, "字典数据不存在"),
    AMQP_MESSAGE_IS_EMPTY(-3001, "队列消息为空"),
    AMQP_MESSAGE_HANDLE_ERROR(-3002, "队列消息处理异常"),
    AMQP_ASYNC_TASK_HANDLE_ERROR(-3003, "队列消息-异步任务处理异常，执行参数有误"),
    SPRING_CONTEXT_IS_EMPTY(-4001, "上下文为空"),
    SPRING_BEAN_IS_NULL(-4002, "Spring Bean为空"),
    SPRING_REFLECT_ERROR(-4003, "Spring Bean反射调用错误"),
    DUBBO_PROVIDER_IS_NULL(-4004, "Dubbo服务为空"),
    ORDER_SERVICE_RESPONSE_NULL(-5001, "订单服务响应数据为空"),
    ORDER_SERVICE_STATUS_ERROR(-5002, "订单服务响应状态异常"),
    ORDER_SERVICE_DATA_NULL(-5003, "订单服务响应订单数据为空"),
    ORDER_INFO_TRANSFORM_ERROR(-5004, "订单数据转换异常"),
    ORDER_SERVICE_PARAM_ERROR(-5005, "订单服务参数异常"),
    ORDER_SERVICE_SELLER_EMPTY(-5006, "订单服务卖家账户信息为空"),
    ORDER_SERVICE_SELLER_PARAM_EMPTY(-5007, "订单服务-卖家参数为空"),
    FILE_SERVICE_ERROR(-5008, "文件服务异常"),
    SOURCE_EXCEL_FILE_EMPTY(-5009, "excel文件为空"),
    NOTIFY_MSG_ERROR(-5010, "消息通知处理异常"),
    SOURCE_FILE_EMPTY(-5011, "目标文件为空"),
    FILE_CLOUD_URL_EMPTY(-5012,"文件云下载地址为空"),
    FOREIGN_API_CONFIG_EMPTY(-6001, "外部接口服务-配置为空"),
    DROOLS_RULES_LOAD_ERROR(-6002, "Drools规则加载异常"),
    GOVERNMENT_STATUS_ERROR(-7001, "政务服务状态处理异常"),
    GOVERNMENT_APPLY_DEAL_ERROR(-7002, "服务单处理异常"),
    MAIL_WAY_DEAL_ERROR(-7003, "处理邮寄/现场办理方式异常"),
    GOVERNMENT_APPLY_INFO_EMPTY(-7004, "工单信息为空"),
    GOVERNMENT_APPLY_INFO_REPEAT(-7005, "重复提交此工单"),
    GOVERNMENT_APPLY_INFO_ALREADY(-7006, "此类工单已存在"),
    GOVERNMENT_APPLY_STATUS_ERROR(-7007, "工单状态异常"),
    GOVERNMENT_FILL_RECORD_INVESTOR_EMPTY(-7007, "投资人信息集合对象为空"),
    GOVERNMENT_FILL_RECORD_CUSTOMS_BROKER_EMPTY(-7007, "报关人信息集合对象为空"),
    GOVERNMENT_APPLY_INFO_STATUS_FAIL_NOT(-7008, "请检查工单信息，工单状态无法识别或不存在"),
    GOVERNMENT_APPLY_INFO_INTERRUPT_OPERATION(-7009, "工单已完结或该工单未到审批步骤或工单重复操作"),
    ENTERPRISE_ACCOUNTINFO_ADMIN_ERROR(-8001, "企业管理员已存在"),
    ENTERPRISE_ACCOUNINFO_CONTACT(-8002, "账户企业信息不存在"),
    ENTERPRISE_ACCOUNTINFO_ADMIN_NOT_UPDATE_CONTACT(-8003, "不可修改管理员与企业关联信息"),
    EMS_ORDER_NOT_PAY(-9001, "EMS支付单尚未支付"),
    EMS_CHANGE_PAYMENTWAY_SAME(-9002, "EMS切换支付方式前后相同"),
    EMS_REFUND_ERROR(-9003, "EMS订单退款失败"),
    EMS_ORDER_CANCEL_ERROR(-9003, "EMS取消订单失败"),
    EMS_CHANGE_PAYMENTWAY_ERROR(-9004, "EMS重新生成新的支付方式数据失败"),
    EMS_ORDER_CREATE_ERROR(-9005, "EMS支付订单创建失败"),
    EMS_CHANGE_PAYMENT_MANY(-9006, "EMS更换支付方式次数过多"),
    EMS_PAY_NOTIFY_MSG_EMPTY(-9007, "EMS支付成功回调参数为空"),
    EMS_REFUND_NOTIFY_MSG_EMPTY(-9008, "EMS退款成功回调参数为空"),
    EMS_PAY_ALREADY_ERROR(-9009, "EMS已支付，请勿重复生成二维码"),
    EMS_ORDER_QUERY_ERROR(-9010, "EMS订单查询失败"),
    EMS_ORDER_TIMEOUT_ERROR(-9011, "EMS订单已超出有效支付时间"),
    EMS_CREATE_NOTIFY_ERROR(-9012, "EMS成功支付通知异常"),
    EMS_REFUND_NOTIFY_ERROR(-9013, "EMS成功退款通知异常"),
    EMS_PAYMENT_INFO_EMPTY(-9014, "EMS尚未生成支付单"),
    EMS_QRCODE_QUERY_ERROR(-9015, "EMS订单二维码查询失败"),
    EMS_LOGISTICS_ORDER_RESULT_DECRYPT_ERROR(-10001, "EMS物流返回结果解密失败"),
    EMS_LOGISTICS_ORDER_ADD_FAIL_NOT_PAYMENT(-10002, "受理失败，EMS物流下单失败，支付数据不存在或未支付"),
    EMS_LOGISTICS_ORDER_ADD_UNRECOGNIZED_LOGISTICS_TYPE(-10003, "无法识别邮寄类型"),
    EMS_LOGISTICS_ORDER_ADD_FAIL_NOT_LOGISTICS(-10004, "受理失败，物流下单所需的物流信息不存在"),
    EMS_LOGISTICS_ORDER_ADD_FAIL(-10005, "受理失败，物流未成功下单"),
    EMS_LOGISTICS_ORDER_QUERY_FAIL_DATA_NULL(-10006, "查询物流信息失败，平台没有该条物流信息记录或申请单信息为空"),
    REDIS_DELAY_QUEUE_ADD_CONTEXT_ERROR(-11001,"redis延时消息队列新增消息失败"),
    WX_CONFIG_ERROR(-12001,"微信配置信息错误"),
    WX_GET_ACCESS_TOKEN_ERROR(-12002,"微信获取ACCESS_TOKEN错误"),
    WX_PARSE_CALLBACK_XML_ERROR(-12003,"解析微信响应的xml数据错误"),
    WX_BIND_USERID_REPEAT(-12004,"该账号已经绑定微信，无需重复绑定"),
    WX_CREATE_QRCODE_ERROR(-12005,"创建微信二维码失败"),
    WX_NOTIFY_ERROR(-12006,"微信响应消息有误"),
    WX_THIRDPART_APP_EMPTY(-12007,"未找到第三方平台微信的信息"),
    WX_SEND_TEMPLATE_ERROR(-12008,"未找到微信推送模板"),
    WX_SEND_TOUSER_EMPTY(-12009,"未找到合适的微信推送用户"),
    WX_BIND_USERID_EMPTY(-12010,"该账号尚未绑定微信"),
    WX_SEND_MESSAGE_ERROR(-12011,"未找到合适的发送消息类型"),

    RESOURCE_INFORMATION_IS_EMPTY(-13001, "资源必填项未填写"),
    RESOURCE_IS_EXIST(-13002,"该资源编码已经存在"),

    MESSAGE_INFORMATION_IS_EMPTY(-14001,"消息必填项为空"),
    MESSAGE_IS_EXIST(-14002,"该消息模板编码已经存在"),

    AI_MODEL_RESPONSE_EXCEPTION(-15001, "AI模型处理异常"),
    FILE_PDF_PNG_ERROR(-15002, "图片转换异常"),
    CATEGORY_TYPE_NOT_MATCH(-15002, "抱歉，您上传的单证类型无法识别！"),

    ;


    private final int value;

    private final String desc;


    ExceptionStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    /**
     * Return the integer value of this status code.
     */
    public int value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }

    /**
     * 枚举数据库存储值
     */
    @Override
    public Serializable getValue() {
        return value();
    }
}
