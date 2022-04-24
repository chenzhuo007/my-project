package com.cz.alipay.test;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AccountLogItemResult;
import com.alipay.api.request.AlipayDataBillAccountlogQueryRequest;
import com.alipay.api.response.AlipayDataBillAccountlogQueryResponse;
import com.cz.alipay.model.BillQueryDTO;
import com.cz.alipay.util.FastJsonUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <Description>：
 *
 * @author chenzhuo
 * @version 1.0
 * @date 2022/4/18
 */
public class AliPay {

    public static final String url_test = "https://openapi.alipaydev.com/gateway.do";

    public static final String url = "https://openapi.alipay.com/gateway.do";

    public static final String appId_test = "2021000119668800";


    public static final String publicKey =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwneyot64TOgCuHyEDZ6BfgeOGThJ4KbV4NlWN0MX84WLCWsTwjlhuaenhYCsTR9HLYehQTd0jBKJjL9CFIaVbtSvaHdjwk/djPS7dHrA3vRfBJrao7JX4txZRqQwkvpwM6P/61O3EI+PTSZRgRT/TKVPFX9/KrR5fZNbgRDKj1lRrr7AoB53Se8KE5xnTKjyvPzx3F8WO/ShHDRThoZMdukZwSzsOQfJLw8aLEr4XRXFQ7xV26IElNteXCm47JKcIIHtdY2rgjMKoWEfMX5GP4Bs9R3iYpgZqa/EgIfKwNIntfUjlAG8070ChXqcPEdMANJv/99ihlZGNDYWKR7mwwIDAQAB";
    public static final String privateKey =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCa6gvNGdh8CrtiyzuqzKSHqlpfshrD3JerTKBGTECsc0wFfNMNerxHYXsCxKTh78pCkeil/uolvvsVhTrD8hN88M1Ki+Ew9depQzy6eAu2MZFTEsnDsak+Enp2Y79FAiKFMvDmeuc5zqeHmRgLPN30jc79HTOitA8XFXtGc8jn0uS4TWrgbUpleeKD7PN/vQYKHjFUP5f7dk+sUy517oilAwG/sGj9hPkzYIhViE9DKyVAFw6h0dg9H0TqfTyPJfkdUK1dZfQ/wG8LPu9j8TmU7kRBpdYwZqLxytOGWaTuoKxyMPrPEDeyfV5w/1hnyzC7epFBerU5f861pCGNpSelAgMBAAECggEAbkKjf6ojsbYZxamNoHXjrUQM6wvjjQCXWy9A7IgdiCDQPR+pQHDZTZ0OZtv712xK87LSekPD+HXEVH7tYsYMJONn2uVQtP5mL21R7g6/l0AUhaJbxVPQeAPC8jzwyHdKhq/JUuKrbTOvfg3zVRxPhl7gsrt0IxwxmWaKxYxntMgDPbCgawe8tHxI5QXK4UOEES75eHlvopCWWOjomFxTuK5fSTJz0vSED5uhvDlggiBRZFcXK4JbmzIJLVsr5LRhgDFsojwintb7111eTrGF3FVg+SSqdnYyIHL1B3Wm8NtMQgFhpR+Tb5R5JBa1nlc8mDJ4x52ZQ44dwj1aWwjtwQKBgQDdVaBSMfXfAdpAHrIY3BmJCx8OPDjPaDWxA3rp1r2fZN52nOnHjBQmapWGYn8jkh00WgnNz2eKRmoS7tA7aY1vf8gaVonUikHJFjTJdxn31lnQlxpIAg+9qLNRkKpqsxCxF82FueHx+kI5Zs1zPg/O5MK7JPL7mwhUOgVFUy8ruQKBgQCzLU9m917B2SFbBTo9a4aRxTYzmCA0ODxd72S7/jUuMrUOuNK+K9wy5y1TaoogiA2w8nlqj7ykfgO048GtTLa+QSbnG2c7j7o8HGTbpfT3cl1dmdoopObV4dqXlKlMTs10NLKqB5MNtlf250ToX5DjSQTzTtJLDGtrVWq92AeJTQKBgQC0iLNMWBQE4q3yvxbl0CHD9p5OLjDofEfPKteHBPGGofATL8pASbHl4+oywwSRLw1DNm3owdPipay/5KtUyrPizoeZdBzYkC04qDRGYC9+SAjaa2W0dnoAaSpazXUzsvtad9/bw9LYXRjHWWMbLPQX/eAYZfsL31jb2reR5FgFgQKBgFemE5B/88eJ6so2vW2sOtD2EvScNyy0Ubt1zuYzjVpDDdTczqKenAH+mmqS1GzjgScNBh39oD8rMa78NxMKUt6wylIFUrONNIIRNblI7pNZS5jtGQ4G1LDN4fuCimq8pb5xxPBt8h6kE1XBfjDaButYHebTqQVzVtzTlPq3QcCFAoGACaabhfEc6+8zNPzhbQxVWeL3xMG2C/AuVUrQzJ5yk8I93u4HCgFXdy10Cwwr4vwhWGxddMoeKgA0qwpkaPDdv1hmzzMDVq9qgX/G9htfWVIpveiFyXsY7Icv4WVe1juLxFbziVBft56WKhC8KqylGjbT0LhFTVaQTpVDyhR+eOo=";

    public static final String appId = "2021003127608231";

    public static void main(String[] args) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(url, appId, privateKey, "json"
                , "utf-8", publicKey, "RSA2");
        BillQueryDTO billQueryDTO = new BillQueryDTO();
        billQueryDTO.setStartTime("2021-12-10 00:00:00");
        billQueryDTO.setEndTime("2022-01-04 00:00:00");
        AlipayDataBillAccountlogQueryRequest request = new AlipayDataBillAccountlogQueryRequest();
        request.setBizContent(FastJsonUtil.toJsonString(billQueryDTO));
        AlipayDataBillAccountlogQueryResponse response = alipayClient.execute(request);
        List<String> type =
                response.getDetailList().stream().map(AccountLogItemResult::getType).distinct().collect(Collectors.toList());
        List<String> d =
                response.getDetailList().stream().map(AccountLogItemResult::getDirection).distinct().collect(Collectors.toList());
        System.out.println(type);
        System.out.println(d);
    }
}
