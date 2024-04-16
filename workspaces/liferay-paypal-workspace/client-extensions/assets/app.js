import { PayPalScriptProvider } from "@paypal/react-paypal-js";

//these should be edited later
const initialOptions = {
  clientId: "AbYFv5Emsgk85LbhRSu3Hp4ur-9YJdTBz27bWRYD0EnrGxN4BZxWD77upJ8tTQ2W2dbJ-Ln0CdVFaPXj",
  currency: "USD",
  intent: "capture",
};

export default function App() {
  return (
      <PayPalScriptProvider options={initialOptions}>
          <PayPalButtons />
      </PayPalScriptProvider>
  );
}