/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.sample;

import com.liferay.commerce.payment.method.paypal.internal.PayPalCommercePaymentIntegration;
import com.liferay.petra.string.StringBundler;

import com.paypal.core.PayPalHttpClient;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Crescenzo Rega
 */
@RequestMapping("/authorize")
@RestController
public class AuthorizeRestController extends BaseRestController {

	@PostMapping
	public ResponseEntity<String> post(
		@AuthenticationPrincipal Jwt jwt, @RequestBody String json) {

		log(jwt, _log, json);

		String errorMessages = null;
		String paymentStatus = CommercePaymentEntryConstants.STATUS_FAILED;
		String redirectURL = null;
		String transactionCode = null;

		try {
			JSONObject jsonObject = new JSONObject(json);

			JSONObject commercePaymentEntryJSONObject =
				jsonObject.getJSONObject("commercePaymentEntry");

			JSONObject paypalEnabled = jsonObject.getBoolean("payPalEnabled");

			if(paypalEnabled) {
				PayPalCommercePaymentIntegration.authorize(httpServletRequest, commercePaymentEntry);
			} 

			JSONObject typeSettingsJSONObject = jsonObject.getJSONObject(
				"typeSettings");

			//this is only needed if we cannot find the settings already
			String clientId = typeSettingsJSONObject.getString("clientId");
			String clientSecret = typeSettingsJSONObject.getString("clientSecret");
			String merchantId = typeSettingsJSONObject.getString("merchantId");
			String mode = typeSettingsJSONObject.getString("mode");

			//set up http client with paypal
			PayPalHttpClient payPalHttpClient = null;

			if (Objects.equals(
				mode,
				PayPalCommercePaymentMethodConstants.MODE_LIVE)) {

				payPalHttpClient = new PayPalHttpClient(
					new PayPalEnvironment.Live(clientId, clientSecret));
			} else {
				payPalHttpClient = new PayPalHttpClient(
					new PayPalEnvironment.Sandbox(clientId, clientSecret));
			}

//
//			if (Objects.equals(session.getStatus(), "open")) {
//				paymentStatus = "2";
//				redirectURL = session.getUrl();
//				transactionCode = session.getId();
		}
		catch (Exception exception) {
			errorMessages = ExceptionUtils.getStackTrace(exception);

			_log.error(errorMessages);
		}

		return new ResponseEntity<>(
			new JSONObject(
			).put(
				"errorMessages", errorMessages
			).put(
				"redirectURL", redirectURL
			).put(
				"paymentStatus", paymentStatus
			).put(
				"transactionCode", transactionCode
			).toString(),
			HttpStatus.OK);
	}

	/*
	private Session _createSession(
			JSONObject commercePaymentEntryJSONObject, Jwt jwt)
		throws Exception {

		SessionCreateParams sessionCreateParams = null;

		if (Objects.equals(
				commercePaymentEntryJSONObject.getString("className"),
				"com.liferay.commerce.model.CommerceOrder")) {

			JSONObject orderJSONObject = new JSONObject(
				Objects.requireNonNull(
					WebClient.create(
					).get(
					).uri(
						StringBundler.concat(
							lxcDXPServerProtocol, "://", lxcDXPMainDomain,
							"/o/headless-commerce-admin-order/v1.0/orders/",
							commercePaymentEntryJSONObject.getLong("classPK"),
							"?nestedFields=orderItems")
					).accept(
						MediaType.APPLICATION_JSON
					).header(
						HttpHeaders.AUTHORIZATION,
						"Bearer " + jwt.getTokenValue()
					).retrieve(
					).bodyToMono(
						String.class
					).block()));

			sessionCreateParams = SessionCreateParams.builder(
			).addAllLineItem(
				_getLineItems(
					orderJSONObject.getString("currencyCode"),
					commercePaymentEntryJSONObject.getString("languageId"),
					orderJSONObject.getJSONArray("orderItems"))
			).addPaymentMethodType(
				SessionCreateParams.PaymentMethodType.CARD
			).addShippingOption(
				_getShippingOption(
					orderJSONObject.getString("currencyCode"),
					orderJSONObject.getLong("shippingAmountValue"),
					orderJSONObject.getString("shippingOption"))
			).setCancelUrl(
				commercePaymentEntryJSONObject.getString("cancelURL")
			).setCurrency(
				orderJSONObject.getString("currencyCode")
			).setMode(
				SessionCreateParams.Mode.PAYMENT
			).setSuccessUrl(
				commercePaymentEntryJSONObject.getString("callbackURL")
			).build();
		}
		else {
			sessionCreateParams = SessionCreateParams.builder(
			).addAllLineItem(
				_getLineItems(commercePaymentEntryJSONObject)
			).addPaymentMethodType(
				SessionCreateParams.PaymentMethodType.CARD
			).setCancelUrl(
				commercePaymentEntryJSONObject.getString("cancelURL")
			).setCurrency(
				commercePaymentEntryJSONObject.getString("currencyCode")
			).setMode(
				SessionCreateParams.Mode.PAYMENT
			).setSuccessUrl(
				commercePaymentEntryJSONObject.getString("callbackURL")
			).build();
		}

		return Session.create(sessionCreateParams);
	}
 */

	private static final Log _log = LogFactory.getLog(
		AuthorizeRestController.class);

}