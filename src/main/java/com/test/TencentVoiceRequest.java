/*
 * Copyright (c) 2014-2015 Huami, Inc. All Rights Reserved.
 */

package com.test;

import com.common.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class TencentVoiceRequest implements Serializable {
    private static final long serialVersionUID = 2748822558203200720L;

    /**
     * 当用户以文字或语音的形式与你的技能进行交互时，腾讯云叮当会给技能服务发送一个标准类型的请求（如：LaunchRequest、IntentRequest、SessionEndedRequest）。
     */
    private String type;

    /**
     * 当前请求的ID，用于唯一标识一次请求
     */
    private String requestId;

    /**
     * 用户请求时间戳，ISO 8601格式的UTC+0时间
     */
    private String timestamp;

    /**
     * 用户的Query
     */
    private String queryText;

    /**
     * 用于表示多轮对话状态的枚举值，包括：
     * STARTED：会话开始；
     * IN_PROGRESS：会话进行中；
     * COMPLETED：会话结束，只有在使用了Dialog.Delegate之后才能收到该类型的请求；
     */
    private String dialogState;

    /**
     * 用户的意图信息，包含意图名称及提取的参数信息，详细说明见intent
     */
    private Intent intent;

    /**
     * 会话结束的原因
     * - USER_INITIATED：用户主动退出
     * - ERROR：出现意外错误
     */
    private String reason;


    /**
     * 对错误信息的详细描述
     */
    private SessionError error;

    /**
     * 用户原意图，开发者可根据意图继续响应用户的请求，详细信息见Intent Object
     */
    private Intent sourceIntent;

    /**
     * 重试请求的一些关键信息，比如原支付指令的订单号，有：
     * PaymentMeta：支付指令的信息，详见RetryMeta；
     */
    private RetryMeta retryMeta;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor
    @NoArgsConstructor
    public class Intent implements Serializable {

        private static final long serialVersionUID = -7889025867901473146L;

        /**
         * 意图名
         */
        private String name;

        /**
         * 当前意图的确认状态，可选值有：
         * + NONE：未确认；
         * + CONFIRMED：已确认；
         * + DENIED：拒绝
         */
        private String confirmationStatus;

        /**
         * 槽位信息
         */
        private Slots slots;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @AllArgsConstructor
        @NoArgsConstructor
        public class Slots implements Serializable {

            private static final long serialVersionUID = 3970896507033434803L;

            private SlotName slotName;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @AllArgsConstructor
            @NoArgsConstructor
            public class SlotName {
                private static final long serialVersionUID = -3406603060122776674L;
                /**
                 * 参数名
                 */
                private String name;

                /**
                 * 当前参数的确认状态，可选值有：
                 * + NONE：未确认；
                 * + CONFIRMED：已确认；
                 * + DENIED：拒绝
                 */
                private String confirmationStatus;

                /**
                 * 该参数对应的值列表
                 */
                private List<Values> values;

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                @JsonInclude(JsonInclude.Include.NON_NULL)
                @AllArgsConstructor
                @NoArgsConstructor
                public class Values implements Serializable {

                    private static final long serialVersionUID = 2123424315962642464L;
                    /**
                     * 参数的值
                     */
                    private Value value;

                    @Data
                    @JsonIgnoreProperties(ignoreUnknown = true)
                    @JsonInclude(JsonInclude.Include.NON_NULL)
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public class Value implements Serializable {
                        private static final long serialVersionUID = 7077646279003034874L;
                        /**
                         * 参数值类型，可选值有：
                         * text：普通文本类型；
                         * unit：度量单位类型；
                         * address：地址类型；
                         * datetime：时间类型；
                         */
                        private String type;

                        /**
                         * 槽位的实体值
                         */
                        private String value;

                        /**
                         * 用户原始说法
                         */
                        private String origin;

                        /**
                         * 数值
                         */
                        private String amount;

                        /**
                         * 单位
                         */
                        private String unit;

                        /**
                         * 国家
                         */
                        private String country;

                        /**
                         * 省
                         */
                        private String province;

                        /**
                         * 城市
                         */
                        private String city;

                        /**
                         * 区/县
                         */
                        private String district;

                        /**
                         * 乡镇
                         */
                        private String town;

                        /**
                         * 村
                         */
                        private String village;

                        /**
                         * 地名
                         */
                        private String title;

                        /**
                         * 具体时间点表示
                         */
                        private Datetime datetime;

                        /**
                         * 日期，如“2018”，“2018-01”，“2018-01-01” 24小时制时间，如“23:59:59"
                         */
                        private Datetime start;

                        /**
                         * 日期，如“2018”，“2018-01”，“2018-01-01” 24小时制时间，如“23:59:59"
                         */
                        private Datetime end;

                        /**
                         * 循环单位，有以下几种类型：
                         * + YEAR：年
                         * + MONTH：月
                         * + WEEK：周
                         * + DAY：天
                         * + HOUR：小时
                         * + MINUTE：分钟
                         * + WORKDAY：工作日
                         * + WEEKEND：周末
                         */
                        private String repeatType;

                        @Data
                        @JsonIgnoreProperties(ignoreUnknown = true)
                        @JsonInclude(JsonInclude.Include.NON_NULL)
                        @AllArgsConstructor
                        @NoArgsConstructor
                        public class Datetime implements Serializable {
                            private static final long serialVersionUID = 3845944511634132987L;

                            /**
                             * 日期，如“2018”，“2018-01”，“2018-01-01”
                             */
                            private String date;

                            /**
                             * 24小时制时间，如“23:59:59"
                             */
                            private String time;
                        }
                    }
                }
            }
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor
    @NoArgsConstructor
    public class RetryMeta implements Serializable{
        private static final long serialVersionUID = -7889025867901473146L;

        /**
         * 固定为PaymentMeta
         */
        private String type;

        /**
         * 商户内部的订单ID（若商户提供）
         */
        private String partnerOrderId;

        /**
         * 叮当平台订单ID
         */
        private String dingdangOrderId;
    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor
    @NoArgsConstructor
    public class SessionError implements Serializable {
        private static final long serialVersionUID = 3262811041985072006L;

        /**
         * 错误类型，包括：
         * INVALID_RESPONSE：技能响应有问题
         * INTERNAL_ERROR：叮当内部错误
         */
        private String type;

        /**
         * 错误信息说明
         */
        private String message;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String s1 = "{\"name\":\"阿萨德\",\"confirmationStatus\":\"2332\"}";
        //Intent.Slots.SlotName slotName = objectMapper.readValue(s1,Intent.Slots.SlotName.class);


        Intent.Slots.SlotName slotName = (Intent.Slots.SlotName) JsonUtil.json2Object(s1,Intent.Slots.SlotName.class);
        System.out.println();
    }

}
