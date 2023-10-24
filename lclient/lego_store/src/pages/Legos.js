import React, { useContext } from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import logo from "../images/icon.png";
import age from "../images/ages.jpg";
import star from "../images/star3.png";
import Button from 'react-bootstrap/Button';
import { CartContext } from '../CartContext';
import { Form } from 'react-bootstrap';
import { motion } from "framer-motion";


function Legos({legos, getSetData}) {
  const cart = useContext(CartContext);

  
  
  
    return (
    
        <div className="container">
          <Row>
            {legos.map(lego => (
              <Col key={lego.legoSetId} xs={12} md={4} style={{ marginBottom: '20px' }}>
                <Card style={{ width: '100%', height: '100%', display: 'flex', flexDirection: 'column' }}>
                  <Card.Img
                    variant="top"
                    src={lego.imageUrl}
                    alt={`${lego.setName} Image`}
                    style={{ height: '100%', objectFit: 'contain' }}
                  />
                  <Card.Body style={{ textAlign: 'center' }}>
                    <Card.Title>{lego.setName}&nbsp;&nbsp;&nbsp;&nbsp; {lego.price}</Card.Title>
                    <Card.Text>{lego.description}</Card.Text>
                    <Card.Text>
                      <img src={logo} alt="Logo" style={{ width: '50px', height: '50px', marginRight: '10px' }} /> {lego.amountOfPieces} 
                      <img src={age} alt="Logo" style={{ width: '30px', height: '30px', margin: '0 10px' }} /> {lego.ages} 
                      <img src={star} alt="Logo" style={{ width: '30px', height: '30px', marginLeft: '10px' }} />  {lego.rating}&nbsp;
                     
                    </Card.Text>
                    <Card.Text>
                    {cart.getProductAmount(lego.legoSetId) > 0 ?
                      <>
                      <Form as ={Row}>
                        <Form.Label column = "true" sm="6">In Cart</Form.Label>
                        <Col sm="6">
                        <motion.button
                          whileHover={{ scale: 1.5 }} 
                          className="mx-2"
                          style={{
                            backgroundColor: 'yellow', 
                            borderRadius: '10px',   
                          }}
                          onClick={() => cart.addOneToCart(lego)}
                        >
                          +
                        </motion.button>
                        <motion.button
                          whileHover={{ scale: 1.5 }} 
                          className="mx-2"
                          style={{
                            backgroundColor: 'yellow', 
                            borderRadius: '10px',   
                          }}
                          onClick={() => cart.removeOneFromCart(lego.legoSetId)}
                        >
                          -
                        </motion.button>
                        </Col>
                      </Form>
                      </>:
                      <motion.button
                      whileHover={{ scale: 1.3 }} 
                      className="mx-2"
                      style={{
                        backgroundColor: 'yellow', 
                        borderRadius: '10px',   
                      }}
                      onClick={() => cart.addOneToCart(lego)}
                    >
                      Add to cart
                    </motion.button>
                     
                      }
                    </Card.Text>
                  </Card.Body>
                </Card>
              </Col>
            ))}
          </Row>
        </div>
     
    );
  }
  
  export default Legos;