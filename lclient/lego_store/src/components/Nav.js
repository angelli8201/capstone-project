import { Link } from 'react-router-dom';
import logo from "../images/LEGO_logo.svg.png";
import { Modal, ModalHeader } from 'react-bootstrap';
import { useState, useContext } from 'react';
import { CartContext } from '../CartContext';
import CartProducts from './CartProducts';



function Nav() {
    const linkStyle = {
        fontSize: '24px',   
        color: 'black',     
        textDecoration: 'none',  
        marginRight: '20px',
        
    };
    const checkout = async() => {
        await fetch('http://localhost:4000/create-checkout-session',{
            method:"POST",
            headers : {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({items: cart.items})
        }).then((response) => {
            return response.json();
        }).then((response) => {
            if(response.url){
                window.location.assign(response.url);
            }
        })
    }

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const cart = useContext(CartContext);

    const productsCount = cart.items.reduce((sum,product) => sum + product.amount,0);

    return (
        <div className="d-flex justify-content-around">
            <ul className="nav my-4">
                
                <li className='nav-item'>
                    <Link className='nav-link' to='/'>
                        <img src={logo} alt="Logo" style={{ width: '50px', height: '50px' }} />
                    </Link>
                </li>

                <li className='nav-item'>
                    <Link style={linkStyle} className='nav-link' to='/'>
                        Home
                    </Link>
                </li>
                <li className='nav-item'>
                    <Link style={linkStyle} className='nav-link' to='/themes'>
                        Themes
                    </Link>
                </li>
                <li className='nav-item'>
                    <Link style={linkStyle} className='nav-link' to='/legos'>
                        Lego Sets
                    </Link>
                </li>
                <li className='nav-item'>
                    <Link style={linkStyle} className='nav-link' to='/figures'>
                        Lego Mini Figures
                    </Link>
                </li>
                <li className='nav-item'>
                    <Link style={linkStyle} className='nav-link' to='/news'>
                        Lego News
                    </Link>
                </li>
                
                <li className='nav-item'>
                    <button onClick = {handleShow}style= {{background: 'transparent', border: 'none'}}>
                        <Link className='nav-link' style={{ color: 'black' }}>
                        <img
                            width='30'
                            alt='Shopping cart'
                            src='https://www.freepnglogos.com/uploads/shopping-cart-png/shopping-cart-svg-png-icon-download-28.png'
                        />
                        &nbsp;&nbsp; ({productsCount} Items)
                        </Link>
                    </button>
                </li>
            </ul>
            <Modal show = {show} onHide = {handleClose}>
                <ModalHeader closeButton>
                    <Modal.Title>Shopping Summary</Modal.Title>
                </ModalHeader>
                <Modal.Body>
                    {productsCount > 0 ? 
                    <>
                    <p>Items in your cart:</p>
                    {cart.items.map((currentProduct,idx) =>(
                        <CartProducts key={idx} legoSetId= {currentProduct.legoSetId} amount = {currentProduct.amount}></CartProducts>
                    ) )}
                    <h1>Total: {cart.getTotalCost().toFixed(2)}</h1>
                    <button type="button" className="btn btn-success" onClick= {checkout}> Checkout</button>
                    </>
                    :
                    <h1>Your shopping cart is empty!</h1>
                    }
                    </Modal.Body>
            </Modal>
        </div>
    );
}

export default Nav;