import { createContext, useState } from "react";


export const CartContext = createContext({
    items: [],
    getProductAmount: () => {},
    addOneToCart: () => {},
    removeOneFromCart: () => {},
    deleteFromCart: () => {},
    getTotalCost: () => {},
});

export function CartProvider({children, getSetData}){

    const [cartProducts, setCartProducts] = useState([]);

    function getProductAmount(legoSetId){
        const amount = cartProducts.find(product => product.legoSetId === legoSetId)?.amount;
        if(amount === undefined){
            return 0;
        }
        return amount;
    }

    function addOneToCart(lego){
        const amount = getProductAmount(lego.legoSetId);
        if(amount === 0){
            setCartProducts(
                [
                    ...cartProducts,
                    {
                        ...lego,
                        amount: 1
                    }
                ]
            )
        }
        else{
            setCartProducts(
                cartProducts.map(
                    product => product.legoSetId === lego.legoSetId?
                    {...product, amount: product.amount + 1}
                    : product
                )
            )
        }
    }

    function deleteFromCart(legoSetId){
        setCartProducts(
            cartProducts => 
            cartProducts.filter(currentProduct => {
                return currentProduct.legoSetId != legoSetId;
            })
        )
    }

    function removeOneFromCart(legoSetId){
        const amount = getProductAmount(legoSetId);
        if(amount == 1){
            deleteFromCart(legoSetId);
        }
        else{
            setCartProducts(
                cartProducts.map(
                    product => product.legoSetId === legoSetId?
                    {...product, amount: product.amount -1 }
                    : product
                )
            )
        }
    }

    function getTotalCost(){
        let totalCost = 0 ;
        cartProducts.map((cartItem) => {
            const productData = getSetData(cartItem.legoSetId);
            totalCost += (productData?.price * cartItem.amount);
        });
        return totalCost;
    }

  

    const contextValue = {
        items: cartProducts,
        getProductAmount,
        addOneToCart,
        removeOneFromCart,
        deleteFromCart,
        getTotalCost,
        getSetData,

    }
    return(
        <CartContext.Provider value = {contextValue}>
            {children}
        </CartContext.Provider>
    )
}
export default CartProvider;