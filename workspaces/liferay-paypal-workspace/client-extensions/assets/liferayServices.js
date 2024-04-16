 const headers = {
	'Content-Type': 'application/json',
	'X-CSRF-Token': Liferay.authToken,
};

export const baseURL =
	window.location.origin + Liferay.ThemeDisplay.getPathContext();

const scopeGroupId = Liferay.ThemeDisplay.getScopeGroupId();

export async function getChannels() {
	const response = await fetch(
		`${baseURL}/o/headless-commerce-admin-channel/v1.0/channels`,
		{
			headers,
			method: 'GET',
		}
	);

	return await response.json();
}

export async function getPaymentMethods({
    cartId,
}) {
    const response = await fetch(
        `${baseURL}/o/headless-commerce-delivery-cart/v1.0/carts/${cartId}/payment-methods`,
        {
            headers,
            method: 'GET',
        }
    )
}

export async function getScopeGroupIdChannel() {
    const response = await fetch(
        `${baseURL}/o/headless-commerce-admin-channel/v1.0/channels?filter=siteGroupId%20eq%20%27${scopeGroupId}%27`,
        {
            headers,
            method:'GET',
        }
    );

    return await response.json();
}

export async function postCartByChannelId({
	cartBody = {},
	channelId,
}) {
	const cartResponse = await fetch(
		`${baseURL}/o/headless-commerce-delivery-cart/v1.0/channels/${channelId}/carts`,
		{
			body: JSON.stringify(cartBody),
			headers,
			method: 'POST',
		}
	);

	return await cartResponse.json();
}