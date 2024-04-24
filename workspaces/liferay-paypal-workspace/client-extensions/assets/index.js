/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import { getPaymentMethodsByCart, postCartByChannelId } from "./liferayServices";

export default function CommerceCheckoutStep() {
	const commerceCheckoutStepContainer = document.getElementById(
		'_com_liferay_commerce_checkout_web_internal_portlet_CommerceCheckoutPortlet_commerceCheckoutStepContainer'
	);

	const paypalDiv = document.createElement('div');
	paypalDiv.setAttribute('id', "paypal-button-container");

	const resultMessage = document.createElement('p');
	resultMessage.setAttribute('id', "result-message");

	const paypalScript = document.createElement('script');
	//this is hard-coded for now, we'll accept arguments later
	let clientId = "AbYFv5Emsgk85LbhRSu3Hp4ur-9YJdTBz27bWRYD0EnrGxN4BZxWD77upJ8tTQ2W2dbJ-Ln0CdVFaPXj";

	const accountId = Liferay.CommerceContext.account?.accountId;
	const channelId = Liferay.CommerceContext.commerceChannelId;

	if (channelId == null || accountId == null) {
		//handle this later, but this means we need to default to typesettings I think?
		console.log("channelId or accountId is null");		
	}

	let cartsResponse = postCartByChannelId(accountId, channelId);

	//get cartid from first json response
	let json = JSON.parse(cartsResponse);
	let cartId = json.id;

	console.log("CartId is " + cartId);

	let paymentResponse = getPaymentMethodsByCart(cartId);
	json = JSON.parse(paymentResponse);
	let items = json.items;
	console.log("items are " + items);

	let paypalEnabled = false;

	//parse the json for payment methods
	for (var i = 0; i < items.length; i++) {
		//this is the default key name for the default paypal integration, I don't know if it's possible to change
		if (items[i].key === 'paypal-integration') {
			//paypal is active, we know that it's available -- this is the info we care about passing to our Rest Controllers
			paypalEnabled = true;
			console.log("Paypal Enabled");
		}
	}

	paypalScript.setAttribute('src', "https://www.paypal.com/sdk/js?client-id=" + clientId + "&currency=USD");
	paypalScript.addEventListener('load', () => {
		window.paypal
		.Buttons({
		  async createOrder() {
			try {
			  const response = await fetch("/set-up-payment", {
				method: "POST",
				headers: {
				  "Content-Type": "application/json",
				},
				// use the "body" param to optionally pass additional order information
				// like product ids and quantities
				body: JSON.stringify({
				  paypalEnabled: paypalEnabled
				}),
			  });
			  
			  const orderData = await response.json();
			  
			  if (orderData.id) {
				return orderData.id;
			  } else {
				const errorDetail = orderData?.details?.[0];
				const errorMessage = errorDetail
				  ? `${errorDetail.issue} ${errorDetail.description} (${orderData.debug_id})`
				  : JSON.stringify(orderData);
				
				throw new Error(errorMessage);
			  }
			} catch (error) {
			  console.error(error);
			  resultMessage(`Could not initiate PayPal Checkout...<br><br>${error}`);
			}
		  },
		  async onApprove(data, actions) {
			try {
			  const response = await fetch(`/capture`, {
				method: "POST",
				headers: {
				  "Content-Type": "application/json",
				},
				body: {
					paypalEnabled: paypalEnabled
				}
			  });
			  
			  const orderData = await response.json();
			  // Three cases to handle:
			  //   (1) Recoverable INSTRUMENT_DECLINED -> call actions.restart()
			  //   (2) Other non-recoverable errors -> Show a failure message
			  //   (3) Successful transaction -> Show confirmation or thank you message
			  
			  const errorDetail = orderData?.details?.[0];
			  
			  if (errorDetail?.issue === "INSTRUMENT_DECLINED") {
				// (1) Recoverable INSTRUMENT_DECLINED -> call actions.restart()
				// recoverable state, per https://developer.paypal.com/docs/checkout/standard/customize/handle-funding-failures/
				return actions.restart();
			  } else if (errorDetail) {
				// (2) Other non-recoverable errors -> Show a failure message
				throw new Error(`${errorDetail.description} (${orderData.debug_id})`);
			  } else if (!orderData.purchase_units) {
				throw new Error(JSON.stringify(orderData));
			  } else {
				// (3) Successful transaction -> Show confirmation or thank you message
				// Or go to another URL:  actions.redirect('thank_you.html');
				const transaction =
				  orderData?.purchase_units?.[0]?.payments?.captures?.[0] ||
				  orderData?.purchase_units?.[0]?.payments?.authorizations?.[0];
				resultMessage(
				  `Transaction ${transaction.status}: ${transaction.id}<br><br>See console for all available details`,
				);
				console.log(
				  "Capture result",
				  orderData,
				  JSON.stringify(orderData, null, 2),
				);
			  }
			} catch (error) {
			  console.error(error);
			  resultMessage(
				`Sorry, your transaction could not be processed...<br><br>\${error}`,
			  );
			}
		  },
		})
		.render("#paypal-button-container");
	})

	commerceCheckoutStepContainer.appendChild(paypalDiv);
	commerceCheckoutStepContainer.appendChild(resultMessage);
	commerceCheckoutStepContainer.appendChild(paypalScript);
}

// Example function to show a result to the user. Your site's UI library can be used instead.
function resultMessage(message) {
  const container = document.querySelector("#result-message");
  container.innerHTML = message;
}