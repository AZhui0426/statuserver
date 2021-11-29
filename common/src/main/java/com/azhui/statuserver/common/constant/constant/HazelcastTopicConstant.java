package com.azhui.statuserver.common.constant.constant;

/**
 * @author guomaofei
 * @date 2021/3/11 11:12
 */
public interface HazelcastTopicConstant {

    String DATA_SOURCE_TOPIC = "data_source_topic";

    String DATA_SOURCE_DRIVER_TOPIC = "data_source_driver_topic";

    String ADMIN_WEB_SOCKET_TOPIC = "adminSocketTopicConfig";

    String APPROVAL_WEB_SOCKET_TOPIC = "approvalWebSocketTopic";

    String APPLY_WEB_SOCKET_TOPIC = "applyWebSocketTopic";

    String NOTIFICATION_SOCKET_TOPIC = "notificationSocketTopic";

    /**
     * 缓存map_name
     */
    String SQL_XML_PARSING_MAP = "sql_xml_parsing_map";

    String SQL_XML_COLLECTION_MAP = "sql_xml_collection_map";

    String ROLE_APPROVAL_WEB_SOCKET_TOPIC = "roleApprovalWebSocketTopic";

    String USER_APPROVAL_WEB_SOCKET_TOPIC = "userApprovalWebSocketTopic";

    /**
     * 第三方调用interface缓存
     */
    String INTERFACE_CACHE_NAME = "interfaceCache";

    /**
     * 项目和数据源接口总数使用的缓存
     */
    String INTERFACE_STATISTIC_CACHE_NAME = "interfaceStatisticCache";

}
