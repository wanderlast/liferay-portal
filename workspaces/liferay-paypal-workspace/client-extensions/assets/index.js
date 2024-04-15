/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

export default function CommerceCheckoutStep() {
	const commerceCheckoutStepContainer = document.getElementById(
		'_com_liferay_commerce_checkout_web_internal_portlet_CommerceCheckoutPortlet_commerceCheckoutStepContainer'
	);

	const newDiv = document.createElement("paypal-button-container");

	const inputName =
		'_com_liferay_commerce_checkout_web_internal_portlet_CommerceCheckoutPortlet_pon';

	var script1 = document.createElement( 'script' );
	var script2 = document.createElement( 'script' );
	script1.setAttribute( 'src', "https://www.paypal.com/sdk/js?client-id=AbYFv5Emsgk85LbhRSu3Hp4ur-9YJdTBz27bWRYD0EnrGxN4BZxWD77upJ8tTQ2W2dbJ-Ln0CdVFaPXj&currency=USD" );
	var code = `window.paypal
	.Buttons({
	  async createOrder() {
		try {
		  const response = await fetch("/api/orders", {
			method: "POST",
			headers: {
			  "Content-Type": "application/json",
			},
			// use the "body" param to optionally pass additional order information
			// like product ids and quantities
			body: JSON.stringify({
			  cart: [
				{
				  id: "YOUR_PRODUCT_ID",
				  quantity: "YOUR_PRODUCT_QUANTITY",
				},
			  ],
			}),
		  });
		  
		  const orderData = await response.json();
		  
		  if (orderData.id) {
			return orderData.id;
		  } else {
			const errorDetail = orderData?.details?.[0];
			const errorMessage = errorDetail
			  ? \`\${errorDetail.issue} \${errorDetail.description} (\${orderData.debug_id})\`
			  : JSON.stringify(orderData);
			
			throw new Error(errorMessage);
		  }
		} catch (error) {
		  console.error(error);
		  resultMessage(\`Could not initiate PayPal Checkout...<br><br>\${error}\`);
		}
	  },
	  async onApprove(data, actions) {
		try {
		  const response = await fetch(\`/api/orders/\${data.orderID}/capture\`, {
			method: "POST",
			headers: {
			  "Content-Type": "application/json",
			},
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
			throw new Error(\`\${errorDetail.description} (\${orderData.debug_id})\`);
		  } else if (!orderData.purchase_units) {
			throw new Error(JSON.stringify(orderData));
		  } else {
			// (3) Successful transaction -> Show confirmation or thank you message
			// Or go to another URL:  actions.redirect('thank_you.html');
			const transaction =
			  orderData?.purchase_units?.[0]?.payments?.captures?.[0] ||
			  orderData?.purchase_units?.[0]?.payments?.authorizations?.[0];
			resultMessage(
			  \`Transaction \${transaction.status}: \${transaction.id}<br><br>See console for all available details\`,
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
			\`Sorry, your transaction could not be processed...<br><br>\${error}\`,
		  );
		}
	  },
	})
	.render("#paypal-button-container");`;
	script1.appendChild(document.createTextNode(code));
	newDiv.appendChild( script1 );

	newDiv.setAttribute('id', inputName);
	newDiv.setAttribute('name', inputName);

	commerceCheckoutStepContainer.appendChild(newDiv);
}
