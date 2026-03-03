const stripe = Stripe('pk_test_51T6VD6EmH8vQoqr0DGr7g3234Di9X60m89gCK4eWbDjMAsivbUAAXpyLWLfxhL75OJZAo5ncY6h8ZrMnsiKobpUp00EfRvrrr4');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});