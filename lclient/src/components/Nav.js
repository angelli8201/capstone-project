import { Link } from 'react-router-dom';
import logo from "../images/LEGO_logo.svg.png";

function Nav() {
    const linkStyle = {
        fontSize: '24px',   
        color: 'black',     
        textDecoration: 'none',  
        marginRight: '20px',
        
    };

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
                    <Link className='nav-link' to='/'>
                    <img
						width='30'
						alt='Shopping cart'
						src='https://www.freepnglogos.com/uploads/shopping-cart-png/shopping-cart-svg-png-icon-download-28.png'
					/>
                    </Link>
                </li>
            </ul>
        </div>
    );
}

export default Nav;