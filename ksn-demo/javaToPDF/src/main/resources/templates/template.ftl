<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"></link>
    <style type="text/css">
        body {
            font-family: 'Microsoft YaHei';
        }
        @page {
            size: A4;
        }
        .pdf {
            max-width: 80px!important;
        }
        .container {
            margin-left: 0;

        }
        tr td,
        th {
            border-collapse: collapse;
            border: 1px solid #000;
            border-style: dashed;
        }
        body {
            margin: 0;
        }
        .content {
            width: 820px;
            /*height: 1160px;*/
            margin: 0 auto;
            background-color: #006DCC;
        }
    </style>
</head>
<body class="content">
<div class="content">
<div align="center">
    <table align="center" style="width: 766px; max-height: 1228px;" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td style="width: 324px; height: 161px;">
                <div style="margin-top: 50px;margin-left: 21px;">
                    <font style="font-size: 24px;">快递包裹</font>
                    <br />
                    <font style="font-size: 54px;">收件人付费</font>
                    <br />
                    <font style="font-size: 16px;">时间:2021-06-03 23:59:59</font>
                </div>
            </td>
            <td>
                <img width="422" height="110"
                     src="file:///F:/idea-workspace/Demo/ksn-demo/javaToPDF/src/main/resources/static/img/a.jpg" />
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;height: 77px;">
                <font style="font-size: 43px;">191粤S-东莞-城区创业-009</font>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="height: 137px;">
                <div>
                    <font style="font-size: 30px;margin-left: 25px;">收:</font>
                    <font style="font-size: 30px;margin-left: 31px;">张琼丽</font>
                    <font style="font-size: 30px;margin-left: 31px;">13113337157</font>
                </div>
                <div>
                    <font style="font-size: 30px;margin-left: 91px;">东莞天祺电子科技有限公司</font>
                </div>
                <div>
                    <font style="font-size: 30px;margin-left: 91px;">广东省东莞市太大道篁村路段12号凯昌文化</font>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="height: 64px;">
                <div>
                    <font style="font-size: 22px;">寄:</font>
                    <font style="font-size: 22px;margin-left: 60px;">中国电子口岸数据中心黄埔分中心</font>
                    <font style="font-size: 22px;margin-left: 15px;">020-82130013</font>
                </div>
                <div>
                    <font style="font-size: 22px;margin-left: 86px;">广州市黄埔区志城大道327号(限制字数25)</font>
                </div>
            </td>
        </tr>
    </table>
    <table align="center" style="width: 766px;/* height: 1228px; */max-height: 1228px;" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td colspan="1" style="width: 409px;">
                <div style="margin-left: 26px;">
                    <div>
                        <font style="font-size: 21px;">计费重量:</font>
                        <font style="font-size: 21px;margin-left: 15px;">25</font>
                    </div>
                    <div>
                        <font style="font-size: 21px;">保价金额:</font>
                        <font style="font-size: 21px;margin-left: 15px;">25</font>
                    </div>
                    <div>
                        <font style="font-size: 24px;">收件人应付寄递费:</font>
                        <font style="font-size: 24px;margin-left: 15px;">¥25</font>
                    </div>
                    <div>
                        <font style="font-size: 24px;">大写:</font>
                        <font style="font-size: 24px;margin-left: 15px;">贰拾伍元整</font>
                    </div>
                </div>
            </td>
            <td colspan="1">
                <div style="margin-left: 22px;">
                    <div>
                        <font style="font-size: 22px;">收件人/代收人:</font>
                    </div>
                    <div>
                        <font style="font-size: 22px;">签收时间:</font>
                        <font style="font-size: 22px;margin-left: 60px;">年</font>
                        <font style="font-size: 22px;margin-left: 15px;">月</font>
                        <font style="font-size: 22px;margin-left: 15px;">日</font>
                        <font style="font-size: 22px;margin-left: 15px;">时</font>
                    </div>
                    <div>
                        <font style="font-size: 16px;">快件送达收货人地址，经过收件人或收件人允许的代收人签字，视为送达</font>
                    </div>
                </div>
            </td>
        </tr>
        <tr style="height: 137px;">
            <td colspan="2">
                <div style="margin-bottom: 44px;margin-left: 26px;">
                    <div>
                        <font style="font-size: 22px;">订单号:</font>
                        <img width="222" height="41"
                             src="${imgUrl}" />
                        <font style="font-size: 22px;margin-left: 125px;">件数:</font>
                        <font style="font-size: 22px;margin-left: 15px;">重量(KG)</font>
                    </div>
                    <div style="margin-top: 25px;">
                        <font style="font-size: 22px;">配货信息:</font>
                        <br />
                        <font style="font-size: 27px;margin-left: 112px;">电子口岸安全产品</font>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <div align="center" style="width: 766px;height:0px;border-top:1px black dashed;margin-top: 16px;"></div>
    <table align="center" style="margin-top: 16px;width: 766px;max-height: 1228px;" border="1"
           cellspacing="0" cellpadding="0">
        <tr style="height: 112px;">
            <td colspan="2">
                <img width="378" height="98" style="margin-left: 19px;"
                     src="${imgUrl}" />
                <img style="float: right;margin-right: 35px;" width="234" height="61"
                     src="${imgUrl}" />
            </td>
        </tr>
        <tr>
            <td colspan="1" style="width: 455px;height: 138px;">
                <div>
                    <div>
                        <font style="font-size: 22px;margin-left: 27px">收:</font>
                        <font style="font-size: 22px;margin-left: 26px;">张琼丽</font>
                        <font style="font-size: 22px;margin-left: 8px;">13113337157</font>
                    </div>
                    <div style="margin-left: 82px;">
                        <font style="font-size: 22px;">东莞天祺电子科技有限公司</font>
                    </div>
                    <div style="margin-left: 82px;">
                        <font style="font-size: 22px;">
                            广东省东莞市莞太大道纂村路段12号凯昌文化大厦3楼
                        </font>
                    </div>
                </div>
            </td>
            <td colspan="1">
                <div style="margin-left: 13px;">
                    <font style="font-size: 22px;">寄:</font>
                    <font style="font-size: 22px;">中*************心020 *****0013</font>
                </div>
                <div style="margin-left: 13px;">
                    <font style="font-size: 22px;">广洲市黄浦区志诚大道 327号</font>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="height: 137px;">
                <div style="margin-left: 26px;margin-bottom: 92px;">
                    <font style="font-size: 22px;">备注:</font>
                    <font style="font-size: 27px;margin-left: 17px;">中国邮政</font>
                </div>
            </td>
        </tr>
    </table>
    <table align="center" style="width: 766px;/* height: 1228px; */" border="1" cellspacing="0" cellpadding="0">
        <tr style="height: 68px;">
            <td colspan="1" style="width: 545px;">
              <span style="margin-left: 26px;">
                <font style="font-size: 22px;">网址:</font>
                <font style="font-size: 22px;">www.ems.com.cn</font>
              </span>
              <span style="margin-left: 70px;">
                <font style="font-size: 22px;">客服电话:</font>
                <font style="font-size: 22px;">11183</font>
              </span>
            </td>
            <td colspan="1" style="width: 220px;">

            </td>
        </tr>
    </table>
    <div align="center" style="width: 766px;height:0px;border-top:1px black dashed;margin-bottom: 19px;"></div>
    <table align="center" style="width: 766px;/* height: 1228px; */max-height: 1228px;" border="1" cellspacing="0"
           cellpadding="0">
        <tr style="height: 112px;">
            <td colspan="2">
                <img width="378" height="98" style="margin-left: 19px;"
                     src="${imgUrl}" />
                <img style="float: right;margin-right: 35px;" width="234" height="61"
                     src="${imgUrl}" />
            </td>
        </tr>
        <tr>
            <td colspan="1" style="width: 455px;height: 138px;">
                <div>
                    <div>
                        <font style="font-size: 22px;margin-left: 27px">收:</font>
                        <font style="font-size: 22px;margin-left: 26px;">张琼丽</font>
                        <font style="font-size: 22px;margin-left: 8px;">13113337157</font>
                    </div>
                    <div style="margin-left: 82px;">
                        <font style="font-size: 22px;">东莞天祺电子科技有限公司</font>
                    </div>
                    <div style="margin-left: 82px;">
                        <font style="font-size: 22px;">
                            广东省东莞市莞太大道纂村路段12号凯昌文化大厦3楼
                        </font>
                    </div>
                </div>
            </td>
            <td colspan="1">
                <div style="margin-left: 13px;">
                    <font style="font-size: 22px;">寄:</font>
                    <font style="font-size: 22px;">中*************心020 *****0013</font>
                </div>
                <div style="margin-left: 13px;">
                    <font style="font-size: 22px;">广洲市黄浦区志诚大道 327号</font>
                </div>
            </td>
        </tr>
        <tr style="height: 135px;">
            <td colspan="2">
                <div style="margin-bottom: 44px;margin-left: 26px;">
                    <div>
                        <font style="font-size: 22px;">订单号:</font>
                        <img width="222" height="41"
                             src="${imgUrl}" />
                        <font style="font-size: 22px;margin-left: 125px;">件数:</font>
                        <font style="font-size: 22px;margin-left: 15px;">重量(KG)</font>
                    </div>
                    <div style="margin-top: 25px;">
                        <font style="font-size: 22px;">配货信息:</font>
                        <br />
                        <font style="font-size: 27px;margin-left: 112px;">电子口岸安全产品</font>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <div align="center">
        <font>网址：www.ems.com.cn</font>
        <font style="margin-left: 30px;">客服电话：11183</font>
        <font style="margin-left: 30px;">2-23</font>
        <font style="margin-left: 30px;">L</font>
    </div>
</div>
</div>
</body>
</html>