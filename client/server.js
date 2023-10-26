
const express = require('express');
var cors = require('cors');
const stripe = require('stripe')('sk_test_51O2y3IAu3cUStmz7uugekvLWpPaJUGcO8X6agEaeDfOCLIEZxkTMhFQxBllKh2L2yUafJf8mXkAIlwCqvzIxCbuG00KTgjs7qu');

const app = express();
app.use(cors());
app.use(express.static("public"));
app.use(express.json());

app.post('/create-checkout-session', async (req, res) => {
    const items = req.body.items;
    let lineItems = [];
    console.log(req.body);
    items.forEach((item) => {
        lineItems.push({
            quantity: item.amount,
            price_data: {
                currency: 'usd',
                unit_amount: item.price * 100,
                product_data: {
                  name: item.setName,
                  images: [item.imageUrl],
                },
              },
        });
    });

   

    const session = await stripe.checkout.sessions.create({
        shipping_options: [
            {
              shipping_rate_data: {
                type: 'fixed_amount',
                fixed_amount: {
                  amount: 0,
                  currency: 'usd',
                },
                display_name: 'Free shipping',
                delivery_estimate: {
                  minimum: {
                    unit: 'business_day',
                    value: 5,
                  },
                  maximum: {
                    unit: 'business_day',
                    value: 7,
                  },
                },
              },
            },
            {
              shipping_rate_data: {
                type: 'fixed_amount',
                fixed_amount: {
                  amount: 1500,
                  currency: 'usd',
                },
                display_name: 'Next day air',
                delivery_estimate: {
                  minimum: {
                    unit: 'business_day',
                    value: 1,
                  },
                  maximum: {
                    unit: 'business_day',
                    value: 1,
                  },
                },
              },
            },
          ],
        line_items: lineItems,
        mode: 'payment',
        success_url: "http://localhost:3000/success",
        cancel_url: "http://localhost:3000/"
    });

    res.send(JSON.stringify({
        url: session.url
    }));
});


app.listen(4000, () => console.log("Listening on port 4000"));
