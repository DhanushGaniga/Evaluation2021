package com.robosoft.evaluation.constants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "camelot.transaction")
@Data
public class AppSettings {
	
	private String axilloUniqueIdUrl;
	private String timeoutTrigger;
	private String uniqueApiKey;
	private String karvyUserId;
	private String karvyPassWord;
	private String axilloBaseUrl;
	private String smsUrl;
	private String smsXmlUrl;
	private String smsUserName;
	private String transConfirmationLink;
	private String communicationLinkResend;
	private String toMailId;
	private boolean sitEnv;
	private String bccMailId;
	private String emailFromNameValue;
	private String fromMailId;
	private boolean sendSms;
	private String mobileNumber;
	private String smsPassValue;
	private String smsTimeout;
	private String ifaProductSvcUrl;
	private boolean allowedAxis;
	
	//////
	    private String axisReturnUrl;
	    private String razorpayReturnUrl;
	    private String billdeskReturnUrl;
	    private String productApiUrl;
	    private String razorPayNonTpvSecretKey;
	    private String razorPaySecretKey;
	    private String razorPayBaseUrl;
	    private String razorPayBaseUrlNonTpv;
	    private String billdeskChecksumKey;
	    private String ifaPgSvcBaseUrl;
	    private String ifaGeneralSvcUrl;
	    private String merchantId;;
	    private String billdeskSecurityId;
	    private String currencyType;
	    private String upiMaximumLimit;
	    private String transConfirmationLinkTtlInHours;
	    private String ifaAuthSvcBaseUrl;
	    private String newInvTransConfirmationLink;//NEW_INV_TRANS_CONFIRMATION_LINK
	   ///// 
	    private String ifaOtpSvcBaseUrl;
	    private int tempSessionTimeoutInMins;
}
