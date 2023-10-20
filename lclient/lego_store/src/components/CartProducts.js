
import { CartContext } from "../CartContext";
import { useContext } from "react";



function CartProducts(props){
    const cart = useContext(CartContext);
    const legoSetId = props.legoSetId;
    const amount= props.amount;
    const legoData = cart.getSetData(legoSetId);
    
    return(
        <>
        <h3>{legoData?.setName}</h3>
        <p>{amount} total</p>
        <p>${(amount * legoData?.price).toFixed(2)}</p>
        <hr></hr>
        </>
    )


}
export default CartProducts;