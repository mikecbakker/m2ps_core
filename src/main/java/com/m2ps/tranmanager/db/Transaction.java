
package com.m2ps.tranmanager.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.m2ps.message.M2PSIsoMsg;


/**
 * Defines a Transaction.
 * 
 */
@Entity
@Table(name="transaction")
public class Transaction
{
	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tran_id")
	private long id;
	
	/* 0 - Msg Type */
	@Column(name="msg_type", nullable=false)
	private String msgType;
	
	/* 2 - PAN */
	@Column(name="pan", nullable=true)
	private String pan;
	
	/* 3 - Processing Code */
	@Column(name="proc_code", nullable=true)
	private String processingCode;
	
	/* 4 - Tran Amount */
	@Column(name="tran_amount", nullable=true)
	private String tranAmount;
	
	/* 5 - Settle Amount */
	@Column(name="settle_amount", nullable=true)
	private String settleAmount;
	
	/* 7 - Transmission Date & Time */
	@Column(name="tran_date_time", nullable=true)
	private String tranDateTime;
	
	/* 9 - Conversion Rate, Settlement */
	@Column(name="conv_rate_settle", nullable=true)
	private String conversionRateSettlement;
	
	/* 11 - System Trace Audit Number */
	@Column(name="stan", nullable=true)
	private String stan;
	
	/* 12 - Time, Local Transaction */
	@Column(name="time_local_tran", nullable=true)
	private String timeLocalTransaction;
	
	/* 13 - Date, Local Transaction */
	@Column(name="date_local_tran", nullable=true)
	private String dateLocalTransaction;
	
	/* 14 - Date, Expiration */
	@Column(name="date_expiration", nullable=true)
	private String dateExpiration;
	
	/* 15 - Date, Date Settlement */
	@Column(name="date_settlement", nullable=true)
	private String dateSettlement;
	
	/* 16 - Date, Conversion */
	@Column(name="date_conversion", nullable=true)
	private String dateConversion;
	
	/* 18 - Merchant Type */
	@Column(name="merchant_type", nullable=true)
	private String merchantType;
	
	/* 22 - POS Entry Mode */
	@Column(name="pos_entry_mode", nullable=true)
	private String posEntryMode;
	
	/* 23 - Card Sequence Number */
	@Column(name="card_seq_num", nullable=true)
	private String cardSequenceNumber;
	
	/* 25 - POS Condition Code */
	@Column(name="pos_cond_code", nullable=true)
	private String posConditionCode;
	
	/* 26 - POS PIN Capture Code */
	@Column(name="pos_pin_capture_code", nullable=true)
	private String posPinCaptureCode;
	
	/* 27 - Authorization ID Response */
	@Column(name="auth_id_rsp_length", nullable=true)
	private String authorizationIdResponseLength;
	
	/* 28 - Amount, Transaction Fee */
	@Column(name="amount_tran_fee", nullable=true)
	private String amountTransactionFee;
	
	/* 29 - Amount, Settlement Fee */
	@Column(name="amount_settle_fee", nullable=true)
	private String amountSettleFee;
	
	/* 30 - Amount, Settle Processing Fee */
	@Column(name="amount_settle_proc_fee", nullable=true)
	private String amountSettleProcFee;
	
	/* 32 - Acquiring Institution ID Code */
	@Column(name="acquiring_inst_id_code", nullable=true)
	private String acquiringInstitutionIdCode;
	
	/* 33 - Forwarding Institution ID Code */
	@Column(name="forwarding_inst_id_code", nullable=true)
	private String forwardingInstitutionIdCode;
	
	/* 35 - Track 2 Data */
	@Transient
	private String track2Data;
	
	/* 37 - Retrieval Reference Number */
	@Column(name="retrieval_ref_nr", nullable=true)
	private String retrievalReferenceNumber;
	
	/* 38 - Authorization ID Response Code */
	@Column(name="auth_id_rsp_code", nullable=true)
	private String authorizationIdResponseCode;
	
	/* 39 - Response Code */
	@Column(name="rsp_code", nullable=true)
	private String responseCode;
	
	/* 40 - Service Restriction Code */
	@Column(name="service_restriction_code", nullable=true)
	private String serviceRestrictionCode;
	
	/* 41 - Card Acceptor Terminal ID */
	@Column(name="ca_term_id", nullable=true)
	private String cardAcceptorTerminalId;
	
	/* 42 - Card Acceptor ID Code */
	@Column(name="ca_id_code", nullable=true)
	private String cardAcceptorIdCode;
	
	/* 43 - Card Acceptor Name Location */
	@Column(name="ca_name_loc", nullable=true)
	private String cardAcceptorNameLocation;
	
	/* 44 - Additional Response Data */
	@Column(name="additional_rsp_data", nullable=true)
	private String additionalResponseData;
	
	/* 45 - Track 1 Data */
	@Transient
	private String track1Data;
	
	/* 48 - Additional Data */
	@Column(name="additional_data", nullable=true)
	private String additionalData;
	
	/* 49 - Transaction, Currency Code */
	@Column(name="tran_currency_code", nullable=true)
	private String transactionCurrencyCode;
	
	/* 50 - Settlement, Currency Code */
	@Column(name="settle_currency_code", nullable=true)
	private String settleCurrencyCode;
	
	/* 52 - PIN Data */
	@Transient
	private String pinData;
	
	/* 53 - Security Related Control Information */
	@Transient
	private String securityRelatedControlInformation;
	
	/* 54 - Additional Amounts */
	@Column(name="additional_amounts", nullable=true)
	private String additionalAmounts;
	
	/* 56 - Message Reason Code */
	@Column(name="message_reason_code", nullable=true)
	private String messageReasonCode;
	
	/* 57 - Authentication Life-cycle Code */
	@Column(name="authentication_lifecycle_code", nullable=true)
	private String authenticationLifeCycleCode;
	
	/* 58 - Authorizing Agent Institution */
	@Column(name="auth_agent_inst", nullable=true)
	private String authorizingAgentInstitution;
	
	/* 59 - Echo Data */
	@Column(name="echo_data", nullable=true)
	private String echoData;
	
	/* 66 - Settlement Code */
	@Column(name="settlement_code", nullable=true)
	private String settlementCode;
	
	/* 67 - Extended Payment Code*/
	@Column(name="extended_payment_code", nullable=true)
	private String extendedPaymentCode;
	
	/* 70 - Network Management Information Code */
	@Column(name="net_manage_inf_code", nullable=true)
	private String networkManagementInformationCode;
	
	/* 73 - Date, Action */
	@Column(name="date_action", nullable=true)
	private String dateAction;
	
	/* 74 - Credits, Number */
	@Column(name="credits_number", nullable=true)
	private String creditsNumber;
	
	/* 75 - Credits, Reversal Number */
	@Column(name="credits_rev_number", nullable=true)
	private String creditsReversalNumber;
	
	/* 76 - Debits, Number */
	@Column(name="debits_number", nullable=true)
	private String debitsNumber;
	
	/* 77 - Debits, Reversal Number */
	@Column(name="debits_rev_number", nullable=true)
	private String debitsReversalNumber;
	
	/* 78 - Transfer, Number */
	@Column(name="transfer_number", nullable=true)
	private String transferNumber;
	
	/* 79 - Transfer, Reversal Number */
	@Column(name="transfer_rev_number", nullable=true)
	private String transferReversalNumber;
	
	/* 80 - Inquiries, Number */
	@Column(name="inquiries_number", nullable=true)
	private String inquiriesNumber;
	
	/* 81 - Authorizations, Number */
	@Column(name="authorizations_number", nullable=true)
	private String authorizationsNumber;
	
	/* 90 - Original Data Elements */
	@Column(name="orig_data_elements", nullable=true)
	private String originalDataElements;
	
	/* 91 - File Update Code */
	@Column(name="file_update_code", nullable=true)
	private String fileUpdateCode;
	
	/* 95 - Replacement Amounts */
	@Column(name="replacement_amounts", nullable=true)
	private String replacementAmounts;

	/* 97 - Amount, Net Settle */
	@Column(name="amount_net_settle", nullable=true)
	private String amountNetSettle;
	
	/* 98 - Payee */
	@Column(name="payee", nullable=true)
	private String payee;
	
	/* 100 - Receiving Institution ID Code */
	@Column(name="recv_inst_id_code", nullable=true)
	private String receivingInstitutionIdCode;
	
	/* 101 - File Name*/
	@Column(name="file_name", nullable=true)
	private String fileName;
	
	/* 102 - Account Identification 1 */
	@Column(name="account_id1", nullable=true)
	private String accountIdentification1;
	
	/* 103 - Account Identification 2 */
	@Column(name="account_id2", nullable=true)
	private String accountIdentification2;
	
	/* 123 - POS Data Code */
	@Column(name="pos_data_code", nullable=true)
	private String posDataCode;
	
	/*-----------------------------------------------------------------------------------------------------------------*/
	/**
	 * Constructs a new <code>Transaction</code> instance.
	 * @throws ISOException 
	 */
	public Transaction(ISOMsg m2psIsoMsg) throws ISOException
	{
		setMsgType(m2psIsoMsg.getMTI());
		setProcessingCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._003_PROCESING_CODE));
		setTranAmount(m2psIsoMsg.getString(M2PSIsoMsg.Bit._004_AMOUNT_TRAN));
		setSettleAmount(m2psIsoMsg.getString(M2PSIsoMsg.Bit._005_AMOUNT_SETTLE));
		setTranDateTime(m2psIsoMsg.getString(M2PSIsoMsg.Bit._007_TRANSMISSION_DATE_TIME));
		setConversionRateSettlement(m2psIsoMsg.getString(M2PSIsoMsg.Bit._009_CONVERSION_RATE_SETTLE));
		setStan(m2psIsoMsg.getString(M2PSIsoMsg.Bit._011_SYSTEM_TRACE_AUDIT_NR));
		setTimeLocalTransaction(m2psIsoMsg.getString(M2PSIsoMsg.Bit._012_TIME_LOCAL_TRANSACTION));
		setDateLocalTransaction(m2psIsoMsg.getString(M2PSIsoMsg.Bit._013_DATE_LOCAL_TRANSACTION));
		/* TODO PA-DSS Field 14 be persisted? */
		setDateSettlement(m2psIsoMsg.getString(M2PSIsoMsg.Bit._015_DATE_SETTLEMENT));
		setDateConversion(m2psIsoMsg.getString(M2PSIsoMsg.Bit._016_DATE_CONVERSION));
		setMerchantType(m2psIsoMsg.getString(M2PSIsoMsg.Bit._018_MERCHANT_TYPE));
		setPosEntryMode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._022_POS_ENTRY_MODE));
		/* TODO PA-DSS Field 23 be persisted? */
		setPosConditionCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._025_POS_CONDITION_CODE));
		setPosPinCaptureCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._026_POS_PIN_CAPTURE_CODE));
		setAuthorizationIdResponseLength(m2psIsoMsg.getString(M2PSIsoMsg.Bit._027_AUTHORIZATION_ID_RESPONSE_LENGTH));
		setAmountTransactionFee(m2psIsoMsg.getString(M2PSIsoMsg.Bit._028_AMOUNT_TRANSACTION_FEE));
		setAmountSettleFee(m2psIsoMsg.getString(M2PSIsoMsg.Bit._029_AMOUNT_SETTLE_FEE));
		setAmountSettleProcFee(m2psIsoMsg.getString(M2PSIsoMsg.Bit._030_AMOUNT_TRANSACTION_PROCESSING_FEE));
		setAmountSettleProcFee(m2psIsoMsg.getString(M2PSIsoMsg.Bit._031_AMOUNT_SETTLE_PROCESSING_FEE));
		setAcquiringInstitutionIdCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._032_ACQUIRING_INSTITUTION_ID_CODE));
		setForwardingInstitutionIdCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._033_FORWARDING_INSTITUTION_ID_CODE));
		setRetrievalReferenceNumber(m2psIsoMsg.getString(M2PSIsoMsg.Bit._037_RETRIEVAL_REFERENCE_NUMBER));
		setAuthorizationIdResponseCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._038_AUTHORIZATION_ID_RESPONSE));
		setResponseCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._039_RESPONSE_CODE));
		/* TODO PA-DSS Field 40 be persisted? */
		setCardAcceptorTerminalId(m2psIsoMsg.getString(M2PSIsoMsg.Bit._041_CARD_ACCEPTOR_TERMINAL_ID));
		setCardAcceptorIdCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._042_CARD_ACCEPTOR_ID_CODE));
		setCardAcceptorNameLocation(m2psIsoMsg.getString(M2PSIsoMsg.Bit._043_CARD_ACCEPTOR_NAME_LOCATION));
		setAdditionalResponseData(m2psIsoMsg.getString(M2PSIsoMsg.Bit._044_ADDITIONAL_RESPONSE_DATA));
		/* TODO 48 can often contain key info - might not persist */
		setAdditionalData(m2psIsoMsg.getString(M2PSIsoMsg.Bit._048_ADDITIONAL_DATA));
		setTransactionCurrencyCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._049_CURRENCY_CODE_TRANSACTION));
		setSettleCurrencyCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._050_CURRENCY_CODE_SETTLE));
		setAdditionalAmounts(m2psIsoMsg.getString(M2PSIsoMsg.Bit._054_ADDITIONAL_AMOUNTS));
		setMessageReasonCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._056_MESSAGE_REASON_CODE));
		setAuthenticationLifeCycleCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._057_AUTHORIZATION_LIFE_CYCLE_CODE));
		setAuthorizingAgentInstitution(m2psIsoMsg.getString(M2PSIsoMsg.Bit._058_AUTHORIZING_AGENT_INSTITUTION));
		setEchoData(m2psIsoMsg.getString(M2PSIsoMsg.Bit._059_ECHO_DATA));
		setSettlementCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._066_SETTLEMENT_CODE));
		setExtendedPaymentCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._067_EXTENDED_PAYMENT_CODE));
		setNetworkManagementInformationCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._070_NETWORK_MANAGEMENT_INFORMATION_CODE));
		setOriginalDataElements(m2psIsoMsg.getString(M2PSIsoMsg.Bit._090_ORIGINAL_DATA_ELEMENTS));
		setFileUpdateCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._091_FILE_UPDATE_CODE));
		setReplacementAmounts(m2psIsoMsg.getString(M2PSIsoMsg.Bit._095_REPLACEMENT_AMOUNTS));
		setAmountNetSettle(m2psIsoMsg.getString(M2PSIsoMsg.Bit._097_AMOUNT_NET_SETTLE));
		setPayee(m2psIsoMsg.getString(M2PSIsoMsg.Bit._098_PAYEE));
		setReceivingInstitutionIdCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._0100_RECEIVING_INSTITUTION_ID_CODE));
		setFileName(m2psIsoMsg.getString(M2PSIsoMsg.Bit._101_FILE_NAME));
		setAccountIdentification1(m2psIsoMsg.getString(M2PSIsoMsg.Bit._102_ACCOUNT_IDENTIFICATION_1));
		setAccountIdentification2(m2psIsoMsg.getString(M2PSIsoMsg.Bit._103_ACCOUNT_IDENTIFICATION_2));
		setPosDataCode(m2psIsoMsg.getString(M2PSIsoMsg.Bit._123_POS_DATA_CODE));
	}
	
	/**
	 * Returns the id.
	 *
	 * @return the id.
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * Returns the msgType.
	 *
	 * @return the msgType.
	 */
	public String getMsgType()
	{
		return msgType;
	}

	/**
	 * Sets the msgType.
	 *
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}

	/**
	 * Returns the pan.
	 *
	 * @return the pan.
	 */
	public String getPan()
	{
		return pan;
	}

	/**
	 * Sets the pan.
	 *
	 * @param pan the pan to set
	 */
	public void setPan(String pan)
	{
		this.pan = pan;
	}

	/**
	 * Returns the processingCode.
	 *
	 * @return the processingCode.
	 */
	public String getProcessingCode()
	{
		return processingCode;
	}

	/**
	 * Sets the processingCode.
	 *
	 * @param processingCode the processingCode to set
	 */
	public void setProcessingCode(String processingCode)
	{
		this.processingCode = processingCode;
	}

	/**
	 * Returns the tranAmount.
	 *
	 * @return the tranAmount.
	 */
	public String getTranAmount()
	{
		return tranAmount;
	}

	/**
	 * Sets the tranAmount.
	 *
	 * @param tranAmount the tranAmount to set
	 */
	public void setTranAmount(String tranAmount)
	{
		this.tranAmount = tranAmount;
	}

	/**
	 * Returns the settleAmount.
	 *
	 * @return the settleAmount.
	 */
	public String getSettleAmount()
	{
		return settleAmount;
	}

	/**
	 * Sets the settleAmount.
	 *
	 * @param settleAmount the settleAmount to set
	 */
	public void setSettleAmount(String settleAmount)
	{
		this.settleAmount = settleAmount;
	}

	/**
	 * Returns the tranDateTime.
	 *
	 * @return the tranDateTime.
	 */
	public String getTranDateTime()
	{
		return tranDateTime;
	}

	/**
	 * Sets the tranDateTime.
	 *
	 * @param tranDateTime the tranDateTime to set
	 */
	public void setTranDateTime(String tranDateTime)
	{
		this.tranDateTime = tranDateTime;
	}

	/**
	 * Returns the conversionRateSettlement.
	 *
	 * @return the conversionRateSettlement.
	 */
	public String getConversionRateSettlement()
	{
		return conversionRateSettlement;
	}

	/**
	 * Sets the conversionRateSettlement.
	 *
	 * @param conversionRateSettlement the conversionRateSettlement to set
	 */
	public void setConversionRateSettlement(String conversionRateSettlement)
	{
		this.conversionRateSettlement = conversionRateSettlement;
	}

	/**
	 * Returns the stan.
	 *
	 * @return the stan.
	 */
	public String getStan()
	{
		return stan;
	}

	/**
	 * Sets the stan.
	 *
	 * @param stan the stan to set
	 */
	public void setStan(String stan)
	{
		this.stan = stan;
	}

	/**
	 * Returns the timeLocalTransaction.
	 *
	 * @return the timeLocalTransaction.
	 */
	public String getTimeLocalTransaction()
	{
		return timeLocalTransaction;
	}

	/**
	 * Sets the timeLocalTransaction.
	 *
	 * @param timeLocalTransaction the timeLocalTransaction to set
	 */
	public void setTimeLocalTransaction(String timeLocalTransaction)
	{
		this.timeLocalTransaction = timeLocalTransaction;
	}

	/**
	 * Returns the dateLocalTransaction.
	 *
	 * @return the dateLocalTransaction.
	 */
	public String getDateLocalTransaction()
	{
		return dateLocalTransaction;
	}

	/**
	 * Sets the dateLocalTransaction.
	 *
	 * @param dateLocalTransaction the dateLocalTransaction to set
	 */
	public void setDateLocalTransaction(String dateLocalTransaction)
	{
		this.dateLocalTransaction = dateLocalTransaction;
	}

	/**
	 * Returns the dateExpiration.
	 *
	 * @return the dateExpiration.
	 */
	public String getDateExpiration()
	{
		return dateExpiration;
	}

	/**
	 * Sets the dateExpiration.
	 *
	 * @param dateExpiration the dateExpiration to set
	 */
	public void setDateExpiration(String dateExpiration)
	{
		this.dateExpiration = dateExpiration;
	}

	/**
	 * Returns the dateSettlement.
	 *
	 * @return the dateSettlement.
	 */
	public String getDateSettlement()
	{
		return dateSettlement;
	}

	/**
	 * Sets the dateSettlement.
	 *
	 * @param dateSettlement the dateSettlement to set
	 */
	public void setDateSettlement(String dateSettlement)
	{
		this.dateSettlement = dateSettlement;
	}

	/**
	 * Returns the dateConversion.
	 *
	 * @return the dateConversion.
	 */
	public String getDateConversion()
	{
		return dateConversion;
	}

	/**
	 * Sets the dateConversion.
	 *
	 * @param dateConversion the dateConversion to set
	 */
	public void setDateConversion(String dateConversion)
	{
		this.dateConversion = dateConversion;
	}

	/**
	 * Returns the merchantType.
	 *
	 * @return the merchantType.
	 */
	public String getMerchantType()
	{
		return merchantType;
	}

	/**
	 * Sets the merchantType.
	 *
	 * @param merchantType the merchantType to set
	 */
	public void setMerchantType(String merchantType)
	{
		this.merchantType = merchantType;
	}

	/**
	 * Returns the pos_entry_mode.
	 *
	 * @return the pos_entry_mode.
	 */
	public String getPosEntryMode()
	{
		return posEntryMode;
	}

	/**
	 * Sets the pos_entry_mode.
	 *
	 * @param posEntryMode the pos_entry_mode to set
	 */
	public void setPosEntryMode(String posEntryMode)
	{
		this.posEntryMode = posEntryMode;
	}

	/**
	 * Returns the cardSequenceNumber.
	 *
	 * @return the cardSequenceNumber.
	 */
	public String getCardSequenceNumber()
	{
		return cardSequenceNumber;
	}

	/**
	 * Sets the cardSequenceNumber.
	 *
	 * @param cardSequenceNumber the cardSequenceNumber to set
	 */
	public void setCardSequenceNumber(String cardSequenceNumber)
	{
		this.cardSequenceNumber = cardSequenceNumber;
	}

	/**
	 * Returns the posConditionCode.
	 *
	 * @return the posConditionCode.
	 */
	public String getPosConditionCode()
	{
		return posConditionCode;
	}

	/**
	 * Sets the posConditionCode.
	 *
	 * @param posConditionCode the posConditionCode to set
	 */
	public void setPosConditionCode(String posConditionCode)
	{
		this.posConditionCode = posConditionCode;
	}

	/**
	 * Returns the posPinCaptureCode.
	 *
	 * @return the posPinCaptureCode.
	 */
	public String getPosPinCaptureCode()
	{
		return posPinCaptureCode;
	}

	/**
	 * Sets the posPinCaptureCode.
	 *
	 * @param posPinCaptureCode the posPinCaptureCode to set
	 */
	public void setPosPinCaptureCode(String posPinCaptureCode)
	{
		this.posPinCaptureCode = posPinCaptureCode;
	}

	/**
	 * Returns the auth_id_rsp.
	 *
	 * @return the auth_id_rsp.
	 */
	public String getAuthorizationIdResponseLength()
	{
		return authorizationIdResponseLength;
	}

	/**
	 * Sets the auth_id_rsp.
	 *
	 * @param authorizationIdResponseLength the auth_id_rsp to set
	 */
	public void setAuthorizationIdResponseLength(String authorizationIdResponseLength)
	{
		this.authorizationIdResponseLength = authorizationIdResponseLength;
	}

	/**
	 * Returns the amountTransactionFee.
	 *
	 * @return the amountTransactionFee.
	 */
	public String getAmountTransactionFee()
	{
		return amountTransactionFee;
	}

	/**
	 * Sets the amountTransactionFee.
	 *
	 * @param amountTransactionFee the amountTransactionFee to set
	 */
	public void setAmountTransactionFee(String amountTransactionFee)
	{
		this.amountTransactionFee = amountTransactionFee;
	}

	/**
	 * Returns the amountSettleFee.
	 *
	 * @return the amountSettleFee.
	 */
	public String getAmountSettleFee()
	{
		return amountSettleFee;
	}

	/**
	 * Sets the amountSettleFee.
	 *
	 * @param amountSettleFee the amountSettleFee to set
	 */
	public void setAmountSettleFee(String amountSettleFee)
	{
		this.amountSettleFee = amountSettleFee;
	}

	/**
	 * Returns the amountSettleProcFee.
	 *
	 * @return the amountSettleProcFee.
	 */
	public String getAmountSettleProcFee()
	{
		return amountSettleProcFee;
	}

	/**
	 * Sets the amountSettleProcFee.
	 *
	 * @param amountSettleProcFee the amountSettleProcFee to set
	 */
	public void setAmountSettleProcFee(String amountSettleProcFee)
	{
		this.amountSettleProcFee = amountSettleProcFee;
	}

	/**
	 * Returns the acquiringInstitutionIdCode.
	 *
	 * @return the acquiringInstitutionIdCode.
	 */
	public String getAcquiringInstitutionIdCode()
	{
		return acquiringInstitutionIdCode;
	}

	/**
	 * Sets the acquiringInstitutionIdCode.
	 *
	 * @param acquiringInstitutionIdCode the acquiringInstitutionIdCode to set
	 */
	public void setAcquiringInstitutionIdCode(String acquiringInstitutionIdCode)
	{
		this.acquiringInstitutionIdCode = acquiringInstitutionIdCode;
	}

	/**
	 * Returns the forwardingInstitutionIdCode.
	 *
	 * @return the forwardingInstitutionIdCode.
	 */
	public String getForwardingInstitutionIdCode()
	{
		return forwardingInstitutionIdCode;
	}

	/**
	 * Sets the forwardingInstitutionIdCode.
	 *
	 * @param forwardingInstitutionIdCode the forwardingInstitutionIdCode to set
	 */
	public void setForwardingInstitutionIdCode(String forwardingInstitutionIdCode)
	{
		this.forwardingInstitutionIdCode = forwardingInstitutionIdCode;
	}

	/**
	 * Returns the track2Data.
	 *
	 * @return the track2Data.
	 */
	public String getTrack2Data()
	{
		return track2Data;
	}

	/**
	 * Sets the track2Data.
	 *
	 * @param track2Data the track2Data to set
	 */
	public void setTrack2Data(String track2Data)
	{
		this.track2Data = track2Data;
	}

	/**
	 * Returns the retrievalReferenceNumber.
	 *
	 * @return the retrievalReferenceNumber.
	 */
	public String getRetrievalReferenceNumber()
	{
		return retrievalReferenceNumber;
	}

	/**
	 * Sets the retrievalReferenceNumber.
	 *
	 * @param retrievalReferenceNumber the retrievalReferenceNumber to set
	 */
	public void setRetrievalReferenceNumber(String retrievalReferenceNumber)
	{
		this.retrievalReferenceNumber = retrievalReferenceNumber;
	}

	/**
	 * Returns the authorizationIdResponseCode.
	 *
	 * @return the authorizationIdResponseCode.
	 */
	public String getAuthorizationIdResponseCode()
	{
		return authorizationIdResponseCode;
	}

	/**
	 * Sets the authorizationIdResponseCode.
	 *
	 * @param authorizationIdResponseCode the authorizationIdResponseCode to set
	 */
	public void setAuthorizationIdResponseCode(String authorizationIdResponseCode)
	{
		this.authorizationIdResponseCode = authorizationIdResponseCode;
	}

	/**
	 * Returns the responseCode.
	 *
	 * @return the responseCode.
	 */
	public String getResponseCode()
	{
		return responseCode;
	}

	/**
	 * Sets the responseCode.
	 *
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode)
	{
		this.responseCode = responseCode;
	}

	/**
	 * Returns the serviceRestrictionCode.
	 *
	 * @return the serviceRestrictionCode.
	 */
	public String getServiceRestrictionCode()
	{
		return serviceRestrictionCode;
	}

	/**
	 * Sets the serviceRestrictionCode.
	 *
	 * @param serviceRestrictionCode the serviceRestrictionCode to set
	 */
	public void setServiceRestrictionCode(String serviceRestrictionCode)
	{
		this.serviceRestrictionCode = serviceRestrictionCode;
	}

	/**
	 * Returns the cardAcceptorTerminalId.
	 *
	 * @return the cardAcceptorTerminalId.
	 */
	public String getCardAcceptorTerminalId()
	{
		return cardAcceptorTerminalId;
	}

	/**
	 * Sets the cardAcceptorTerminalId.
	 *
	 * @param cardAcceptorTerminalId the cardAcceptorTerminalId to set
	 */
	public void setCardAcceptorTerminalId(String cardAcceptorTerminalId)
	{
		this.cardAcceptorTerminalId = cardAcceptorTerminalId;
	}

	/**
	 * Returns the cardAcceptorIdCode.
	 *
	 * @return the cardAcceptorIdCode.
	 */
	public String getCardAcceptorIdCode()
	{
		return cardAcceptorIdCode;
	}

	/**
	 * Sets the cardAcceptorIdCode.
	 *
	 * @param cardAcceptorIdCode the cardAcceptorIdCode to set
	 */
	public void setCardAcceptorIdCode(String cardAcceptorIdCode)
	{
		this.cardAcceptorIdCode = cardAcceptorIdCode;
	}

	/**
	 * Returns the cardAcceptorNameLocation.
	 *
	 * @return the cardAcceptorNameLocation.
	 */
	public String getCardAcceptorNameLocation()
	{
		return cardAcceptorNameLocation;
	}

	/**
	 * Sets the cardAcceptorNameLocation.
	 *
	 * @param cardAcceptorNameLocation the cardAcceptorNameLocation to set
	 */
	public void setCardAcceptorNameLocation(String cardAcceptorNameLocation)
	{
		this.cardAcceptorNameLocation = cardAcceptorNameLocation;
	}

	/**
	 * Returns the additionalResponseData.
	 *
	 * @return the additionalResponseData.
	 */
	public String getAdditionalResponseData()
	{
		return additionalResponseData;
	}

	/**
	 * Sets the additionalResponseData.
	 *
	 * @param additionalResponseData the additionalResponseData to set
	 */
	public void setAdditionalResponseData(String additionalResponseData)
	{
		this.additionalResponseData = additionalResponseData;
	}

	/**
	 * Returns the track1Data.
	 *
	 * @return the track1Data.
	 */
	public String getTrack1Data()
	{
		return track1Data;
	}

	/**
	 * Sets the track1Data.
	 *
	 * @param track1Data the track1Data to set
	 */
	public void setTrack1Data(String track1Data)
	{
		this.track1Data = track1Data;
	}

	/**
	 * Returns the additionalData.
	 *
	 * @return the additionalData.
	 */
	public String getAdditionalData()
	{
		return additionalData;
	}

	/**
	 * Sets the additionalData.
	 *
	 * @param additionalData the additionalData to set
	 */
	public void setAdditionalData(String additionalData)
	{
		this.additionalData = additionalData;
	}

	/**
	 * Returns the transactionCurrencyCode.
	 *
	 * @return the transactionCurrencyCode.
	 */
	public String getTransactionCurrencyCode()
	{
		return transactionCurrencyCode;
	}

	/**
	 * Sets the transactionCurrencyCode.
	 *
	 * @param transactionCurrencyCode the transactionCurrencyCode to set
	 */
	public void setTransactionCurrencyCode(String transactionCurrencyCode)
	{
		this.transactionCurrencyCode = transactionCurrencyCode;
	}

	/**
	 * Returns the settleCurrencyCode.
	 *
	 * @return the settleCurrencyCode.
	 */
	public String getSettleCurrencyCode()
	{
		return settleCurrencyCode;
	}

	/**
	 * Sets the settleCurrencyCode.
	 *
	 * @param settleCurrencyCode the settleCurrencyCode to set
	 */
	public void setSettleCurrencyCode(String settleCurrencyCode)
	{
		this.settleCurrencyCode = settleCurrencyCode;
	}

	/**
	 * Returns the pinData.
	 *
	 * @return the pinData.
	 */
	public String getPinData()
	{
		return pinData;
	}

	/**
	 * Sets the pinData.
	 *
	 * @param pinData the pinData to set
	 */
	public void setPinData(String pinData)
	{
		this.pinData = pinData;
	}

	/**
	 * Returns the securityRelatedControlInformation.
	 *
	 * @return the securityRelatedControlInformation.
	 */
	public String getSecurityRelatedControlInformation()
	{
		return securityRelatedControlInformation;
	}

	/**
	 * Sets the securityRelatedControlInformation.
	 *
	 * @param securityRelatedControlInformation the securityRelatedControlInformation to set
	 */
	public void setSecurityRelatedControlInformation(String securityRelatedControlInformation)
	{
		this.securityRelatedControlInformation = securityRelatedControlInformation;
	}

	/**
	 * Returns the additionalAmounts.
	 *
	 * @return the additionalAmounts.
	 */
	public String getAdditionalAmounts()
	{
		return additionalAmounts;
	}

	/**
	 * Sets the additionalAmounts.
	 *
	 * @param additionalAmounts the additionalAmounts to set
	 */
	public void setAdditionalAmounts(String additionalAmounts)
	{
		this.additionalAmounts = additionalAmounts;
	}

	/**
	 * Returns the messageReasonCode.
	 *
	 * @return the messageReasonCode.
	 */
	public String getMessageReasonCode()
	{
		return messageReasonCode;
	}

	/**
	 * Sets the messageReasonCode.
	 *
	 * @param messageReasonCode the messageReasonCode to set
	 */
	public void setMessageReasonCode(String messageReasonCode)
	{
		this.messageReasonCode = messageReasonCode;
	}

	/**
	 * Returns the authenticationLifeCycleCode.
	 *
	 * @return the authenticationLifeCycleCode.
	 */
	public String getAuthenticationLifeCycleCode()
	{
		return authenticationLifeCycleCode;
	}

	/**
	 * Sets the authenticationLifeCycleCode.
	 *
	 * @param authenticationLifeCycleCode the authenticationLifeCycleCode to set
	 */
	public void setAuthenticationLifeCycleCode(String authenticationLifeCycleCode)
	{
		this.authenticationLifeCycleCode = authenticationLifeCycleCode;
	}

	/**
	 * Returns the authorizingAgentInstitution.
	 *
	 * @return the authorizingAgentInstitution.
	 */
	public String getAuthorizingAgentInstitution()
	{
		return authorizingAgentInstitution;
	}

	/**
	 * Sets the authorizingAgentInstitution.
	 *
	 * @param authorizingAgentInstitution the authorizingAgentInstitution to set
	 */
	public void setAuthorizingAgentInstitution(String authorizingAgentInstitution)
	{
		this.authorizingAgentInstitution = authorizingAgentInstitution;
	}

	/**
	 * Returns the echoData.
	 *
	 * @return the echoData.
	 */
	public String getEchoData()
	{
		return echoData;
	}

	/**
	 * Sets the echoData.
	 *
	 * @param echoData the echoData to set
	 */
	public void setEchoData(String echoData)
	{
		this.echoData = echoData;
	}

	/**
	 * Returns the settlementCode.
	 *
	 * @return the settlementCode.
	 */
	public String getSettlementCode()
	{
		return settlementCode;
	}

	/**
	 * Sets the settlementCode.
	 *
	 * @param settlementCode the settlementCode to set
	 */
	public void setSettlementCode(String settlementCode)
	{
		this.settlementCode = settlementCode;
	}

	/**
	 * Returns the extendedPaymentCode.
	 *
	 * @return the extendedPaymentCode.
	 */
	public String getExtendedPaymentCode()
	{
		return extendedPaymentCode;
	}

	/**
	 * Sets the extendedPaymentCode.
	 *
	 * @param extendedPaymentCode the extendedPaymentCode to set
	 */
	public void setExtendedPaymentCode(String extendedPaymentCode)
	{
		this.extendedPaymentCode = extendedPaymentCode;
	}

	/**
	 * Returns the networkManagementInformationCode.
	 *
	 * @return the networkManagementInformationCode.
	 */
	public String getNetworkManagementInformationCode()
	{
		return networkManagementInformationCode;
	}

	/**
	 * Sets the networkManagementInformationCode.
	 *
	 * @param networkManagementInformationCode the networkManagementInformationCode to set
	 */
	public void setNetworkManagementInformationCode(String networkManagementInformationCode)
	{
		this.networkManagementInformationCode = networkManagementInformationCode;
	}

	/**
	 * Returns the dateAction.
	 *
	 * @return the dateAction.
	 */
	public String getDateAction()
	{
		return dateAction;
	}

	/**
	 * Sets the dateAction.
	 *
	 * @param dateAction the dateAction to set
	 */
	public void setDateAction(String dateAction)
	{
		this.dateAction = dateAction;
	}

	/**
	 * Returns the creditsNumber.
	 *
	 * @return the creditsNumber.
	 */
	public String getCreditsNumber()
	{
		return creditsNumber;
	}

	/**
	 * Sets the creditsNumber.
	 *
	 * @param creditsNumber the creditsNumber to set
	 */
	public void setCreditsNumber(String creditsNumber)
	{
		this.creditsNumber = creditsNumber;
	}

	/**
	 * Returns the creditsReversalNumber.
	 *
	 * @return the creditsReversalNumber.
	 */
	public String getCreditsReversalNumber()
	{
		return creditsReversalNumber;
	}

	/**
	 * Sets the creditsReversalNumber.
	 *
	 * @param creditsReversalNumber the creditsReversalNumber to set
	 */
	public void setCreditsReversalNumber(String creditsReversalNumber)
	{
		this.creditsReversalNumber = creditsReversalNumber;
	}

	/**
	 * Returns the debitsNumber.
	 *
	 * @return the debitsNumber.
	 */
	public String getDebitsNumber()
	{
		return debitsNumber;
	}

	/**
	 * Sets the debitsNumber.
	 *
	 * @param debitsNumber the debitsNumber to set
	 */
	public void setDebitsNumber(String debitsNumber)
	{
		this.debitsNumber = debitsNumber;
	}

	/**
	 * Returns the debitsReversalNumber.
	 *
	 * @return the debitsReversalNumber.
	 */
	public String getDebitsReversalNumber()
	{
		return debitsReversalNumber;
	}

	/**
	 * Sets the debitsReversalNumber.
	 *
	 * @param debitsReversalNumber the debitsReversalNumber to set
	 */
	public void setDebitsReversalNumber(String debitsReversalNumber)
	{
		this.debitsReversalNumber = debitsReversalNumber;
	}

	/**
	 * Returns the transferNumber.
	 *
	 * @return the transferNumber.
	 */
	public String getTransferNumber()
	{
		return transferNumber;
	}

	/**
	 * Sets the transferNumber.
	 *
	 * @param transferNumber the transferNumber to set
	 */
	public void setTransferNumber(String transferNumber)
	{
		this.transferNumber = transferNumber;
	}

	/**
	 * Returns the transferReversalNumber.
	 *
	 * @return the transferReversalNumber.
	 */
	public String getTransferReversalNumber()
	{
		return transferReversalNumber;
	}

	/**
	 * Sets the transferReversalNumber.
	 *
	 * @param transferReversalNumber the transferReversalNumber to set
	 */
	public void setTransferReversalNumber(String transferReversalNumber)
	{
		this.transferReversalNumber = transferReversalNumber;
	}

	/**
	 * Returns the inquiriesNumber.
	 *
	 * @return the inquiriesNumber.
	 */
	public String getInquiriesNumber()
	{
		return inquiriesNumber;
	}

	/**
	 * Sets the inquiriesNumber.
	 *
	 * @param inquiriesNumber the inquiriesNumber to set
	 */
	public void setInquiriesNumber(String inquiriesNumber)
	{
		this.inquiriesNumber = inquiriesNumber;
	}

	/**
	 * Returns the authorizationsNumber.
	 *
	 * @return the authorizationsNumber.
	 */
	public String getAuthorizationsNumber()
	{
		return authorizationsNumber;
	}

	/**
	 * Sets the authorizationsNumber.
	 *
	 * @param authorizationsNumber the authorizationsNumber to set
	 */
	public void setAuthorizationsNumber(String authorizationsNumber)
	{
		this.authorizationsNumber = authorizationsNumber;
	}

	/**
	 * Returns the originalDataElements.
	 *
	 * @return the originalDataElements.
	 */
	public String getOriginalDataElements()
	{
		return originalDataElements;
	}

	/**
	 * Sets the originalDataElements.
	 *
	 * @param originalDataElements the originalDataElements to set
	 */
	public void setOriginalDataElements(String originalDataElements)
	{
		this.originalDataElements = originalDataElements;
	}

	/**
	 * Returns the fileUpdateCode.
	 *
	 * @return the fileUpdateCode.
	 */
	public String getFileUpdateCode()
	{
		return fileUpdateCode;
	}

	/**
	 * Sets the fileUpdateCode.
	 *
	 * @param fileUpdateCode the fileUpdateCode to set
	 */
	public void setFileUpdateCode(String fileUpdateCode)
	{
		this.fileUpdateCode = fileUpdateCode;
	}

	/**
	 * Returns the replacementAmounts.
	 *
	 * @return the replacementAmounts.
	 */
	public String getReplacementAmounts()
	{
		return replacementAmounts;
	}

	/**
	 * Sets the replacementAmounts.
	 *
	 * @param replacementAmounts the replacementAmounts to set
	 */
	public void setReplacementAmounts(String replacementAmounts)
	{
		this.replacementAmounts = replacementAmounts;
	}

	/**
	 * Returns the amount_net_settle.
	 *
	 * @return the amount_net_settle.
	 */
	public String getAmountNetSettle()
	{
		return amountNetSettle;
	}

	/**
	 * Sets the amount_net_settle.
	 *
	 * @param amountNetSettle the amount_net_settle to set
	 */
	public void setAmountNetSettle(String amountNetSettle)
	{
		this.amountNetSettle = amountNetSettle;
	}

	/**
	 * Returns the payee.
	 *
	 * @return the payee.
	 */
	public String getPayee()
	{
		return payee;
	}

	/**
	 * Sets the payee.
	 *
	 * @param payee the payee to set
	 */
	public void setPayee(String payee)
	{
		this.payee = payee;
	}

	/**
	 * Returns the receivingInstitutionIdCode.
	 *
	 * @return the receivingInstitutionIdCode.
	 */
	public String getReceivingInstitutionIdCode()
	{
		return receivingInstitutionIdCode;
	}

	/**
	 * Sets the receivingInstitutionIdCode.
	 *
	 * @param receivingInstitutionIdCode the receivingInstitutionIdCode to set
	 */
	public void setReceivingInstitutionIdCode(String receivingInstitutionIdCode)
	{
		this.receivingInstitutionIdCode = receivingInstitutionIdCode;
	}

	/**
	 * Returns the fileName.
	 *
	 * @return the fileName.
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * Sets the fileName.
	 *
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * Returns the accountIdentification1.
	 *
	 * @return the accountIdentification1.
	 */
	public String getAccountIdentification1()
	{
		return accountIdentification1;
	}

	/**
	 * Sets the accountIdentification1.
	 *
	 * @param accountIdentification1 the accountIdentification1 to set
	 */
	public void setAccountIdentification1(String accountIdentification1)
	{
		this.accountIdentification1 = accountIdentification1;
	}

	/**
	 * Returns the accountIdentification2.
	 *
	 * @return the accountIdentification2.
	 */
	public String getAccountIdentification2()
	{
		return accountIdentification2;
	}

	/**
	 * Sets the accountIdentification2.
	 *
	 * @param accountIdentification2 the accountIdentification2 to set
	 */
	public void setAccountIdentification2(String accountIdentification2)
	{
		this.accountIdentification2 = accountIdentification2;
	}

	/**
	 * Returns the posDataCode.
	 *
	 * @return the posDataCode.
	 */
	public String getPosDataCode()
	{
		return posDataCode;
	}

	/**
	 * Sets the posDataCode.
	 *
	 * @param posDataCode the posDataCode to set
	 */
	public void setPosDataCode(String posDataCode)
	{
		this.posDataCode = posDataCode;
	}
}
